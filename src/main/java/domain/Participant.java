package domain;

public class Participant {
	private final Name name;
	private final CardDeck cardDeck;

	public Participant(String name) {
		this.name = new Name(name);
		this.cardDeck = initDeck(new CardShuffler());
	}

	public void hit(CardShuffler shuffler) {
		Card card = CardPool.draw(shuffler);
		cardDeck.addCard(card);
	}

	public CardDeck initDeck(CardShuffler shuffler) {
		CardDeck deck = new CardDeck();
		deck.init(shuffler);
		return deck;
	}

	public Name getName() {
		return name;
	}

	public CardDeck getCardDeck() {
		return cardDeck;
	}
}
