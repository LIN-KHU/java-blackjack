package view;

import model.Dealer;
import model.Player;
import model.PlayerList;

public class OutputView {

    public static void printInputPlayerNameMessage() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public static void printCardAssignment(PlayerList playerList){
        System.out.println("딜러와 " + playerList.toString() + "에게 2장을 나누었습니다.");
    }

    public static void printDealerAndPlayerCard(Dealer dealer, PlayerList playerList) {
        System.out.println(dealer);
        for (Player player : playerList.getPlayerList()) {
            System.out.println(player);
        }
        System.out.println("");
    }

    public static void printDrawPlayerCardMessage(Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public static void printPlayerCard(Player player) {
        System.out.println(player);
    }

    public static void printDrawDealerCardMessage() {
        System.out.println("\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }
    public static void printNotDrawDealerCardMessage() {
        System.out.println("\n딜러는 16초과라 카드를 뽑지 않습니다.\n");
    }

    public static void printResultSum(Dealer dealer, PlayerList playerList) {
        System.out.println(dealer + " - 결과: " + dealer.getCardList().getSum());
        for (Player player : playerList.getPlayerList()) {
            System.out.println(player + " - 결과: " + player.getCardList().getSum());
        }
        System.out.println("");
    }

    public static void printFinalWin(int dealerWin, int dealerLose){
        System.out.println("## 최종 승패");
        if (dealerWin == 0) {
            System.out.println("딜러: " + dealerLose + "패");
        }
        if (dealerLose == 0) {
            System.out.println("딜러: " + dealerWin + "승");
        }
        if (dealerWin != 0 && dealerLose != 0) {
            System.out.println("딜러: " + dealerWin + "승 " + dealerLose + "패");
        }
    }

    public static void printFinalPlayerResult(Player player, boolean isWin) {
        if(isWin) {
            System.out.println(player.getName() + ": " + "승");
        }
        if(!isWin) {
            System.out.println(player.getName() + ": " + "패");
        }
    }

}
