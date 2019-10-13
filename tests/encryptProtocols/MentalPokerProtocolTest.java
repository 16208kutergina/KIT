package encryptProtocols;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MentalPokerProtocolTest {

    @Test
    void decodeCard() {
        int module = 30803;
        var Alice = new MentalPokerProtocol(module,"Alice");
        var Bob = new MentalPokerProtocol(module,"Bob");

        Alice.chooseCards();
        var encryptAliceCards = Alice.sendCards();
        var cardAlice = Bob.chooseCardForOther(encryptAliceCards);
        var decodeCard = Alice.decodeCard(cardAlice);
        var contains = Alice.getCards().contains(decodeCard);
        assertTrue(contains);
        var encryptBobCards = Bob.sendCards();
        var cardForBob = Alice.decodeCard(Alice.chooseCardForOther(encryptBobCards));
        var decodeCard1 = Bob.decodeCard(cardForBob);
        assertTrue(Alice.getCards().contains(decodeCard1));
    }
}