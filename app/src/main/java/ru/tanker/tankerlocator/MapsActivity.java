package ru.tanker.tankerlocator;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap map;
    private View bottomSheetLayout;

    private RemoteServer remoteServer;
    private BottomSheetBehavior bottomSheetBehavior;
    private TextView shipNameTv;
    private TextView imoTv;
    private TextView coordTv;
    private TextView speedTv;
    private TextView headTv;
    private TextView courseTv;
    private TextView statusTv;
    private TextView lastUpdateTv;
    private Disposable disposable;
    private EditText searchEt;

    private List<TankerModel> ships = new ArrayList<>(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        bottomSheetLayout = findViewById(R.id.bottom_sheet_layout);
        shipNameTv = findViewById(R.id.ship_name_tv);
        imoTv = findViewById(R.id.imo_tv);
        coordTv = findViewById(R.id.coord_tv);
        speedTv = findViewById(R.id.speed_tv);
        headTv = findViewById(R.id.head_tv);
        courseTv = findViewById(R.id.course_tv);
        statusTv = findViewById(R.id.status_tv);
        lastUpdateTv = findViewById(R.id.last_update_tv);
        searchEt = findViewById(R.id.search_et);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        remoteServer = new RemoteServer();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (map != null) {
            map.clear();
            getData();
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        map.setOnMarkerClickListener(this);

        getData();
        setupSearch();
    }

    private void getData() {
        disposable = remoteServer.getShips()
                .onErrorResumeNext(Observable.just(new ArrayList<>(0)))
                .doOnError(Throwable::printStackTrace)
                .flatMapIterable(list -> list)
                .flatMap(ship -> remoteServer.saveToBase(ship))
                .toList()
                .toObservable()
                .flatMap(list -> remoteServer.getSavedShips())
                .map(list -> ships = list)
                .flatMapIterable(list -> list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::addShipToMap,
                        this::showError);
    }

    private void setupSearch() {
        searchEt.setOnEditorActionListener((view, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                view.setText("");
                String searchText = view.getText().toString().toLowerCase();
                for (TankerModel ship:
                     ships){
                    if (ship.getsHIPNAME().toLowerCase().contains(searchText)){
                        CameraUpdate camera = CameraUpdateFactory.newLatLng(new LatLng(ship.getlAT(), ship.getlON()));
                        map.animateCamera(camera);
                        return true;
                    }
                }
                Toast.makeText(this, R.string.not_found, Toast.LENGTH_SHORT).show();
            }
            return false;
        });
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }

    private void saveToBase(TankerModel tankerModel) {
        remoteServer.saveToBase(tankerModel);
    }

    private void showError(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_LONG).show();
    }

    private void addShipToMap(TankerModel tankerModel) {
        LatLng coord = new LatLng(tankerModel.getlAT(), tankerModel.getlON());
        MarkerOptions marker = new MarkerOptions()
                .position(coord)
                .title(tankerModel.getsHIPNAME());
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.ship));
        marker.rotation(tankerModel.gethEADING());
        map.addMarker(marker).setTag(tankerModel);
        map.moveCamera(CameraUpdateFactory.newLatLng(coord));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        TankerModel tankerModel = (TankerModel) marker.getTag();
        shipNameTv.setText(tankerModel.getsHIPNAME());
        imoTv.setText(String.valueOf(tankerModel.getiMO()));
        coordTv.setText(String.format("%s / %s", tankerModel.getlAT(), tankerModel.getlON()));
        speedTv.setText(String.format("%d kn", tankerModel.getsPEED()));
        headTv.setText(String.format("%d", tankerModel.gethEADING()));
        courseTv.setText(String.format("%d", tankerModel.getcOURSE()));
        statusTv.setText(Statuses.getStatusString(tankerModel.getsTATUS()));
        lastUpdateTv.setText(tankerModel.gettIMESTAMP());

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
        return true;
    }
}
