package controller;

import domain.BlackJackGame;
import view.input.InputView;
import view.output.ResultView;

import java.util.List;

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

    public void makeBlackJackGame(List<String> playerNames){
        this.blackJackGame = new BlackJackGame(playerNames);
    }
    public void startBlackJackGame(){
        blackJackGame.startPhase();
        blackJackGame.playPhase(inputView.readGetCardMoreOrNot());
        blackJackGame.dealerPhase();
    }

    public void showResultBlackJackGame(){

    }
}
