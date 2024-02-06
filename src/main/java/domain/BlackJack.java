package domain;

import carddeck.Card;
import carddeck.CardDeck;
import participant.Dealer;
import participant.Participant;

import java.util.List;

public class BlackJack {

    private final int INITIAL_CARD_DISTRIBUTION_COUNT = 2;
    public final int DEALER_THRESHOLD = 16;

    private List<Participant> participants;
    private CardDeck cardDeck;

    public BlackJack(List<Participant> participants) {
        this.participants = participants;
        this.cardDeck = new CardDeck();
        initialCardDistribution();
    }

    private void initialCardDistribution() {
        for (Participant participant : participants) {
            for (int i = 0; i < INITIAL_CARD_DISTRIBUTION_COUNT; i++) {
                distributeCard(participant);
            }
        }
    }

    public void distributeCard(Participant participant) {
        try {
            Card card = this.cardDeck.drawCard();
            participant.receiveCard(card);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    public boolean isDealerAboveThreshold(Dealer dealer) {
        int score = dealer.getScore();
        if (score <= DEALER_THRESHOLD) {
            return true;
        }
        return false;
    }

}
