package blackjack;

import java.util.ArrayList;
import java.util.List;
public class Participant {

    private final ParticipantName name;
    private final CardList cardList;
    private final Score score;
    private final Result result;

    public Participant() {
        this("딜러");
    }
    public Participant(String name) {
        this.name = new ParticipantName(name);
        this.cardList = new CardList();
        this.score = new Score();
        this.result = new Result();
    }

    public String getName() {
        return name.getName();
    }

    public List<Card> getCardList() {
        return cardList.getCardList();
    }

    public List<String> getCardNameList() {
        List<String> carNameList = new ArrayList<String>();
        for (Card card : cardList.getCardList()) {
            carNameList.add(card.getCardName());
        }
        return carNameList;
    }

    public void getNewCard(Deck deck) {
        Card newCard = new Card(deck.getNewCard());
        cardList.add(newCard);
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

    public int getWin() { return result.getWin(); }
    public void setWin() { result.setWin();}

}
