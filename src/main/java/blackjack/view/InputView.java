package blackjack.view;


import blackjack.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    OutputView outputView = new OutputView();

    public List<Player> readPlayerName() {
        outputView.startGameMsg();
        String player = Console.readLine();
        List<String> playerNameList = Arrays.asList(player.split(","));
        List<Player> playerList = new ArrayList<>();

        for(String playerName: playerNameList){
            playerList.add(new Player(playerName));
        }
        return playerList;
    }

    public String readPlayerStayOrHitState() {
        return Console.readLine();
    }

    public int readPlayerBettingAmount(Player player) {
        outputView.printPlayerBettingAmount(player);
        return Integer.parseInt(Console.readLine());
    }
}
