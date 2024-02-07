package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private CardList cardList;

    public Player(String name) {
        this.name = name;
        this.cardList = new CardList();
    }

    public String getName() {
        return name;
    }

    public CardList getCardList() {
        return cardList;
    }

    /*
            playerlist에 있는 메서드와 구분 필요
         */
    @Override
    public String toString() {
        String cards = cardList.getCardList().stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
        return name + "카드: " + cards;
    }
}
