package blackjack.controller;

import blackjack.Deck;
import blackjack.Participant;
import blackjack.PlayerList;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class GameController {

    private final InputView input;
    private final OutputView output;

    public GameController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void DrewNewCard(Participant player, Deck deck) {
        while (true){
            output.printAskIfDrawNewCardMessage(player);
            if (input.readCommand() == 'n') {
                break;
            }
            player.getNewCard(deck);
            printPlayerCardList(player);
        }
        printPlayerCardList(player);
    }

    private void printPlayerCardList(Participant player) {
        output.printPlayerCardList(player);
        output.printNewLine();
    }
    public void printScore(Participant dealer, PlayerList playerList) {
        output.printDealerResultCardList(dealer);
        output.printScore(dealer.getScore());
        for (Participant player : playerList.getPlayerList()) {
            output.printPlayerCardList(player);
            output.printScore(player.getScore());
        }
    }

    public void printResult(Participant dealer, PlayerList playerList) {
        output.printNewLine();
        output.printDealerResult(dealer, playerList.size() - dealer.getWin());
        for (Participant player : playerList.getPlayerList()) {
            checkIfPlayerWin(player);
            checkIfPlayerLose(player);
        }
    }

    private void checkIfPlayerWin(Participant player) {
        if (player.getWin() == 1) {
            output.printPlayerWinResult(player);
        }
    }

    private void checkIfPlayerLose(Participant player) {
        if (player.getWin() != 1) {
            output.printPlayerLoseResult(player);
        }
    }
}
