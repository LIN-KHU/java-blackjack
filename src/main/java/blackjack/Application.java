package blackjack;

import java.util.Scanner;

import blackjack.controller.GameController;
import blackjack.controller.ParticipantController;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView input = new InputView(new Scanner(System.in));
        OutputView output = new OutputView();

        ParticipantController participant = new ParticipantController(input, output);
        GameController gameController = new GameController(input, output);

        Game game = new Game(participant,gameController);
        game.doGame();
    }


}
