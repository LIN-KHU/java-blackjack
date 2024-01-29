package domain;

import domain.carddeck.Card;
import domain.carddeck.CardRank;
import domain.carddeck.CardRankConverter;
import domain.constants.Constant;
import domain.participant.CardList;
import domain.participant.Participant;

import java.util.List;

public class CalculateScore {

    private CardRankConverter cardRankConverter = new CardRankConverter();


    public int calculator(Participant participant) {
        int sumExceptAce = calculatorExceptAce(participant);
        int sum = calculatorContainsAce(participant, sumExceptAce);
        participant.getCardList().setScore(sum);
        return sum;
    }

    private int calculatorExceptAce(Participant participant) {
        int sumExceptAce = 0;
        CardList cardList = participant.getCardList();
        for (Card card : cardList.getCardList()) {
            CardRank cardRank = card.getCardRank();
            sumExceptAce += this.cardRankConverter.converter(cardRank);
        }
        return sumExceptAce;
    }

    private int calculatorContainsAce(Participant participant, int sum) {
        CardList cardList = participant.getCardList();
        for (Card card : cardList.getCardList()) {
            CardRank cardRank = card.getCardRank();
            if (cardRank == CardRank.ACE) {
                sum = addOneOrEleven(sum);
            }
        }
        return sum;
    }

    private int addOneOrEleven(int sum) {
        sum += 1;
        if (sum + 11 <= Constant.TARGET_SCORE) {
            sum += 10;
        }
        return sum;
    }
}