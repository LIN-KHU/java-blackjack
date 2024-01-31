package blackjack.view;


import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readPlayerName() {
        String player = Console.readLine();
        List<String> playerList = Arrays.asList(player.split(","));
        return playerList;
    }

    public String readPlayerStayOrHitState() {
        return Console.readLine();
    }
}
