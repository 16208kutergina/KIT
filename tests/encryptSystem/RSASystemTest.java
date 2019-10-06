package encryptSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RSASystemTest {

    @Test
    void decodeMessage() {
        RSASystem Alice = new RSASystem(131, 227, 3, "Alice");
        RSASystem Bob = new RSASystem(113, 281, 3, "Bob");

        Alice.setOpenKeyOtherD(Bob.getOpenKeyD());
        Alice.setOpenKeyOtherN(Bob.getOpenKeyN());
        int message = Alice.sendMessage(30);
        assertEquals(30, Bob.decodeMessage(message));
    }
}