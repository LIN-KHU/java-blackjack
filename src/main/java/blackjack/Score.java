package blackjack;

import java.util.List;

public class Score {

    public int setScore(List<Card> cardList) {
        int score = 0;
        for (Card card : cardList) {
            score += CardScore(card);
        }
        return score;
    }

    public int CardScore(Card card) {
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
