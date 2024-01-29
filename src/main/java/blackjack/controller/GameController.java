package blackjack.controller;

import blackjack.Deck;
import blackjack.Participant;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;
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
        }
        output.printPlayerCardList(player);
        output.printNewLine();
    }

    public void printScore(Participant dealer, List<Participant> playerList) {
        output.printDealerResultCardList(dealer);
        output.printScore(dealer.getScore());
        for (Participant player : playerList) {
            output.printPlayerCardList(player);
            output.printScore(player.getScore());
        }
    }

    public void printResult(Participant dealer, List<Participant> playerList) {
        output.printNewLine();
        output.printDealerResult(dealer, playerList.size());
        for (Participant player : playerList) {
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
