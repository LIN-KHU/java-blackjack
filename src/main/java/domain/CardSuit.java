package domain;

public enum CardSuit {
	SPADE("스페이드"),
	DIAMOND("다이아몬드"),
	HEART("하트"),
	CLOVER("클로버");

	private final String name;

	CardSuit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
