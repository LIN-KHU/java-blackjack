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

    public void calculate(CardList cardList) {
        this.score = 0;
        for (Card card : cardList.getCardList()) {
            this.score += checkCardScore(card);
            if (card.checkScoreIfAce() && score < 11) {
                score += 10;
            }
        }
    }

    public int checkCardScore(Card card) {
        if (card.checkScoreIfNumeric()) {
            return card.getCardScore() - '0';
        }
        return getIfNotNumeric(card);
    }

    public int getIfNotNumeric(Card card) {
        if (card.checkScoreIfAce()) {
            return 1;
        }
        return 10;
    }
}
