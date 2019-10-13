package digitalSignature;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ElGamalSignatureTest {

    @Test
    void checkAuthenticity() {
        int module = 30803;
        int base = 2;
        ElGamalSignature alice = new ElGamalSignature( module, base, "Alice");
        ArrayList<Integer> message = new ArrayList<>(1);
        message.add(30);
        var messageWithSignature = alice.sendMessage(message);
        var isAliceSignature = ElGamalSignature.checkAuthenticity(messageWithSignature, base, module, alice.getOpenKey());
        assertTrue(isAliceSignature);
    }
}