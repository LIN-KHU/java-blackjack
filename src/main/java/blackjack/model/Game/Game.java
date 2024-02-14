package blackjack.model.Game;

import blackjack.model.Card.Deck;
import blackjack.model.Participant.Participant;
import blackjack.model.Participant.PlayerList;

import java.util.List;

public class Game {
    private final Deck deck;
    private final Participant dealer;
    private final PlayerList playerList;

    public Game(PlayerList playerList) {
        this.deck  = new Deck();
        this.dealer = new Participant();
        this.playerList = playerList;
    }

    public Participant getDealer() {
        return this.dealer;
    }

    public List<Participant> getPlayerList() {
        return playerList.getPlayerList();
    }

    public void setInitialCard() {
        for (Participant player : playerList.getPlayerList()) {
            player.getNewCard(deck);
            player.getNewCard(deck);
        }
        dealer.getNewCard(deck);
        dealer.getNewCard(deck);
    }

    public void getNewCard(Participant player) {
        player.getNewCard(deck);
    }

    public boolean isDealerGetNewCard() {
        dealer.calculateScore();
        if (dealer.getScore() <= 17) {
            dealer.getNewCard(deck);
            return true;
        }
        return false;
    }
    public void calculateScore() {
        dealer.calculateScore();
        for (Participant player : playerList.getPlayerList()) {
            player.calculateScore();
        }
    }
    public void getResult() {
        for (Participant player : playerList.getPlayerList()) {
            if (checkIfPlayerWin(player)) {
                player.addWinCount();
                continue;
            }
            dealer.addWinCount();
        }
    }

    private boolean checkIfPlayerWin(Participant player) {
        return (dealer.getScore() > 21) || (player.getScore() <= 21 && dealer.getScore() <= player.getScore());
    }

    public boolean checkPlayerResult(Participant player) {
        return (player.getWinCount() == 1);
    }
}
