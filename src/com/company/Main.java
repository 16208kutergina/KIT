package com.company;


public class Main {

    public static void main(String[] args) {
        int base = 2;
        int module = 30803;
        DiffiHelmanSystem Alice = new DiffiHelmanSystem(base, module, "Alice");
        DiffiHelmanSystem Bob = new DiffiHelmanSystem(base, module, "Bob");

        Alice.generateCommonKey(Bob.getOpenKey());
        Bob.generateCommonKey(Alice.getOpenKey());

        int secret = Alice.sendMessage(30);
        System.out.println(secret);
        System.out.println(Bob.decodeMessage(secret));
    }
}
