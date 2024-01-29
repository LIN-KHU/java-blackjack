package domain;

import domain.carddeck.Card;
import domain.carddeck.CardRank;
import domain.carddeck.CardRankConverter;
import domain.participant.CardList;
import domain.participant.Participant;

import java.util.List;

public class CalculateScore {

    private final int targetScore = 21;
    private CardRankConverter cardRankConverter = new CardRankConverter();


    public int calculator(Participant participant) {
        int sumExceptAce = calculatorExceptAce(participant);
        return calculatorContainsAce(participant, sumExceptAce);
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
        if (sum + 11 <= targetScore) {
            sum += 10;
        }
        return sum;
    }
}