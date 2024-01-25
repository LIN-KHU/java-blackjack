package blackjack;

import java.util.ArrayList;
import java.util.List;
public class Participant {

    private final String name;
    private final List<Card> cardList;

    public Participant(String name) {
        this.name = name;
        this.cardList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void getNewCard(Deck deck) {
        cardList.add(new Card(deck.getNewCard()));
    }
}
