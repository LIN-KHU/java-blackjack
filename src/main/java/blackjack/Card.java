package blackjack;

public class Card {

    private final String cardName;
    private final char cardScore;

    public Card(String name) {
        this.cardName = name;
        this.cardScore = name.charAt(0);
    }

    public char getCardScore() {
        return cardScore;
    }

    public String getCardName() {
        return cardName;
    }

    public boolean checkIfNumeric() { return (cardScore >= '2' && cardScore <= '9'); }
    public boolean checkIfAce() { return (cardScore == 'A'); }
}
