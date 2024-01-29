package domain;

import domain.carddeck.Card;
import domain.carddeck.CardDeck;
import domain.participant.Participant;
import domain.participant.ParticipantList;

import java.util.List;

public class CardDistributor {

    private final int initialDistributionCount = 2;

    public void initialCardDistribution(CardDeck cardDeck, ParticipantList participantList) {
        List<Participant> participants = participantList.getParticipantList();
        for (Participant participant : participants) {
            for (int i = 0; i < initialDistributionCount; i++) {
                Card card = cardDeck.getCardRandomly();
                participant.getCardList().addCard(card);
            }
        }
    }

    public void distributeOneCard(CardDeck cardDeck, Participant participant) {
        Card card = cardDeck.getCardRandomly();
        participant.getCardList().addCard(card);
    }

}
