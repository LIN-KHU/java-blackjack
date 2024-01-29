package blackjack;

import java.util.ArrayList;
import java.util.List;
public class Participant {

    private final String name;
    private final List<Card> cardList;
    private final Score score;
    private int win;

    public Participant() {
        this.name = "딜려";
        this.cardList = new ArrayList<Card>();
        this.score = new Score();
        this.win = 0;
    }
    public Participant(String name) {
        this.name = name;
        this.cardList = new ArrayList<Card>();
        this.score = new Score();
        this.win = 0;
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

    public void calculateScore() {
        score.calculate(cardList);
    }

    public void setScore(int number) {
        score.setScore(number);
    }
    public int getScore() {
        return score.getScore();
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }
}
