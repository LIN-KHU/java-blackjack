package domain;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

	private final List<Card> cards;
	private static final int MAX_CARD_COUNT = 2;

	public CardDeck() {
		this.cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		if (cards.size() >= MAX_CARD_COUNT) {
			throw new IllegalArgumentException("카드 풀에 더 이상 카드를 생성할 수 없습니다.");
		}
		cards.add(card);
	}

	public void init(CardShuffler shuffler) {
		for (int i = 0; i < MAX_CARD_COUNT; i++) {
			addCard(shuffler.draw());
		}
	}

	public Score calculateScore() {
		Score score = new Score();
		for (Card card : cards) {
			score.addScore(card.getScore());
		}
		return score;
	}

	public int size() {
		return cards.size();
	}

	public List<Card> getCards() {
		return cards;
	}

	public boolean isBlackJack() {
		return cards.size() == 2 && calculateScore().isBlackJack();
	}

	public boolean isBust() {
		return calculateScore().isBust();
	}

}
