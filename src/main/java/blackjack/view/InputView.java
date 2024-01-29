package blackjack.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPlayerName() {
        return Console.readLine();
    }

    public String readPlayerStayOrHitState() {
        return Console.readLine();
    }
}
