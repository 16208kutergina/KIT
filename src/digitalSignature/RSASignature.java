package digitalSignature;

import utils.NumberOperating;

import java.util.ArrayList;

public class RSASignature {
    private int openKeyD;
    private String name;
    private int openKeyN;
    private int secretKeyC;

    public int getOpenKeyN() {
        return openKeyN;
    }

    public int getOpenKeyD() {
        return openKeyD;
    }

    public RSASignature(int q, int p, int d, String name) {
        this.openKeyD = d;
        this.name = name;
        openKeyN = q * p;
        int phi = (q - 1) * (p - 1);
        secretKeyC = NumberOperating.degreeInModule(openKeyD, -1, phi);
    }

    public RSAMessageWithSignature sendMessage(ArrayList<Integer> message){
        RSAMessageWithSignature messageWithSignature = new RSAMessageWithSignature();
        messageWithSignature.setMessage(message);
        var hashCodeMessage = message.hashCode();
        int s = NumberOperating.degreeInModule(hashCodeMessage, secretKeyC, openKeyN);
        messageWithSignature.setDigitalSignature(s);
        return messageWithSignature;
    }

    public static boolean checkAuthenticity(RSAMessageWithSignature messageWithSignature,
                                            int openKeyD,
                                            int openKeyN){
        var message = messageWithSignature.getMessage();
        var digitalSignature = messageWithSignature.getDigitalSignature();
        var hashCodeMessage = message.hashCode();
        var w = NumberOperating.degreeInModule(digitalSignature, openKeyD, openKeyN);
        return hashCodeMessage == w;
    }


}
