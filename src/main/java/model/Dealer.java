package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealer {
    private List<Card> cardList;

    public Dealer() {
        this.cardList = initCardList();
    }

    /*
        코드 중복 - 수정
     */
    public List<Card> initCardList() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card());
        cardList.add(new Card());
        return cardList;
    }

    @Override
    public String toString() {
        String cards = cardList.stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
        return "딜러: " + cards;
    }
}
