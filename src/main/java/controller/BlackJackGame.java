package controller;

import model.Dealer;
import model.Player;
import model.PlayerList;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGame {

    public static void start() {
        List<Player> players = inputPlayer();
        PlayerList playerList = new PlayerList(players);
        Dealer dealer = new Dealer();
        assignCard(dealer, playerList);
        drawCard(playerList, dealer);
        OutputView.printResultSum(dealer, playerList);
        getFinalWinLose(dealer, playerList);
    }

    private static List<Player> inputPlayer() {
        OutputView.printInputPlayerNameMessage();
        String playerNames = InputView.inputPlayerName();
        List<String> playerNameList = Arrays.asList(playerNames.split(","));
        return playerNameList.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private static void assignCard(Dealer dealer, PlayerList playerList) {
        OutputView.printCardAssignment(playerList);
        OutputView.printDealerAndPlayerCard(dealer, playerList);
    }

    private static void drawCard(PlayerList playerList, Dealer dealer) {
        for (Player player : playerList.getPlayerList()) {
            drawPlayerCard(player);
        }
        drawDealerCard(dealer);
    }

    private static void drawPlayerCard(Player player) {
        while (true) {
            OutputView.printDrawPlayerCardMessage(player);
            String playerInput = InputView.inputPlayerMoreCard();
            if (playerInput.equals("y")) {
                player.getCardList().addCard();
            }
            OutputView.printPlayerCard(player);
            if (playerInput.equals("n")) {
                break;
            }
        }
    }

    private static void drawDealerCard(Dealer dealer) {
        if (dealer.getCardList().getSum() > 16) {
            OutputView.printNotDrawDealerCardMessage();
        }
        if (dealer.getCardList().getSum() <= 16) {
            OutputView.printDrawDealerCardMessage();
            dealer.getCardList().addCard();
        }
    }

    private static void getFinalWinLose(Dealer dealer, PlayerList playerList) {
        calculateDealerWinLose(dealer, playerList);
        calculatePlayerWinLose(dealer, playerList);
    }

    private static void calculateDealerWinLose(Dealer dealer, PlayerList playerList) {
        int dealerWin = 0;
        int dealerLose = 0;
        int dealerSum = dealer.getCardList().getSum();
        for (Player player : playerList.getPlayerList()) {
            int playerSum = player.getCardList().getSum();
            dealerWin = getDealerWin(dealerSum, playerSum, dealerWin);
            dealerLose = getDealerLose(dealerSum, playerSum, dealerLose);
        }
        OutputView.printFinalWin(dealerWin, dealerLose);
    }

    private static int getDealerWin(int dealerSum, int playerSum, int dealerWin) {
        if (dealerSum > playerSum) {
            dealerWin += 1;
        }
        return dealerWin;
    }

    private static int getDealerLose(int dealerSum, int playerSum, int dealerLose) {
        if (dealerSum < playerSum) {
            dealerLose += 1;
        }
        return dealerLose;
    }

    private static void calculatePlayerWinLose(Dealer dealer, PlayerList playerList) {
        int dealerSum = dealer.getCardList().getSum();
        for (Player player : playerList.getPlayerList()) {
            boolean isWin = false;
            int playerSum = player.getCardList().getSum();
            isWin(playerList, player, dealerSum, isWin);
            if (isWin && playerSum > dealerSum) {
                OutputView.printFinalPlayerResult(player, isWin);
            }
        }
    }

    private static boolean isWin(PlayerList playerList, Player player, int dealerSum, boolean isWin) {
        int playerSum = player.getCardList().getSum();
        for (Player otherPlayer : playerList.getPlayerList()) {
            if (playerSum < otherPlayer.getCardList().getSum() || playerSum < dealerSum) {
                isWin = false;
                OutputView.printFinalPlayerResult(player, isWin);
                break;
            }
            if (playerSum > otherPlayer.getCardList().getSum()) {
                isWin = true;
            }
        }
        return isWin;
    }
}
