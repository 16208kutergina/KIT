package hackSystem;

import org.junit.jupiter.api.Test;
import utils.NumberOperating;

import static org.junit.jupiter.api.Assertions.*;

class BabyStepGiantStepSystemTest {

    @Test
    void findDegree2() {
        int base = 2;
        int module = 30203;
        int result = 24322;

        BabyStepGiantStepSystem system = new BabyStepGiantStepSystem(base, module, result);
        var degree = system.findDegree();
        var i = NumberOperating.degreeInModule(base, degree, module);
        assertEquals(result, i);
    }
    @Test
    void findDegree5() {
        int base = 5;
        int module = 31607;
        int result = 30994;

        BabyStepGiantStepSystem system = new BabyStepGiantStepSystem(base, module, result);
        var degree = system.findDegree();
        var i = NumberOperating.degreeInModule(base, degree, module);
        assertEquals(result, i);
    }
}