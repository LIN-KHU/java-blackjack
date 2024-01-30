package domain;

import java.util.Collections;
import java.util.List;

public class CardShuffler {
	public Card draw() {
		final List<Card> cards = CardPool.getCardPool();
		if (cards.isEmpty()) {
			throw new IllegalStateException("카드가 모두 소진되었습니다.");
		}
		Collections.shuffle(cards);
		return cards.get(0);
	}
}
