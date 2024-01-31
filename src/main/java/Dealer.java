public class Dealer {

    private final String name;
    private final Hands hands;

    public Dealer(String name, Hands hands) {
        this.name = name;
        this.hands = hands;
    }

    public void giveCard(Card card) {
        hands.add(card);
    }

    public Hands getHands() {
        return hands;
    }
}
