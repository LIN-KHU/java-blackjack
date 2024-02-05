import model.Dealer;
import model.Player;
import model.PlayerList;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        OutputView.printInputPlayerNameMessage();
        String playerNames = InputView.inputPlayerName();
        List<String> playerNameList = Arrays.asList(playerNames.split(","));
        List<Player> players = playerNameList.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        PlayerList playerList = new PlayerList(players);
        //게임 진행
        Dealer dealer = new Dealer();
        //1)초반 카드 나누기 - 카드 숫자: 하트, 스페이드, 다이아몬드,클로버 => 1~9, A, King, Queen, Jack
        OutputView.printCardAssignment(playerList);
        OutputView.printDealerAndPlayerCard(dealer, playerList);
        //2)카드 뽑기 - player, 딜러 순
        //player가 n 을 입력하면 현재 player의 카드를 보여주고 다음턴
        for (Player player : playerList.getPlayerList()) {
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
        //딜러는 알아서 계산 후 출력
        if (dealer.getCardList().getSum() > 16) {
            OutputView.printNotDrawDealerCardMessage();
        }
        if (dealer.getCardList().getSum() <= 16) {
            OutputView.printDrawDealerCardMessage();
            dealer.getCardList().addCard();
        }

        //게임 종료 - 결과 출력, 기준 : 한 게임 끝나면
        OutputView.printResultSum(dealer, playerList);

        //최종 승패 - dealer는 각 player별로 비교하여 승패 기록, 각 player은 딜러와 다른 player와 비교, 그리고 player가 1등이면 승 아니면 패
        //딜러 승패 계산
        int dealerWin = 0;
        int dealerLose = 0;
        for (Player player : playerList.getPlayerList()) {
            if (dealer.getCardList().getSum() > player.getCardList().getSum()) {
                dealerWin += 1;
            }
            if (dealer.getCardList().getSum() < player.getCardList().getSum()) {
                dealerLose += 1;
            }
        }
        OutputView.printFinalWin(dealerWin, dealerLose);

        //플레이어 승패 계산
        for (Player player: playerList.getPlayerList()) {
            boolean isWin = false;
            int playerSum = player.getCardList().getSum();
            for (Player otherPlayer : playerList.getPlayerList()) {
                if (playerSum < otherPlayer.getCardList().getSum() || playerSum < dealer.getCardList().getSum()) {
                    isWin = false;
                    OutputView.printFinalPlayerResult(player, isWin);
                    break;
                }
                if (player.getCardList().getSum() > otherPlayer.getCardList().getSum()) {
                    isWin = true;
                }
            }
            if (isWin && playerSum > dealer.getCardList().getSum()) {
                OutputView.printFinalPlayerResult(player,isWin);
            }
        }
    }
}
