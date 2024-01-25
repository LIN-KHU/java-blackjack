package blackjack.controller;

import blackjack.Deck;
import blackjack.Participant;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class ParticipantController {
    private final InputView input;
    private final OutputView output;

    public ParticipantController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public List<Participant> setPlayer() {
        output.printInputPlayerNameMessage();
        List<String> playerList = input.readPlayerName();
        List<Participant> players = new ArrayList<Participant>();
        for (String name : playerList) {
            players.add(new Participant(name));
        }
        return players;
    }

    public Participant setDealer() {
        return new Participant();
    }

    public void printCardList(List<Participant> playerList, Participant dealer) {
        output.printCardSharedMessage(playerList);
        output.printDealerInitialCardList(dealer);
        for (Participant player : playerList) {
            output.printPlayerCardList(player);
        }
        output.printNewLine();
    }
}
