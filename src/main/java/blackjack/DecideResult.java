package blackjack;

import java.util.Map;
public class DecideResult {
    public static String determineWinner(Map<String, CardGameSimulator.ParticipantState> participantStates) {
        String winner = null;
        int HighestSum = Integer.MIN_VALUE;

        for (Map.Entry<String, CardGameSimulator.ParticipantState> entry : participantStates.entrySet()) {
            CardGameSimulator.ParticipantState participantState = entry.getValue();
            int sum = participantState.printsum();

            if(sum > HighestSum) {
                HighestSum = sum;
                winner = entry.getKey();
            }
        }

        return winner;
    }
}
