package view.input;

import java.util.Scanner;
import java.util.List;

public class InputView {
    private final String PLAYER_NAMES_INPUT_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private final String PLAYER_GET_CARD_INPUT_MESSAGE = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    private final Scanner scanner;
    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> readPlayerName(){
        System.out.println(PLAYER_NAMES_INPUT_MESSAGE);

        final String delimiter = ",";
        String playerNames = scanner.nextLine();

        return List.of(playerNames.split(delimiter));
    }

    public String readGetCardMoreOrNot(String player){
        System.out.printf(PLAYER_GET_CARD_INPUT_MESSAGE, player);

        String yesOrNo = scanner.nextLine();

        return yesOrNo;
    }
}
