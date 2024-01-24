package controller;

import domain.BlackJackGame;
import view.input.InputView;
import view.output.ResultView;

public class BlackJackController {

    private final InputView inputView;
    private final ResultView resultView;
    private BlackJackGame blackJackGame;

    public BlackJackController(InputView inputView, ResultView resultView){
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start(){

    }
}
