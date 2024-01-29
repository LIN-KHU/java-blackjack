package blackjack;

import java.util.List;

public class Score {

    private int score;

    public Score() {
        this.score = 0;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int number) {
        this.score = number;
    }

    public void calculate(List<Card> cardList) {
        for (Card card : cardList) {
            this.score += checkCardScore(card);
        }
    }

    public int checkCardScore(Card card) {
        if (card.checkIfNumeric()) {
            return card.getCardScore() - '0';
        }
        return getIfNotNumeric(card);
    }

    public int getIfNotNumeric(Card card) {
        if (card.checkIfAce()) {
            return 11;
        }
        return 10;
    }
}
