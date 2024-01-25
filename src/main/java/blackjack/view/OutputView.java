package blackjack.view;

import java.util.ArrayList;
import java.util.Collections;

public class OutputView {

    void printInputPlayerNameMessage() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    void printCardSharedMessage(ArrayList<String> playerList) {
        System.out.println("딜러와 " + String.join(", ",playerList) + "에게 2장을 나누었습니다.");
    }
}
