package blackjack.model.Card;

import java.util.ArrayList;
import java.util.List;

public class CardList {
    private final List<Card> cardList;

    public CardList() {
        this.cardList = new ArrayList<Card>();
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void add(Card card) {
        cardList.add(card);
    }
}
