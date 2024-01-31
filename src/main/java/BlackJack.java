import java.util.List;

public class BlackJack {

    private final Dealer dealer;
    private final List<Player> players;
    private final Deck deck;

    public BlackJack(Dealer dealer, List<Player> players, Deck deck) {
        this.dealer = dealer;
        this.players = players;
        this.deck = deck;
        divideInitialCard(dealer, players);
    }

    private void divideInitialCard(Dealer dealer, List<Player> players) {
        dealer.giveCard(deck.drawCard());
        dealer.giveCard(deck.drawCard());
        for (Player player : players) {
            player.giveCard(deck.drawCard());
            player.giveCard(deck.drawCard());
        }
    }

    public boolean allPlayerWin() {
        int dealerScore = dealer.getHands().calculateWithBonusValue();
        for (Player player : players) {
            if (player.getHands().calculateWithBonusValue() < dealerScore) {
                return false;
            }
        }
        return true;
    }
}
