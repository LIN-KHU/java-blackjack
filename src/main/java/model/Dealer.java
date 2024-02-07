package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealer {
    private CardList cardList;

    public Dealer() {
        this.cardList = new CardList();
    }

    @Override
    public String toString() {
        String cards = cardList.getCardList().stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
        return "딜러: " + cards;
    }

    public CardList getCardList() {
        return cardList;
    }
}
