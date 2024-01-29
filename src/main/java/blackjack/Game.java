package blackjack;

import blackjack.controller.GameController;
import blackjack.controller.ParticipantController;
import java.util.List;

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
        List<Participant> playerlist = participant.setPlayer();
        setInitialCard(playerlist);
        participant.printCardList(playerlist, dealer);
        getNewCardPlayer(playerlist);
        participant.checkDealer(dealer, deck);
        setScore(playerlist);
        getResult(playerlist);
        game.printScore(dealer,playerlist);
        game.printResult(dealer,playerlist);
    }

    public void setInitialCard(List<Participant> playerlist) {
        for (Participant player : playerlist) {
            player.getNewCard(deck);
            player.getNewCard(deck);
        }
        dealer.getNewCard(deck);
        dealer.getNewCard(deck);
    }

    private void getNewCardPlayer(List<Participant> playerList) {
        for (Participant player : playerList) {
            game.DrewNewCard(player, deck);
        }
    }
    public void setScore(List<Participant> playerList) {
        dealer.setScore();
        for (Participant player : playerList) {
            player.setScore();
            for (Card card : player.getCardList()) {
                checkPlayerAce(card, player);
            }
        }
    }

    private void checkPlayerAce(Card card, Participant player) {
        if (card.checkIfAce() && player.getScore() > 21) {
            player.setScore(player.getScore() - 10);
        }
    }

    public void getResult(List<Participant> playerList) {
        int winner = 0;
        for (Participant player : playerList) {
            if (checkIfPlayerWin(player)) {
                winner++;
                player.setWin(1);
            }
        }
        dealer.setWin(playerList.size() - winner);
    }

    private boolean checkIfPlayerWin(Participant player) {
        return (dealer.getScore() > 21) || (dealer.getScore() <= player.getScore());
    }
}
