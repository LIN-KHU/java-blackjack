package domain.carddeck;

public class Card {

    private final CardSuit cardSuit;
    private final CardRank cardRank;

    public Card(CardSuit cardSuit, CardRank cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    @Override
    public String toString() {
        return this.cardRank.getValue() + this.cardSuit.getValue();
    }
}
