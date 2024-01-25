package blackjack;

import blackjack.controller.GameController;
import blackjack.controller.ParticipantController;
import java.util.List;

public class Game {
    private final GameController game;
    private final ParticipantController participant;
    private final Deck deck;

    public Game(ParticipantController participant,GameController game) {
        this.participant = participant;
        this.game = game;
        this.deck  = new Deck();
    }

    public void doGame() {
        Participant dealer = participant.setDealer();
        List<Participant> playerlist = participant.setPlayer();
        setInitialCard(playerlist, dealer);
        participant.printCardList(playerlist, dealer);
    }

    public void setInitialCard(List<Participant> playerlist, Participant dealer) {
        for (Participant player : playerlist) {
            player.getNewCard(deck);
            player.getNewCard(deck);
        }
        dealer.getNewCard(deck);
        dealer.getNewCard(deck);
    }

}
