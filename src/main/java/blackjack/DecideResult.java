package blackjack;

import java.util.List;
import java.util.Map;

public class DecideResult {
    public static int DealerScore(Map.Entry<String, Participant.ParticipantState> dealerEntry) {
        int sum = dealerEntry.getValue().printsum();
        return sum;
    }

    public static void CompareWithDealer(List<String> participants, int DealerSum, Map<String, Participant.ParticipantState> participantStates) {

        int win = 0;
        int loss = 0;

        for (Map.Entry<String, Participant.ParticipantState> entry : participantStates.entrySet()) {
            int participantSum = entry.getValue().printsum();
            if (participantSum <= 21) {
                if (DealerSum > participantSum) {
                    win += 1;
                    entry.getValue().WinOrLoss(1);
                }
                if (DealerSum < participantSum) {
                    loss += 1;
                    entry.getValue().WinOrLoss(0);
                }
            } else {
                win +=1;
            }
        }

        System.out.println("## 최종 승패");
        System.out.println("딜러: " + win + "승 " + loss + '패');

        for (Map.Entry<String, Participant.ParticipantState> entry : participantStates.entrySet()) {
            String name = entry.getValue().printname();
            System.out.println(name + ": " + entry.getValue().printwinorloss());

        }
    }
}