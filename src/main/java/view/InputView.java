package view;

import constants.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public List<String> inputPlayerName() {
        String playerNameStr = this.sc.nextLine();
        if (playerNameStr.isBlank()) {
            throw new IllegalArgumentException("값을 입력하시오.");
        }
        List<String> list = Arrays.asList(playerNameStr.split(","));
        List<String> playerNameList = new ArrayList<String>();
        for (String name : list) {
            playerNameList.add(name.trim());
        }
        return playerNameList;
    }

    public String askForAdditionalCard() {
        String answer = this.sc.nextLine();
        validateAnswer(answer);
        return answer;
    }

    private void validateAnswer(String value) {
        if (!(value.equals(Constant.YES) || value.equals(Constant.NO))) {
            throw new IllegalArgumentException("y 또는 n을 입력하시오.");
        }
    }

}
