public class Card {

    private final String name;
    private final int value;

    public Card(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int calculateValue() {
        return value;
    }

    public boolean isAce() {
        return name.contains("A");
    }
}
