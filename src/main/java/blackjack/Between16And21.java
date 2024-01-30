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
            String name = participantState.getName(participant);

            if (sum < 16 || sum >=21) {
                break;
            }

            if (sum > 16 && sum < 21) {
                System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
                Scanner scanner = new Scanner(System.in);
                String answer =  scanner.nextLine();

                if("y".equalsIgnoreCase(answer)) {
                    Map.Entry<String, Integer> extraCard = CardGameSimulator.getRandomCard(Cards);
                    int extraCardValue = extraCard.getValue();
                    String extraCardName = extraCard.getKey();
                    participantState.updateSumAndNameList(extraCardValue, extraCardName);

                    System.out.println(name + "카드: " + participantState.printcardlist());
                    //16과 21인지 판단하고 만약 중간이라면 다시 SumBetween16and21 실행 아니면 continue
                } else if ("n".equalsIgnoreCase(answer)) {
                    System.out.println(name + "카드: " + participantState.printcardlist());
                    break;

                }
            }
        }
    }

    public static void DealerBetween16And21(String Dealer, Map.Entry<String, CardGameSimulator.ParticipantState> DealerEntry, Map<String, List<Integer>> Cards) {
        CardGameSimulator.ParticipantState DealerState = DealerEntry.getValue();
        int sum = DealerState.getSum(Cards);

        while(true) {
            if (sum > 21 || (16 < sum && sum <= 21)) {
                break;
            }

            if (sum < 16) {
                Map.Entry<String, Integer> extraCard = CardGameSimulator.getRandomCard(Cards);
                int extraCardValue = extraCard.getValue();
                String extraCardName = extraCard.getKey();
                DealerState.updateSumAndNameList(extraCardValue, extraCardName); //DealerEntry<name, Map<String, CardGameSimulator.ParticipantState>
                System.out.println(Dealer + "카드: " + DealerState.printcardlist());
                break;
            }
        }
    }
}
