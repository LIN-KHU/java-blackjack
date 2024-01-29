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
        //2)카드 뽑기

        //게임 종료 - 결과 출력, 기준 :

        //최종 승패



    }
}
