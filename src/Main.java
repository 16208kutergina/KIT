import encryptProtocols.MentalPokerProtocol;

public class Main {

    public static void main(String[] args) {
        int module = 30803;
        var Alice = new MentalPokerProtocol(module,"Alice");
        var Bob = new MentalPokerProtocol(module,"Bob");

        Alice.chooseCards();
        var encryptAliceCards = Alice.sendCards();
        var cardAlice = Bob.chooseCardForOther(encryptAliceCards);
        var decodeCard = Alice.decodeCard(cardAlice);
        System.out.println(decodeCard);
        var encryptBobCards = Bob.sendCards();
        var cardForBob = Alice.decodeCard(Alice.chooseCardForOther(encryptBobCards));
        System.out.println(Bob.decodeCard(cardForBob));
    }
}
