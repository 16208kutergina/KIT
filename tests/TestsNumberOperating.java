import com.company.NumberOperating;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class TestsNumberOperating {
    @Test
    void degreeInModuleTest(){
        assertEquals(4,
                NumberOperating.degreeInModule(3, 100, 7));
        assertEquals(0,
                NumberOperating.degreeInModule(0, 0, 1));
        assertEquals(1,
                NumberOperating.degreeInModule(0, 0, 2));
        assertEquals(8,
                NumberOperating.degreeInModule(7, -1, 11));
        assertEquals(9,
                NumberOperating.degreeInModule(5, -1, 11));
        assertThrows(NumberFormatException.class, () -> NumberOperating.degreeInModule(0, 0, 0));
    }

    @Test
        void greatestCommonDividerTest(){
        assertEquals(1, NumberOperating.greatestCommonDivider(28, 19).getGreatestCommonDivider());
        assertEquals(8, NumberOperating.greatestCommonDivider(24, 16).getGreatestCommonDivider());
        assertEquals(7, NumberOperating.greatestCommonDivider(7, 77).getGreatestCommonDivider());

    }
}

