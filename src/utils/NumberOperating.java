package utils;

import java.math.BigInteger;

import static java.lang.Math.*;

public class NumberOperating {

    public static int degreeInModule(int base, int degree, int module) {
        if (module <= 0) {
            throw new NumberFormatException("Not valid module");
        }
        int degreeAbs = abs(degree);
        int t = (int) (log(degreeAbs) / log(2));
        int mask = 0b1;
        BigInteger buf = BigInteger.ONE;
        BigInteger bigBase = BigInteger.valueOf(base);
        BigInteger bigModule = BigInteger.valueOf(module);
        for (int i = 0; i <= t; i++) {
            int flag = degreeAbs & mask;
            BigInteger pow = bigBase.pow(flag);
            int factor = pow.remainder(bigModule).intValue();
            buf = buf.multiply(BigInteger.valueOf(factor));
            mask = (mask << 1);
        }
        int result = buf.remainder(bigModule).intValue();
        if(signum(degree) >= 0) {
            return result;
        }else{
            Gcd gcd = greatestCommonDivider(base, module);
            if(gcd.getGreatestCommonDivider() != 1){
                return -1;
            }else{
                return (gcd.getY()% module + module) % module;
            }
        }
    }

    public static int findRandMutuallyPrime(int number){
        while (true) {
            int potentialMutuallyPrime = (int) (random() * 1e4);
            if (isMutuallyPrime(number, potentialMutuallyPrime)) {
                return potentialMutuallyPrime;
            }
        }
    }

    private static boolean isMutuallyPrime(int firstNumber, int secondNumber){
        var gcd = greatestCommonDivider(firstNumber, secondNumber);
        return gcd.getGreatestCommonDivider() == 1;
    }

    public static Gcd greatestCommonDivider(int first, int second){
        int a, b;
        if(first >= second) {
            a = first;
            b = second;
        }else {
            a = second;
            b = first;
        }
        if (b == 0) {
            return new Gcd(a, 1, 0);
        }
        int q, r, x = 0, y = 0,  x2 = 1, x1 = 0, y2 = 0, y1 = 1;
        while (b > 0) {
            q = a / b;
            r = a - q * b;
            x = x2 - q * x1;
            y = y2 - q * y1;
            a = b;
            b = r;
            x2 = x1;
            x1 = x;
            y2 = y1;
            y1 = y;
        }
        return new Gcd(a, x2, y2);
    }
}
