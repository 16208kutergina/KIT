package digitalSignature;

import utils.NumberOperating;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class ElGamalSignature {
    private int module;
    private int base;
    private int secretKey;
    private int openKey;
    private String name;

    public int getOpenKey() {
        return openKey;
    }

    public ElGamalSignature(int module,
                            int base, String name) {
        this.module = module;
        this.base = base;
        this.name = name;
        secretKey = (int) (Math.random() * 1e10 % (module - 1));
        openKey = NumberOperating.degreeInModule(base, secretKey, module);
    }
    public ElGamalMessageWithSignature sendMessage(ArrayList<Integer> message) {
        var hashCode = message.hashCode()%module;
        var k = NumberOperating.findRandMutuallyPrime(module - 1);
        var r = NumberOperating.degreeInModule(base, k, module);
        var u = (hashCode - secretKey * r) % (module - 1);
        if(u < 0){
            u = u + module - 1;
        }
        var k1 = NumberOperating.degreeInModule(k, -1, module - 1);
        var s = (k1 * u) % (module - 1);

        ElGamalMessageWithSignature elGamalMessageWithSignature = new ElGamalMessageWithSignature();
        elGamalMessageWithSignature.setMessage(message);
        elGamalMessageWithSignature.setDigitalSignatureR(r);
        elGamalMessageWithSignature.setDigitalSignatureS(s);

        return elGamalMessageWithSignature;
    }

    public static boolean checkAuthenticity(ElGamalMessageWithSignature elGamalMessageWithSignature,
                                              int base,
                                              int module,
                                              int openKey){
        var message = elGamalMessageWithSignature.getMessage();
        var r = elGamalMessageWithSignature.getDigitalSignatureR();
        var s = elGamalMessageWithSignature.getDigitalSignatureS();
        int h = message.hashCode() % module;
        int leftValue = (NumberOperating.degreeInModule(openKey, r, module) * NumberOperating.degreeInModule(r, s, module))%module;
        int rightValue = NumberOperating.degreeInModule(base, h, module);
        return leftValue == rightValue;
    }

}