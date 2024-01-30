package domain;

public class Dealer extends Participant {
	public Dealer(String name) {
		super(name);
	}

	public boolean checkDrawAgain() {
		return getCardDeck().calculateScore().getScore() < 17;
	}
}
