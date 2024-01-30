package domain;

import java.util.List;

public class Score {

	private static final int BLACKJACK = 21;
	private static final int DEALER_DRAW_LIMIT = 16;
	private static final int MIN_ACE_SCORE = 1;
	private static final int MAX_ACE_SCORE = 11;


	private int score;

	public Score() {
		this.score = 0;
	}

	public void calculateScoreWithAce(CardDeck cardDeck) {
		List<Card> cards = cardDeck.getCards();
		int aceCount = 0;
		for (Card card : cards) {
			if (card.isAce()) {
				aceCount++;
				score += MAX_ACE_SCORE;
			} else {
				score += card.getSymbolValue();
			}
		}

		while (score > BLACKJACK && aceCount > 0) {
			score -= MAX_ACE_SCORE - MIN_ACE_SCORE;
			aceCount--;
		}
	}

	public boolean isBlackJack() {
		return score == BLACKJACK;
	}

	public boolean isBust() {
		return score > BLACKJACK;
	}

	public boolean isDealerDraw() {
		return score <= DEALER_DRAW_LIMIT;
	}

	public void addAceScore() {
		if (score + MAX_ACE_SCORE <= BLACKJACK) {
			score += MAX_ACE_SCORE;
			return;
		}
		score += MIN_ACE_SCORE;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Score score = (Score) obj;
		return this.score == score.score;
	}

	public boolean isMoreThanDealer(Participant dealer) {
		return score > dealer.getCardDeck().calculateScore().score;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public int getScore() {
		return score;
	}
}
