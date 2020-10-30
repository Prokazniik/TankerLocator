package ru.tanker.tankerlocator;

import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RemoteServer {
    private static final String TAG = "RemoteServer";

    private static final String BASE_URL = "https://services.marinetraffic.com/api/";
    private static final String KEY = "1d46e58382f63d54cb8a7fa962a58fd05e461528";
    
    public static final String SHIPS_COLLECTION = "ships";
    public static final String IMO_FIELD = "iMo";

    private MarineTrafficApi marineTrafficApi;

    public RemoteServer() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marineTrafficApi = retrofit.create(MarineTrafficApi.class);
    }

    public Observable<List<TankerModel>> getShips() {
        Log.d(TAG, "getShips() called");
        return marineTrafficApi.getAllShips(KEY);
    }

    public Observable<List<TankerModel>> getSavedShips() {
        Log.d(TAG, "getSavedShips() called");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        PublishSubject<List<TankerModel>> publishSubject = PublishSubject.create();
        db.collection(SHIPS_COLLECTION)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    List<TankerModel> ships = queryDocumentSnapshots.toObjects(TankerModel.class);
                    publishSubject.onNext(ships);
                    publishSubject.onComplete();
                });
        return publishSubject;
    }

    public Observable<Boolean> saveToBase(TankerModel tankerModel) {
        PublishSubject<Boolean> publishSubject = PublishSubject.create();
        Log.d(TAG, "saveToBase() called with: tankerModel = [" + tankerModel + "]");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(SHIPS_COLLECTION)
                .whereEqualTo(IMO_FIELD, tankerModel.getiMO())
                .get()
                .addOnSuccessListener(documentReference ->
                        db.collection(SHIPS_COLLECTION)
                                .document(documentReference.getDocuments().get(0).getId())
                                .delete()
                                .addOnSuccessListener(aVoid -> db.collection(SHIPS_COLLECTION)
                                        .add(tankerModel).addOnSuccessListener(documentReference1 ->
                                                publishSubject.onNext(true))))
                .addOnFailureListener(e ->
                        db.collection(SHIPS_COLLECTION)
                                .add(tankerModel)
                .addOnSuccessListener(documentReference ->
                        publishSubject.onNext(true)));
        return publishSubject;
    }

    private interface MarineTrafficApi {
        @GET("exportvessels/v:8/{key}/msgtype:extended/protocol:jsono/timespan:180")
        Observable<List<TankerModel>> getAllShips(@Path("key") String key);
    }

}
