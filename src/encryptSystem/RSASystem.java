package encryptSystem;

import utils.NumberOperating;

public class RSASystem {
    private int openKeyD;
    private String name;
    private int openKeyN;
    private int secretKeyC;
    private int openKeyOtherN;
    private int openKeyOtherD;

    public int getOpenKeyN() {
        return openKeyN;
    }

    public int getOpenKeyD() {
        return openKeyD;
    }

    public void setOpenKeyOtherD(int openKeyOtherD) {
        this.openKeyOtherD = openKeyOtherD;
    }

    public void setOpenKeyOtherN(int openKeyOtherN) {
        this.openKeyOtherN = openKeyOtherN;
    }

    public RSASystem(int q, int p, int d, String name) {
        this.openKeyD = d;
        this.name = name;
        openKeyN = q * p;
        int phi = (q - 1) * (p - 1);
        secretKeyC = NumberOperating.degreeInModule(openKeyD, -1, phi);
    }

    public int sendMessage(int message){
        return NumberOperating.degreeInModule(message, openKeyOtherD, openKeyOtherN);
    }

    public int decodeMessage(int message){
        return NumberOperating.degreeInModule(message, secretKeyC, openKeyN);
    }

}
