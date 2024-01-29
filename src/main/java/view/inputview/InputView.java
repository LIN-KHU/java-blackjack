package view.inputview;

import java.util.Scanner;

public class InputView {

    public String inputPlayerName() {
        Scanner sc = new Scanner(System.in);
        String playerNameStr = sc.nextLine();
        return playerNameStr;
    }

}
