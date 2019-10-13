package digitalSignature;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RSASignatureTest {

    @Test
    void checkAuthenticity() {
        RSASignature alice = new RSASignature(131, 227,3, "Alice");
        ArrayList<Integer> message = new ArrayList<>(1);
        message.add(30);
        var messageWithSignature = alice.sendMessage(message);
        var isAliceSignature = RSASignature.checkAuthenticity(messageWithSignature, alice.getOpenKeyD(), alice.getOpenKeyN());
        assertTrue(isAliceSignature);
    }
}