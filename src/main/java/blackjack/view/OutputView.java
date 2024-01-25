package blackjack.view;

import blackjack.Participant;
import blackjack.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class OutputView {

    public void printInputPlayerNameMessage() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public void printCardSharedMessage(List<Participant> playerList) {
        List<String> playerNameList = new ArrayList<>();
        for (Participant player : playerList) {
            playerNameList.add(player.getName());
        }
        System.out.println("\n딜러와 " + String.join(", ", playerNameList) + "에게 2장을 나누었습니다.");
    }

    public void printDealerGetNewCardMessage() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printPlayerCardList(Participant participant) {
        System.out.println(participant.getName()+"카드: "+String.join(", ", participant.getCardNameList()));
    }

    public void printDealerInitialCardList(Participant participant) {
        System.out.println(participant.getName()+": "+String.join(", ", participant.getCardNameList()));
    }

    public void printDealerResultCardList(Participant participant) {
        System.out.println(participant.getName()+" : "+String.join(", ", participant.getCardNameList()));
    }

    public void printAskIfDrawNewCardMessage(Participant player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public void printNewLine() {
        System.out.println();
    }
}
