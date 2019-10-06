package encryptSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElGamalTest {

    @Test
    void decodeMessage() {
        int module = 30803;
        int base = 2;
        ElGamalSystem Alice = new ElGamalSystem(base, module, "Alice");
        ElGamalSystem Bob = new ElGamalSystem(base, module, "Bob");

        int keyBob = Bob.generateKeys();

        Alice.setOpenKeyOther(keyBob);

        ElGamalSystem.PairElGamal pairElGamal = Alice.sendMessage(30);

        assertEquals(30,Bob.decodeMessage(pairElGamal));
    }
}