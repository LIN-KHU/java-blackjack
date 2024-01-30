package blackjack.rule;

import java.util.*;
import blackjack.Participant;


public class BlackJackGame {
    public static Map<String, blackjack.Participant.ParticipantState> simulateCardGame(List<String> participants, Map<String, List<Integer>> Cards) {
        Map<String, blackjack.Participant.ParticipantState> participantStates = new HashMap<>();

        for (String participant : participants) {
            participantStates.put(participant, new blackjack.Participant.ParticipantState());
        }

        for (String participant : participants) {
            blackjack.Participant.ParticipantState participantState = participantStates.get(participant);
            OperationWithCard.performCardOperation(Cards, shuffledCard -> {
                int value = shuffledCard.getValue();
                String cardName = shuffledCard.getKey();
                participantState.updateSumAndNameList(value, cardName);
            });
        }
        return participantStates;

    }

}







