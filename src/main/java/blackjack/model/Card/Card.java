package blackjack.model.Card;

public class Card {

    private final CardName cardName;
    private final CardScore cardScore;

    public Card(String name) {
        this.cardName = new CardName(name);
        this.cardScore = new CardScore(name.charAt(0));
    }

    public char getCardScore() {
        return cardScore.getCardScore();
    }

    public String getCardName() {
        return cardName.getName();
    }

    public boolean checkScoreIfNumeric() {
        return cardScore.checkIfNumeric();
    }

    public boolean checkScoreIfAce() {
        return cardScore.checkIfAce();
    }
}
