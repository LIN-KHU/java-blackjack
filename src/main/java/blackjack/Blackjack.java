package blackjack;

import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static blackjack.message.MessageConst.*;

public class Blackjack {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    List<Player> playerList = new ArrayList<>();

    Dealer dealer = new Dealer();
    CardGenerator cardGenerator = new CardGenerator();
    GameResult gameResult = new GameResult();

    private static final String Y = "y";
    private static final String N = "n";

    public void startGame() {
        getPlayerName();
//        setBettingAmount();
        initializeCard();
        printPlayerCard();
        playerChooseStayOrHit();
        dealerGetCard();
        gameOver();
    }

    private void getPlayerName() {
        List<Player> playerList = inputView.readPlayerName();
        this.playerList.addAll(playerList);

    }

//    private void setBettingAmount(){
//        for(Player player : playerList){
//            player.setBettingAmount(inputView.readPlayerBettingAmount(player));
//        }
//    }

    private void initializeCard() {
        outputView.giveCardMsg(playerList);
        for (int i = 0; i < 2; i++) {
            dealer.setCards(cardGenerator.getCard());
            for (Player player : playerList) {
                player.giveCard(cardGenerator.getCard());
            }
        }
    }

    private void printPlayerCard() {
        outputView.printDealerCard(dealer);
        for (Player player : playerList) {
            outputView.printPlayerCard(player);
        }
    }

    private void playerChooseStayOrHit() {

        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
            while (true) {
                outputView.stayOrHitMsg(player);
                String playerStayOrHitState = inputView.readPlayerStayOrHitState();

                if (playerStayOrHitState.equals("y")) {
                    player.getCard(cardGenerator.getCard());
                    outputView.printPlayerCard(player);
                    if(player.getSumCardNumber() < 22){
                        i--;
                    } else {
                        outputView.printSumCardNumberOver();
                    }
                    break;
                } else if (playerStayOrHitState.equals("n")) {
                    outputView.printPlayerCard(player);
                    break;
                } else {
                    outputView.printStateInputErrorMsg();
                }
            }
        }
    }

    private void dealerGetCard() {
        if (dealer.calculateCardSum() < 17) {
            outputView.printDealerGetMoreCardMsg();
            dealer.setCards(cardGenerator.getCard());
        }
    }

    private void gameOver() {
        outputView.printGameResult(dealer, playerList);
        getWinner(dealer, playerList);
    }

    private void getWinner(Dealer dealer, List<Player> playerList) {
        int dealerResult = dealer.calculateCardSum();
        int dealerResultNum = Math.abs(21 - dealerResult);
        int dealerWin = 0;
        int dealerLose = 0;

        for (Player player : playerList) {
            int playerResultNum = Math.abs(21 - player.calculateCardSum());
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
