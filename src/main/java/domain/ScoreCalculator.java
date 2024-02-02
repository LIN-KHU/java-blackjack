package domain;

import carddeck.Card;
import carddeck.CardRank;
import participant.Participant;

import java.util.List;

public class ScoreCalculator {

    public static int calculateScore(Participant participant) {
        int sum = 0;
        int numOfAce = 0;
        List<Card> cardList = participant.getCardList();
        for (Card card : cardList) {
            CardRank cardRank = card.getCardRank();
            if (cardRank.getRank().equals(CardRank.ACE.getRank())) {
                numOfAce += 1;
            }
            sum += cardRank.getValue();
        }
        sum = calculateAceValue(numOfAce, sum);
        return sum;
    }

    private static int calculateAceValue(int numOfAce, int sum) {
        for (int i = 0; i < numOfAce; i++) {
            if (sum + 10 <= 21) {
                sum += 10;
            }
        }
        return sum;
    }

}