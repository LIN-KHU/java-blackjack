package domain;

public class Card {
	private final CardSuit suit;
	private final CardSymbol symbol;

	public Card(CardSuit suit, CardSymbol symbol) {
		this.suit = suit;
		this.symbol = symbol;
	}

	public boolean isAce() {
		return symbol == CardSymbol.ACE;
	}

	public int getSymbolValue() {
		return symbol.getValue();
	}
}
