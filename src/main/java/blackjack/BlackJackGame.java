package blackjack;

import java.util.*;


public class BlackJackGame {
    public static Map<String, Participant.ParticipantState> simulateCardGame(List<String> participants, Map<String, List<Integer>> Cards) {
        Map<String, Participant.ParticipantState> participantStates = new HashMap<>();

        for (String participant : participants) {
            participantStates.put(participant, new Participant.ParticipantState());
        }

        for (String participant : participants) {
            Participant.ParticipantState participantState = participantStates.get(participant);
            OperationWithCard.performCardOperation(Cards, shuffledCard -> {
                int value = shuffledCard.getValue();
                String cardName = shuffledCard.getKey();
                participantState.updateSumAndNameList(value, cardName);
            });
        }
        return participantStates;

    }

}







