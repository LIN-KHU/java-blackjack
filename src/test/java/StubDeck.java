import java.util.Queue;

public class StubDeck implements Deck {

    private final Queue<Card> cards;

    public StubDeck(Queue<Card> cards) {
        this.cards = cards;
    }

    @Override
    public Card drawCard() {
        return cards.remove();
    }
}
