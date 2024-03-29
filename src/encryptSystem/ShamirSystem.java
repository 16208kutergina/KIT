package encryptSystem;

import utils.NumberOperating;

public class ShamirSystem {
    private int module;
    private int secretKey;
    private int pairSecretKey = -1;
    private String name;

    public ShamirSystem(int module, String name) {
        this.module = module;
        this.name = name;
    }

    private void generateKeys() {
        while (pairSecretKey == -1){
            this.secretKey = (int) (Math.random() * 1e2);
            this.pairSecretKey = NumberOperating.degreeInModule(secretKey, -1, module - 1);
    }
    }

    public int codeMessageFirstFactor(int message){
        generateKeys();
        return NumberOperating.degreeInModule(message, secretKey, module);
    }

    public int codeMessageSecondFactor(int receiveMessage){
        return NumberOperating.degreeInModule(receiveMessage, pairSecretKey, module);
    }
}
