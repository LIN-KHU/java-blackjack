package carddeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private List<Card> cardDeck;

    public CardDeck() {
        initializeCardDeck();
        shuffleCardDeck();
    }

    private void initializeCardDeck() {
        CardSuit[] suits = CardSuit.values();
        CardRank[] ranks = CardRank.values();

        this.cardDeck = new ArrayList<Card>();

        for (CardSuit suit : suits) {
            for (CardRank rank : ranks) {
                Card card = new Card(suit, rank);
                this.cardDeck.add(card);
            }
        }
    }

    private void shuffleCardDeck() {
        Collections.shuffle(this.cardDeck);
    }

    public Card drawCard() {
        if (this.cardDeck.isEmpty()) {
            throw new IllegalArgumentException("카드덱이 비어 있습니다.");
        }

        return this.cardDeck.remove(0);
    }

}
