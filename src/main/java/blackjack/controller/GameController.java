package blackjack.controller;

import blackjack.model.Card.Deck;
import blackjack.model.Game.Game;
import blackjack.model.Participant.Participant;
import blackjack.model.Participant.PlayerList;
import blackjack.model.Participant.PlayerNameList;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class GameController {

    private final InputView input;
    private final OutputView output;
    private Game game;

    public GameController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }
    public void start() {
        initializeGame();
        doGame();
        result();
    }
    private void initializeGame() {
        this.game = new Game(inputPlayer());
        game.setInitialCard();
        output.printCardSharedMessage(game.getPlayerList());
        output.printDealerInitialCardList(game.getDealer());
        output.printPlayersInitialCardList(game.getPlayerList());
    }
    private PlayerList inputPlayer() {
        output.printInputPlayerNameMessage();
        PlayerNameList playerNameList = input.readPlayerName();
        return new PlayerList(playerNameList);
    }
    public void doGame() {
        for (Participant player : game.getPlayerList()) {
            while (askPlayerIsExit(player)){
                game.getNewCard(player);
                output.printPlayerCardListWithName(player);
                output.printNewLine();
            }
            output.printPlayerCardListWithName(player);
            output.printNewLine();
        }
    }
    private boolean askPlayerIsExit(Participant player) {
        output.printAskIfDrawNewCardMessage(player);
        return (input.readCommand() == 'y');
    }
    private void result() {
        checkDealer();
        game.calculateScore();
        game.getResult();
        printScore(game.getDealer());
        printResult(game.getDealer());
    }
    public void checkDealer() {
        if (game.isDealerGetNewCard()) {
            output.printDealerGetNewCardMessage();
        }
    }
    public void printScore(Participant dealer) {
        output.printDealerResultCardList(dealer);
        output.printScore(dealer.getScore());
        for (Participant player : game.getPlayerList()) {
            output.printPlayerCardListWithName(player);
            output.printScore(player.getScore());
        }
        output.printNewLine();
    }

    public void printResult(Participant dealer) {
        output.printDealerResult(dealer, game.getPlayerList().size() - dealer.getWinCount());
        for (Participant player : game.getPlayerList()) {
            printPlayerResult(player);
        }
    }

    private void printPlayerResult(Participant player) {
        if (game.checkPlayerResult(player)) {
            output.printPlayerWinResult(player);
            return;
        }
        output.printPlayerLoseResult(player);
    }

}
