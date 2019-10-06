package encryptProtocols;

import utils.NumberOperating;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MentalPokerProtocol {
    private String name;
    private int module;
    private int keyC;
    private int keyD;
    private HashSet<Integer> cards = new HashSet<>();

    public HashSet<Integer> getCards() {
        return cards;
    }

    public MentalPokerProtocol(int module, String name) {
        this.name = name;
        this.module = module;
        keyC = NumberOperating.findRandMutuallyPrime(module - 1);
        keyD = NumberOperating.degreeInModule(keyC, -1, module - 1);
    }

    public void chooseCards(){
        int card = (int) ((Math.random() * 1e2) % 54);
        cards.add(card);
        while (cards.size() < 3){
            card = (int) ((Math.random() * 1e2) % 54);
                cards.add(card);
        }
    }

    public List<Integer> sendCards(){
        List<Integer> codeCards = new ArrayList<>();
        for(int card : cards){
            codeCards.add(NumberOperating.degreeInModule(card, keyC, module));
        }
        return codeCards;
    }

    public int chooseCardForOther(List<Integer> cards){
        int randomIndex = (int) ((Math.random() * 10) % cards.size());
        var card = cards.get(randomIndex);
        cards.remove(randomIndex);
        this.cards.addAll(cards);
        return card;
    }

    public int decodeCard(int code){
        return NumberOperating.degreeInModule(code, keyD, module);
    }
}
