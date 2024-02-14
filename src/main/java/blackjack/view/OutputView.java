package blackjack.view;

import blackjack.model.Participant.Participant;
import blackjack.model.Participant.PlayerList;

import java.util.ArrayList;
import java.util.List;

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
    public void printDealerInitialCardList(Participant participant) {
        System.out.println(participant.getName()+": "+participant.getCardNameList().get(0));
    }
    public void printPlayersInitialCardList(List<Participant> playerList) {
        for (Participant player : playerList) {
            printPlayerCardListWithName(player);
            System.out.println();
        }
        System.out.println();
    }
    public void printPlayerCardListWithName(Participant participant) {
        System.out.print(participant.getName()+"카드: "+String.join(", ", participant.getCardNameList()));
    }
    public void printDealerGetNewCardMessage() {
        System.out.println("\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }

    public void printDealerResultCardList(Participant participant) {
        System.out.print(participant.getName()+" 카드: "+String.join(", ", participant.getCardNameList()));
    }

    public void printAskIfDrawNewCardMessage(Participant player) {
        System.out.println(player.getName() + " 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printScore(int score) {
        System.out.println(" - 결과: " + Integer.toString(score));
    }

    public void printDealerResult(Participant dealer, int dealerLose) {
        System.out.println(dealer.getName()+": "+dealer.getWinCount()+"승 "+(dealerLose)+"패");
    }

    public void printPlayerWinResult(Participant player) {
        System.out.println(player.getName() + ": " + "승");
    }

    public void printPlayerLoseResult(Participant player) {
        System.out.println(player.getName() + ": " + "패");
    }
}
