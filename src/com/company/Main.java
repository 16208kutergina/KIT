package com.company;



public class Main {

    public static void main(String[] args) {
        int module = 30803;
        ShamirSystem Alice = new ShamirSystem(module, "Alice");
        ShamirSystem Bob = new ShamirSystem(module, "Bob");

        int firstAlice = Alice.codeMessageFirstFactor(30);
        int firstBob = Bob.codeMessageFirstFactor(firstAlice);
        int secondAlice = Alice.codeMessageSecondFactor(firstBob);
        int secondBob = Bob.codeMessageSecondFactor(secondAlice);
        System.out.println(secondBob);
    }
}
