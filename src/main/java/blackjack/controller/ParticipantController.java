package blackjack.controller;

import blackjack.Deck;
import blackjack.Participant;
import blackjack.PlayerList;
import blackjack.PlayerNameList;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class ParticipantController {
    private final InputView input;
    private final OutputView output;

    public ParticipantController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public PlayerList setPlayer() {
        output.printInputPlayerNameMessage();
        PlayerNameList playerNameList = input.readPlayerName();
        PlayerList playerList = new PlayerList();
        for (String name : playerNameList.getPlayerNameList()) {
            playerList.add(new Participant(name));
        }
        return playerList;
    }

    public void printCardList(PlayerList playerList, Participant dealer) {
        output.printCardSharedMessage(playerList);
        output.printDealerInitialCardList(dealer);
        output.printNewLine();
        for (Participant player : playerList.getPlayerList()) {
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
