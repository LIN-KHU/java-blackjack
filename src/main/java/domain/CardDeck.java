package domain;

import java.util.ArrayList;
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
    }

    public Card getCardRandomly() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.cardDeck.size());
        Card randomCard = this.cardDeck.get(randomIndex);

        this.cardDeck.remove(randomIndex);

        return randomCard;
    }
}
