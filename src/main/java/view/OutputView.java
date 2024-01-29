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
    }

}
