package view;

import carddeck.Card;
import participant.Dealer;
import participant.Participant;
import participant.Player;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public void printInputPlayerNameMessage() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public void printInitialCardDistributionMessage(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            stringBuilder.append(names.get(i));
            if (i < names.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        System.out.printf("\n딜러와 %s에게 2장을 나누었습니다.\n", stringBuilder);
    }

    public void printParticipantCardList(Participant participant) {
        List<Card> cardList = participant.getCardList();
        StringBuilder stringBuilder = new StringBuilder();
        if (participant instanceof Player) {
            stringBuilder.append(participant.getName()).append("카드: ");
        }
        if (participant instanceof Dealer) {
            stringBuilder.append(participant.getName()).append(": ");
        }
        stringBuilder.append(cardListString(cardList));
        System.out.println(stringBuilder);
    }

    private StringBuilder cardListString(List<Card> cardList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cardList.size(); i++) {
            stringBuilder.append(cardList.get(i).toString());
            if (i < cardList.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder;
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printAskForAdditionalCard(String name) {
        System.out.printf("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n", name);
    }

    public void printDealerGetOneMoreCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }

    public void printScore(Participant participant, int score) {
        List<Card> cardList = participant.getCardList();
        StringBuilder stringBuilder = new StringBuilder();
        if (participant instanceof Player) {
            stringBuilder.append(participant.getName()).append("카드: ");
        }
        if (participant instanceof Dealer) {
            stringBuilder.append(participant.getName()).append(" 카드: ");
        }
        stringBuilder.append(cardListString(cardList).append(" - 결과: ").append(score));
        System.out.println(stringBuilder);
    }

    public void printFinalResult(List<Integer> dealerResult, HashMap<String, String> playerResult) {
        System.out.println("## 최종 승패");
        System.out.println(getDealerString(dealerResult));
        for (String name : playerResult.keySet()) {
            System.out.println(name + ": " + playerResult.get(name));
        }
    }

    private StringBuilder getDealerString(List<Integer> dealerResult) {
        StringBuilder dealerString = new StringBuilder();
        dealerString.append("딜러: ");
        if (dealerResult.get(0) > 0) {
            dealerString.append(dealerResult.get(0)).append("승 ");
        }
        if (dealerResult.get(1) > 0) {
            dealerString.append(dealerResult.get(1)).append("패 ");
        }
        if (dealerResult.get(2) > 0) {
            dealerString.append(dealerResult.get(2)).append("무승부");
        }
        return dealerString;
    }
}
