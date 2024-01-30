package blackjack.rule;

import blackjack.view.InputView;
import java.util.List;
import java.util.Map;
import blackjack.Participant;

public class canReceiveCard {
    public static void ParticipantBetween16And21(String participant, Map.Entry<String, blackjack.Participant.ParticipantState> participantEntry, Map<String, List<Integer>> Cards) {
        playTurn(new Participant(), participant, participantEntry, Cards);
    }

    public static void DealerBetween16And21(String Dealer, Map.Entry<String, blackjack.Participant.ParticipantState> DealerEntry, Map<String, List<Integer>> Cards) {
        playTurn(new Dealer(), Dealer, DealerEntry, Cards);
    }

    public static void playTurn(CardGameParticipant participant, String name, Map.Entry<String, blackjack.Participant.ParticipantState> entry, Map<String, List<Integer>> Cards) {
        while (true) {
            int sum = entry.getValue().getSum(Cards);

            if (sum < 16 || sum >= 21) {
                break;
            }

            if (sum > 16 && sum < 21) {
                System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
                String answer = InputView.getInput("", String::valueOf);


                if ("y".equalsIgnoreCase(answer)) {
                    Map.Entry<String, Integer> extraCard = OperationWithCard.getRandomCard(Cards);
                    int extraCardValue = extraCard.getValue();
                    String extraCardName = extraCard.getKey();
                    entry.getValue().updateSumAndNameList(extraCardValue, extraCardName);

                    System.out.println(name + "카드: " + entry.getValue().printcardlist());

                    if (participant.shouldContinue()) {
                        continue;
                    } else {
                        break;
                    }
                } else if ("n".equalsIgnoreCase(answer)) {
                    System.out.println(name + "카드: " + entry.getValue().printcardlist());
                    break;

                }
            }
        }
    }

    static class Participant implements CardGameParticipant {
        @Override
        public void playTurn(String participant, Map.Entry<String, blackjack.Participant.ParticipantState> participantEntry, Map<String, List<Integer>> Cards) {

        }

        @Override
        public boolean shouldContinue() {
            return true;
        }
    }

    static class Dealer implements CardGameParticipant {
        @Override
        public void playTurn(String participant, Map.Entry<String, blackjack.Participant.ParticipantState> participantEntry, Map<String, List<Integer>> Cards) {

        }

        @Override
        public boolean shouldContinue() {
            return false;
        }
    }
}
