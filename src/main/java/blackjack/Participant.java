package blackjack;

import java.util.ArrayList;
import java.util.List;
public class Participant {

    private final String name;
    private final List<Card> cardList;
    private int score;
    private int win;

    public Participant() {
        this.name = "딜려";
        this.cardList = new ArrayList<Card>();
        this.score = 0;
        this.win = 0;
    }
    public Participant(String name) {
        this.name = name;
        this.cardList = new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public List<String> getCardNameList() {
        List<String> carNameList = new ArrayList<String>();
        for (Card card : cardList) {
            carNameList.add(card.getCardName());
        }
        return carNameList;
    }

    public void getNewCard(Deck deck) {
        cardList.add(new Card(deck.getNewCard()));
    }

    public void setScore() {
        Score sc = new Score();
        this.score = sc.setScore(cardList);
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return this.score;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }
}
