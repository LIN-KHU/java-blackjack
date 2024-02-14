package blackjack.model.Card;

public class CardScore {

    private final char cardScore;

    public CardScore(char score) {
        this.cardScore = score;
    }

    public char getCardScore() {
        return cardScore;
    }

    public boolean checkIfNumeric() { return (cardScore >= '2' && cardScore <= '9'); }
    public boolean checkIfAce() { return (cardScore == 'A'); }
}
