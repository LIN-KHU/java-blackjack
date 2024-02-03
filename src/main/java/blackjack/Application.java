package blackjack;

import blackjack.controller.GameController;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        GameController gameController = new GameController(input, output);
        gameController.start();
    }
}
