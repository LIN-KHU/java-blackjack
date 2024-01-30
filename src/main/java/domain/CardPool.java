package domain;

import java.util.ArrayList;
import java.util.List;

public class CardPool {
	private static final int MAX_CARD_COUNT = 52;

	private final List<Card> cardPool;

	public CardPool() {
		this.cardPool = createCardPool();
		if (cardPool.size() > MAX_CARD_COUNT) {
			throw new IllegalArgumentException("덱에 추가할 수 있는 카드의 수를 초과하였습니다.");
		}
	}

	private List<Card> createCardPool() {
		List<Card> cardPool = new ArrayList<>();
		for (CardSuit suit : CardSuit.values()) {
			for (CardSymbol symbol : CardSymbol.values()) {
				cardPool.add(new Card(suit, symbol));
			}
		}
		return cardPool;
	}

	public List<Card> getCardPool() {
		return cardPool;
	}
}
