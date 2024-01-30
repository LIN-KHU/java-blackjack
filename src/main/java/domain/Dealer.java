package domain;

public class Dealer extends Participant {
	public Dealer(String name) {
		super(name);
	}

	public boolean checkDrawAgain() {
		return getScore() < 17;
	}
}
