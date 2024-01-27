package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Between16And21 {
    public static void SumBetween16And21(String participant, Map.Entry<String, CardGameSimulator.ParticipantState> participantEntry, Map<String, List<Integer>> Cards) {
        while(true) {
            CardGameSimulator.ParticipantState participantState = participantEntry.getValue();
            int sum = participantState.getSum(Cards);

            if (sum < 16 || sum >=21) {
                break;
            }

            if (sum > 16 && sum < 21) {
                System.out.println(participant+ "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
                Scanner scanner = new Scanner(System.in);
                String answer =  scanner.nextLine();

                if("y".equalsIgnoreCase(answer)) {
                    Map.Entry<String, Integer> extraCard = CardGameSimulator.getRandomCard(Cards);
                    int extraCardValue = extraCard.getValue();
                    String extraCardName = extraCard.getKey();
                    participantState.updateSumAndNameList(extraCardValue, extraCardName);

                    System.out.println(participant + "카드: " + participantState.printlist());
                    //16과 21인지 판단하고 만약 중간이라면 다시 SumBetween16and21 실행 아니면 continue
                } else if ("n".equalsIgnoreCase(answer)) {
                    System.out.println(participant + "카드: " + participantState.printlist());
                    break;

                }
            }
        }
    }
}
