package com.company;

public class DiffiHelmanSystem {
    private int secretKey;
    private int openKey;
    private int commonKey;
    private int base;
    private int module;
    private String name;

    public int getOpenKey() {
        return openKey;
    }

    public DiffiHelmanSystem(int base, int module, String name) {
        this.name = name;
        this.base = base;
        this.module = module;
        generateKeys(base, module);
    }

    private void generateKeys(int base, int module) {
        this.secretKey = (int) (Math.random()*1e2);
        System.out.println("Secret key "+name+": "+ secretKey);
        openKey = NumberOperating.degreeInModule(base, secretKey, module);
        System.out.println("Open key "+name+": "+ openKey);
    }

    public void generateCommonKey(int openKeyB){
        this.commonKey = NumberOperating.degreeInModule(openKeyB, secretKey, module);
        System.out.println("Common key "+name+": "+ commonKey);

    }

    public int sendMessage(int message){
return  message + 100 - module + commonKey;
    }

    public int decodeMessage(int message){
        return message - commonKey + module - 100;
    }
}
