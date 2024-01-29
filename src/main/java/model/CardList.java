package model;

import java.util.ArrayList;
import java.util.List;

public class CardList {
    private List<Card> cardList;
    private int sum = 0;

    public CardList() {
        this.cardList = initCardList();
        this.sum = calculateSum(this.cardList);
    }

    public List<Card> initCardList() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card());
        cardList.add(new Card());
        return cardList;
    }

    public int calculateSum(List<Card> cardList) {
        return cardList.stream()
                .mapToInt(card -> card.getNumber().getRank())
                .sum();
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public int getSum() {
        return sum;
    }

    public void addCard() {
        cardList.add(new Card());
        updateSum();
    }

    public void updateSum() {
        this.sum = calculateSum(this.cardList);
    }
}
