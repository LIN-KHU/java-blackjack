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



}
