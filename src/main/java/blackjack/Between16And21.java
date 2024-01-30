package blackjack;

import blackjack.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Between16And21 {
    public static void SumBetween16And21(String participant, Map.Entry<String, Participant.ParticipantState> participantEntry, Map<String, List<Integer>> Cards) {
        while(true) {
            int sum = participantEntry.getValue().getSum(Cards);
            String name = participantEntry.getValue().printname();

            if (sum < 16 || sum >=21) {
                break;
            }

            if (sum > 16 && sum < 21) {
                System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
                String answer = InputView.getInput("",String::valueOf);


                if("y".equalsIgnoreCase(answer)) {
                    Map.Entry<String, Integer> extraCard = OperationWithCard.getRandomCard(Cards);
                    int extraCardValue = extraCard.getValue();
                    String extraCardName = extraCard.getKey();
                    participantEntry.getValue().updateSumAndNameList(extraCardValue, extraCardName);

                    System.out.println(name + "카드: " + participantEntry.getValue().printcardlist());

                    if (participantEntry.getValue().printsum() > 16 && participantEntry.getValue().printsum() <= 21) {
                        continue;
                    } else {
                        break;
                    }
                    //16과 21인지 판단하고 만약 중간이라면 다시 SumBetween16and21 실행 아니면 continue
                } else if ("n".equalsIgnoreCase(answer)) {
                    System.out.println(name + "카드: " + participantEntry.getValue().printcardlist());
                    break;

                }
            }
        }
    }

    public static void DealerBetween16And21(String Dealer, Map.Entry<String, Participant.ParticipantState> DealerEntry, Map<String, List<Integer>> Cards) {
        int sum = DealerEntry.getValue().getSum(Cards);

        while(true) {
            if (sum > 21 || (16 < sum && sum <= 21)) {
                break;
            }

            if (sum < 16) {
                Map.Entry<String, Integer> extraCard = OperationWithCard.getRandomCard(Cards);
                int extraCardValue = extraCard.getValue();
                String extraCardName = extraCard.getKey();
                DealerEntry.getValue().updateSumAndNameList(extraCardValue, extraCardName); //DealerEntry<name, Map<String, CardGameSimulator.ParticipantState>
                System.out.println(Dealer + "카드: " + DealerEntry.getValue().printcardlist());
                break;
            }
        }
    }
}
