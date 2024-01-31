import java.util.List;

public class Hands {

    private static final int ACE_BONUS_SCORE = 10;
    private static final int MAX_HANDS_VALUE = 21;
    private final List<Card> cards;

    public Hands(List<Card> cards) {
        this.cards = cards;
    }

    public int calculateValue() {
        return cards.stream()
            .mapToInt(card -> card.calculateValue())
            .sum();
    }

    public int calculateWithBonusValue() {
        boolean haveAce = cards.stream()
            .anyMatch(Card::isAce);
        int value = calculateValue();
        if (haveAce && value + ACE_BONUS_SCORE <= MAX_HANDS_VALUE) {
            return value + ACE_BONUS_SCORE;
        }
        return value;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void add(Card card) {
        cards.add(card);
    }
}
