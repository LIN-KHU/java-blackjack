package blackjack;

import blackjack.controller.GameController;
import blackjack.controller.ParticipantController;

public class Game {
    private final GameController game;
    private final ParticipantController participant;
    private final Deck deck;
    private final Participant dealer;

    public Game(ParticipantController participant,GameController game) {
        this.participant = participant;
        this.game = game;
        this.deck  = new Deck();
        this.dealer = new Participant();
    }

    public void doGame() {
        PlayerList playerlist = participant.setPlayer();
        setInitialCard(playerlist);
        participant.printCardList(playerlist, dealer);
        getNewCardPlayer(playerlist);
        participant.checkDealer(dealer, deck);
        setScore(playerlist);
        getResult(playerlist);
        game.printScore(dealer,playerlist);
        game.printResult(dealer,playerlist);
    }

    public void setInitialCard(PlayerList playerlist) {
        for (Participant player : playerlist.getPlayerList()) {
            player.getNewCard(deck);
            player.getNewCard(deck);
        }
        dealer.getNewCard(deck);
        dealer.getNewCard(deck);
    }

    private void getNewCardPlayer(PlayerList playerList) {
        for (Participant player : playerList.getPlayerList()) {
            game.DrewNewCard(player, deck);
        }
    }
    public void setScore(PlayerList playerList) {
        dealer.calculateScore();
        for (Participant player : playerList.getPlayerList()) {
            player.calculateScore();
            checkPlayerAce(player);
        }
    }

    private void checkPlayerAce(Participant player) {
        for (Card card : player.getCardList()) {
            if (card.checkScoreIfAce() && player.getScore() > 21) {
                player.setScore(player.getScore() - 10);
            }
        }
    }

    public void getResult(PlayerList playerList) {
        for (Participant player : playerList.getPlayerList()) {
            if (checkIfPlayerWin(player)) {
                player.setWin();
                continue;
            }
            dealer.setWin();
        }
    }

    private boolean checkIfPlayerWin(Participant player) {
        return (dealer.getScore() > 21) || (player.getScore() <= 21 && dealer.getScore() <= player.getScore());
    }
}
