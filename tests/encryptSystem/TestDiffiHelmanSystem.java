package encryptSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffiHelmanSystem {

    @Test
    void sendAndDecodeMessageTest(){
        int base = 2;
        int module = 30803;
        DiffiHelmanSystem Alice = new DiffiHelmanSystem(base, module, "Alice");
        DiffiHelmanSystem Bob = new DiffiHelmanSystem(base, module, "Bob");

        Alice.generateCommonKey(Bob.getOpenKey());
        Bob.generateCommonKey(Alice.getOpenKey());

        int secret = Alice.sendMessage(30);
        assertEquals(30, Bob.decodeMessage(secret));
    }
}
