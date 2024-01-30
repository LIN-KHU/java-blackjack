package blackjack.view;

import blackjack.Participant;

import java.util.Map;

public class OutView {
    public static void printFinalResults(int win, int loss, Map<String, Participant.ParticipantState> participantStates) {
        System.out.println("## 최종 승패");
        System.out.println("딜러: " + win + "승 " + loss + "패");

        for (Map.Entry<String, Participant.ParticipantState> entry : participantStates.entrySet()) {
            String name = entry.getValue().printname();
            System.out.println(name + ": " + entry.getValue().printwinorloss());

        }
    }
}
