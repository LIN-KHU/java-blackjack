package blackjack;

import blackjack.message.MessageConst;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static blackjack.message.MessageConst.*;

public class Blackjack {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    List<Player> playerList = new ArrayList<>();

    Dealer dealer = new Dealer();
    Card card = new Card();

    public void startGame() {
        getPlayerName();
        initializeCard();
        printPlayerCard();
        stayOrHit();
        dealerGetCard();
        gameOver();
    }

    private void getPlayerName() {
        outputView.startGameMsg();
        List<String> playerList = inputView.readPlayerName();
        for (String playerName : playerList) {
            this.playerList.add(new Player(playerName));
        }
    }

    private void initializeCard() {
        outputView.giveCardMsg(playerList);
        for (int i = 0; i < 2; i++) {
            dealer.getCard(card.getCard());
            for (Player player : playerList) {
                player.getCard(card.getCard());
            }
        }
    }

    private void printPlayerCard() {
        dealer.printCard();
        for (Player player : playerList) {
            player.printCard();
        }
    }

    private void stayOrHit() {

        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
            while (true) {
                outputView.stayOrHitMsg(player);
                String playerStayOrHitState = player.chooseStayOrHit(inputView.readPlayerStayOrHitState());

                if (playerStayOrHitState == "y") {
                    player.getCard(card.getCard());
                    player.printCard();
                    if(player.getSumCardNumber() < 22){
                        i--;
                    } else {
                        outputView.printSumCardNumberOver();
                    }
                    break;
                } else if (playerStayOrHitState == "n") {
                    player.printCard();
                    break;
                } else {
                    outputView.printStateInputErrorMsg();
                }
            }
        }
    }

    private void dealerGetCard() {
        if (dealer.getSumCardNumber() < 17) {
            outputView.printDealerGetMoreCardMsg();
            dealer.getCard(card.getCard());
        }
    }

    private void gameOver() {
        outputView.printGameResult(dealer, playerList);
        getWinner(dealer, playerList);
    }

    private void getWinner(Dealer dealer, List<Player> playerList) {
        int dealerResult = dealer.getSumCardNumber();
        int dealerResultNum = Math.abs(21 - dealerResult);
        int dealerWin = 0;
        int dealerLose = 0;

        for (Player player : playerList) {
            int playerResultNum = Math.abs(21 - player.getSumCardNumber());
            if (dealerResultNum > playerResultNum) {
                player.setGameResult(WIN);
                dealerLose++;
            } else {
                player.setGameResult(LOSE);
                dealerWin++;
            }
        }
        outputView.printGameWinner(dealerWin,dealerLose,playerList);
    }
}
