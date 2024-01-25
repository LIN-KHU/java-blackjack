package blackjack;

public class Card {

    private final String cardName;
    private final char cardScore;

    public Card(String name) {
        this.cardName = name;
        this.cardScore = name.charAt(0);
    }

    public int getCardScore() {
        return cardScore;
    }

    public String getCardName() {
        return cardName;
    }
}
