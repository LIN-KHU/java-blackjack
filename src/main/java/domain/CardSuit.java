package domain;

public enum CardSuit {
    HEARTS("하트"), DIAMONDS("다이아몬드"), CLUBS("클로버"), SPADES("스페이드");

    private final String value;

    CardSuit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
