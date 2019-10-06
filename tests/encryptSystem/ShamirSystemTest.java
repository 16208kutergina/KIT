package encryptSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShamirSystemTest {
    @Test
    void sendAndDecodeMessageTest(){
        int module = 30803;
        ShamirSystem Alice = new ShamirSystem(module, "Alice");
        ShamirSystem Bob = new ShamirSystem(module, "Bob");

        int firstAlice = Alice.codeMessageFirstFactor(30);
        int firstBob = Bob.codeMessageFirstFactor(firstAlice);
        int secondAlice = Alice.codeMessageSecondFactor(firstBob);
        int secondBob = Bob.codeMessageSecondFactor(secondAlice);
        assertEquals(30, secondBob);
    }
}