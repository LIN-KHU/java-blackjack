package participant;

import carddeck.Card;

import java.util.ArrayList;
import java.util.List;

public class CardList {

    private List<Card> cardList;

    public CardList() {
        this.cardList = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        this.cardList.add(card);
    }

    public List<Card> getCardList() {
        return this.cardList;
    }

}
