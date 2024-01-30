package domain;

public class Participant {
	/*
	*
	* ## 참여자 (게임 구성원)
- 사용자는 `딜러` 혹은 `플레이어`가 될 수 있다.
- 모든 사용자는 고유한 `이름`을 가진다.
- 모든 사용자는 개인별 카드 목록(`덱`)을 가진다.
- 모든 사용자는 전체 카드 (`풀`) 에서 1장의 카드를 뽑을 수 있다.
* */
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
