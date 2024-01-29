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
        List<String> playerNameList = input.readPlayerName();
        List<Participant> playerList = new ArrayList<Participant>();
        for (String name : playerNameList) {
            playerList.add(new Participant(name));
        }
        return playerList;
    }

    public void printCardList(List<Participant> playerList, Participant dealer) {
        output.printCardSharedMessage(playerList);
        output.printDealerInitialCardList(dealer);
        output.printNewLine();
        for (Participant player : playerList) {
            output.printPlayerCardList(player);
            output.printNewLine();
        }
        output.printNewLine();
    }

    public void checkDealer(Participant dealer, Deck deck) {
        dealer.calculateScore();
        if (dealer.getScore() <= 17) {
            output.printDealerGetNewCardMessage();
            dealer.getNewCard(deck);
        }
    }
}
