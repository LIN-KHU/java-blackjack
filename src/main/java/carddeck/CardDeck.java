package domain.carddeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardDeck {

    List<Card> cardDeck;

    public CardDeck() {
        generateCardDeck();
    }

    private void generateCardDeck() {
        CardSuit[] suits = CardSuit.values();
        CardRank[] ranks = CardRank.values();

        this.cardDeck = new ArrayList<Card>();

        for (CardSuit suit : suits) {
            for (CardRank rank : ranks) {
                Card card = new Card(suit, rank);
                this.cardDeck.add(card);
            }
        }
        Collections.shuffle(this.cardDeck);
    }

    public Card getCard() {

        Card card = this.cardDeck.get(0);
        this.cardDeck.remove(0);

        return card;
    }
}
