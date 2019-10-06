package encryptSystem;

import utils.NumberOperating;

public class ElGamalSystem {
    private final String name;
    private final int base;
    private int module;
    private int secretKey;
    private int openKey;
    private int openKeyOther;

    public void setOpenKeyOther(int openKeyOther) {
        this.openKeyOther = openKeyOther;
    }

    public ElGamalSystem(int base, int module, String name) {
        this.name = name;
        this.base = base;
        this.module = module;
    }

    public PairElGamal sendMessage(int message){
        if(message > module){
            throw new IllegalArgumentException("Incorrect message");
        }
        int k = (int) (Math.random()*1e10 % (module-1));
        int r = NumberOperating.degreeInModule(base, k, module);
        int e = (NumberOperating.degreeInModule(openKeyOther, k, module) *message) % module;
        return new PairElGamal(r, e);
    }

    public int generateKeys() {
        this.secretKey = (int) (Math.random()*1e10 % module);
        this.openKey = NumberOperating.degreeInModule(base, secretKey, module);
        return this.openKey;
    }

    public int decodeMessage(PairElGamal pairElGamal) {
        int r = pairElGamal.getR();
        int e = pairElGamal.getE();
        return (e * NumberOperating.degreeInModule(r, module-1-secretKey, module))%module;
    }

    public static class PairElGamal {
        private int r;
        private int e;

        public PairElGamal(int r, int e) {
            this.r = r;
            this.e = e;
        }

        public int getR() {
            return r;
        }

        public int getE() {
            return e;
        }
    }
}
