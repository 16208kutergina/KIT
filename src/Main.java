import digitalSignature.ElGamalSignature;
import digitalSignature.RSASignature;
import hackSystem.BabyStepGiantStepSystem;
import utils.NumberOperating;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int base = 2;
        int module = 30203;
        int result = 24322;

        BabyStepGiantStepSystem system = new BabyStepGiantStepSystem(base, module, result);
        var degree = system.findDegree();
        System.out.println(degree);
        var i = NumberOperating.degreeInModule(base, degree, module);
        System.out.println(i);
    }
}
