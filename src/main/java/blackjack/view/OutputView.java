package blackjack.view;

import blackjack.Participant;
import blackjack.Card;
import java.util.List;
import java.util.Collections;

public class OutputView {

    public void printInputPlayerNameMessage() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public void printCardSharedMessage(List<String> playerList) {
        System.out.println("\n딜러와 " + String.join(", ",playerList) + "에게 2장을 나누었습니다.");
    }

    public void printDealerGetNewCardMessage() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printCardList(Participant participant) {
        System.out.println(participant.getName()+": "+String.join(", ", participant.getCardNameList()));
    }

}
