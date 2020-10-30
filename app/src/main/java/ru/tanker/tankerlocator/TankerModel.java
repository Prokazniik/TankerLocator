package ru.tanker.tankerlocator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TankerModel {
    @SerializedName("MMSI")
    @Expose
    private long mMSI;
    @SerializedName("IMO")
    @Expose
    private long iMO;
    @SerializedName("SHIP_ID")
    @Expose
    private long sHIPID;
    @SerializedName("LAT")
    @Expose
    private double lAT;
    @SerializedName("LON")
    @Expose
    private double lON;
    @SerializedName("SPEED")
    @Expose
    private int sPEED;
    @SerializedName("HEADING")
    @Expose
    private int hEADING;
    @SerializedName("COURSE")
    @Expose
    private int cOURSE;
    @SerializedName("STATUS")
    @Expose
    private int sTATUS;
    @SerializedName("TIMESTAMP")
    @Expose
    private String tIMESTAMP;
    @SerializedName("DSRC")
    @Expose
    private String dSRC;
    @SerializedName("UTC_SECONDS")
    @Expose
    private int uTCSECONDS;
    @SerializedName("SHIPNAME")
    @Expose
    private String sHIPNAME;
    @SerializedName("SHIPTYPE")
    @Expose
    private int sHIPTYPE;
    @SerializedName("CALLSIGN")
    @Expose
    private String cALLSIGN;
    @SerializedName("FLAG")
    @Expose
    private String fLAG;
    @SerializedName("LENGTH")
    @Expose
    private float lENGTH;
    @SerializedName("WIDTH")
    @Expose
    private float wIDTH;
    @SerializedName("GRT")
    @Expose
    private int gRT;
    @SerializedName("DWT")
    @Expose
    private int dWT;
    @SerializedName("DRAUGHT")
    @Expose
    private int dRAUGHT;
    @SerializedName("YEAR_BUILT")
    @Expose
    private int yEARBUILT;
    @SerializedName("ROT")
    @Expose
    private int rOT;
    @SerializedName("TYPE_NAME")
    @Expose
    private String tYPENAME;
    @SerializedName("AIS_TYPE_SUMMARY")
    @Expose
    private String aISTYPESUMMARY;
    @SerializedName("DESTINATION")
    @Expose
    private String dESTINATION;
    @SerializedName("ETA")
    @Expose
    private String eTA;
    @SerializedName("CURRENT_PORT")
    @Expose
    private String cURRENTPORT;
    @SerializedName("LAST_PORT")
    @Expose
    private String lASTPORT;
    @SerializedName("LAST_PORT_TIME")
    @Expose
    private String lASTPORTTIME;
    @SerializedName("CURRENT_PORT_ID")
    @Expose
    private long cURRENTPORTID;
    @SerializedName("CURRENT_PORT_UNLOCODE")
    @Expose
    private String cURRENTPORTUNLOCODE;
    @SerializedName("CURRENT_PORT_COUNTRY")
    @Expose
    private String cURRENTPORTCOUNTRY;
    @SerializedName("LAST_PORT_ID")
    @Expose
    private long lASTPORTID;
    @SerializedName("LAST_PORT_UNLOCODE")
    @Expose
    private String lASTPORTUNLOCODE;
    @SerializedName("LAST_PORT_COUNTRY")
    @Expose
    private String lASTPORTCOUNTRY;
    @SerializedName("NEXT_PORT_ID")
    @Expose
    private long nEXTPORTID;
    @SerializedName("NEXT_PORT_UNLOCODE")
    @Expose
    private String nEXTPORTUNLOCODE;
    @SerializedName("NEXT_PORT_NAME")
    @Expose
    private String nEXTPORTNAME;
    @SerializedName("NEXT_PORT_COUNTRY")
    @Expose
    private String nEXTPORTCOUNTRY;
    @SerializedName("ETA_CALC")
    @Expose
    private String eTACALC;
    @SerializedName("ETA_UPDATED")
    @Expose
    private String eTAUPDATED;
    @SerializedName("DISTANCE_TO_GO")
    @Expose
    private long dISTANCETOGO;
    @SerializedName("DISTANCE_TRAVELLED")
    @Expose
    private long dISTANCETRAVELLED;
    @SerializedName("AVG_SPEED")
    @Expose
    private float aVGSPEED;
    @SerializedName("MAX_SPEED")
    @Expose
    private float mAXSPEED;

    public long getmMSI() {
        return mMSI;
    }

    public void setmMSI(long mMSI) {
        this.mMSI = mMSI;
    }

    public long getiMO() {
        return iMO;
    }

    public void setiMO(long iMO) {
        this.iMO = iMO;
    }

    public long getsHIPID() {
        return sHIPID;
    }

    public void setsHIPID(long sHIPID) {
        this.sHIPID = sHIPID;
    }

    public double getlAT() {
        return lAT;
    }

    public void setlAT(double lAT) {
        this.lAT = lAT;
    }

    public double getlON() {
        return lON;
    }

    public void setlON(double lON) {
        this.lON = lON;
    }

    public int getsPEED() {
        return sPEED;
    }

    public void setsPEED(int sPEED) {
        this.sPEED = sPEED;
    }

    public int gethEADING() {
        return hEADING;
    }

    public void sethEADING(int hEADING) {
        this.hEADING = hEADING;
    }

    public int getcOURSE() {
        return cOURSE;
    }

    public void setcOURSE(int cOURSE) {
        this.cOURSE = cOURSE;
    }

    public int getsTATUS() {
        return sTATUS;
    }

    public void setsTATUS(int sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String gettIMESTAMP() {
        return tIMESTAMP;
    }

    public void settIMESTAMP(String tIMESTAMP) {
        this.tIMESTAMP = tIMESTAMP;
    }

    public String getdSRC() {
        return dSRC;
    }

    public void setdSRC(String dSRC) {
        this.dSRC = dSRC;
    }

    public int getuTCSECONDS() {
        return uTCSECONDS;
    }

    public void setuTCSECONDS(int uTCSECONDS) {
        this.uTCSECONDS = uTCSECONDS;
    }

    public String getsHIPNAME() {
        return sHIPNAME;
    }

    public void setsHIPNAME(String sHIPNAME) {
        this.sHIPNAME = sHIPNAME;
    }

    public int getsHIPTYPE() {
        return sHIPTYPE;
    }

    public void setsHIPTYPE(int sHIPTYPE) {
        this.sHIPTYPE = sHIPTYPE;
    }

    public String getcALLSIGN() {
        return cALLSIGN;
    }

    public void setcALLSIGN(String cALLSIGN) {
        this.cALLSIGN = cALLSIGN;
    }

    public String getfLAG() {
        return fLAG;
    }

    public void setfLAG(String fLAG) {
        this.fLAG = fLAG;
    }

    public float getlENGTH() {
        return lENGTH;
    }

    public void setlENGTH(float lENGTH) {
        this.lENGTH = lENGTH;
    }

    public float getwIDTH() {
        return wIDTH;
    }

    public void setwIDTH(float wIDTH) {
        this.wIDTH = wIDTH;
    }

    public int getgRT() {
        return gRT;
    }

    public void setgRT(int gRT) {
        this.gRT = gRT;
    }

    public int getdWT() {
        return dWT;
    }

    public void setdWT(int dWT) {
        this.dWT = dWT;
    }

    public int getdRAUGHT() {
        return dRAUGHT;
    }

    public void setdRAUGHT(int dRAUGHT) {
        this.dRAUGHT = dRAUGHT;
    }

    public int getyEARBUILT() {
        return yEARBUILT;
    }

    public void setyEARBUILT(int yEARBUILT) {
        this.yEARBUILT = yEARBUILT;
    }

    public int getrOT() {
        return rOT;
    }

    public void setrOT(int rOT) {
        this.rOT = rOT;
    }

    public String gettYPENAME() {
        return tYPENAME;
    }

    public void settYPENAME(String tYPENAME) {
        this.tYPENAME = tYPENAME;
    }

    public String getaISTYPESUMMARY() {
        return aISTYPESUMMARY;
    }

    public void setaISTYPESUMMARY(String aISTYPESUMMARY) {
        this.aISTYPESUMMARY = aISTYPESUMMARY;
    }

    public String getdESTINATION() {
        return dESTINATION;
    }

    public void setdESTINATION(String dESTINATION) {
        this.dESTINATION = dESTINATION;
    }

    public String geteTA() {
        return eTA;
    }

    public void seteTA(String eTA) {
        this.eTA = eTA;
    }

    public String getcURRENTPORT() {
        return cURRENTPORT;
    }

    public void setcURRENTPORT(String cURRENTPORT) {
        this.cURRENTPORT = cURRENTPORT;
    }

    public String getlASTPORT() {
        return lASTPORT;
    }

    public void setlASTPORT(String lASTPORT) {
        this.lASTPORT = lASTPORT;
    }

    public String getlASTPORTTIME() {
        return lASTPORTTIME;
    }

    public void setlASTPORTTIME(String lASTPORTTIME) {
        this.lASTPORTTIME = lASTPORTTIME;
    }

    public long getcURRENTPORTID() {
        return cURRENTPORTID;
    }

    public void setcURRENTPORTID(long cURRENTPORTID) {
        this.cURRENTPORTID = cURRENTPORTID;
    }

    public String getcURRENTPORTUNLOCODE() {
        return cURRENTPORTUNLOCODE;
    }

    public void setcURRENTPORTUNLOCODE(String cURRENTPORTUNLOCODE) {
        this.cURRENTPORTUNLOCODE = cURRENTPORTUNLOCODE;
    }

    public String getcURRENTPORTCOUNTRY() {
        return cURRENTPORTCOUNTRY;
    }

    public void setcURRENTPORTCOUNTRY(String cURRENTPORTCOUNTRY) {
        this.cURRENTPORTCOUNTRY = cURRENTPORTCOUNTRY;
    }

    public long getlASTPORTID() {
        return lASTPORTID;
    }

    public void setlASTPORTID(long lASTPORTID) {
        this.lASTPORTID = lASTPORTID;
    }

    public String getlASTPORTUNLOCODE() {
        return lASTPORTUNLOCODE;
    }

    public void setlASTPORTUNLOCODE(String lASTPORTUNLOCODE) {
        this.lASTPORTUNLOCODE = lASTPORTUNLOCODE;
    }

    public String getlASTPORTCOUNTRY() {
        return lASTPORTCOUNTRY;
    }

    public void setlASTPORTCOUNTRY(String lASTPORTCOUNTRY) {
        this.lASTPORTCOUNTRY = lASTPORTCOUNTRY;
    }

    public long getnEXTPORTID() {
        return nEXTPORTID;
    }

    public void setnEXTPORTID(long nEXTPORTID) {
        this.nEXTPORTID = nEXTPORTID;
    }

    public String getnEXTPORTUNLOCODE() {
        return nEXTPORTUNLOCODE;
    }

    public void setnEXTPORTUNLOCODE(String nEXTPORTUNLOCODE) {
        this.nEXTPORTUNLOCODE = nEXTPORTUNLOCODE;
    }

    public String getnEXTPORTNAME() {
        return nEXTPORTNAME;
    }

    public void setnEXTPORTNAME(String nEXTPORTNAME) {
        this.nEXTPORTNAME = nEXTPORTNAME;
    }

    public String getnEXTPORTCOUNTRY() {
        return nEXTPORTCOUNTRY;
    }

    public void setnEXTPORTCOUNTRY(String nEXTPORTCOUNTRY) {
        this.nEXTPORTCOUNTRY = nEXTPORTCOUNTRY;
    }

    public String geteTACALC() {
        return eTACALC;
    }

    public void seteTACALC(String eTACALC) {
        this.eTACALC = eTACALC;
    }

    public String geteTAUPDATED() {
        return eTAUPDATED;
    }

    public void seteTAUPDATED(String eTAUPDATED) {
        this.eTAUPDATED = eTAUPDATED;
    }

    public long getdISTANCETOGO() {
        return dISTANCETOGO;
    }

    public void setdISTANCETOGO(long dISTANCETOGO) {
        this.dISTANCETOGO = dISTANCETOGO;
    }

    public long getdISTANCETRAVELLED() {
        return dISTANCETRAVELLED;
    }

    public void setdISTANCETRAVELLED(long dISTANCETRAVELLED) {
        this.dISTANCETRAVELLED = dISTANCETRAVELLED;
    }

    public float getaVGSPEED() {
        return aVGSPEED;
    }

    public void setaVGSPEED(float aVGSPEED) {
        this.aVGSPEED = aVGSPEED;
    }

    public float getmAXSPEED() {
        return mAXSPEED;
    }

    public void setmAXSPEED(float mAXSPEED) {
        this.mAXSPEED = mAXSPEED;
    }
}
