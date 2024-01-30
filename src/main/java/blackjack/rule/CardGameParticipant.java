package blackjack.rule;

import java.util.List;
import java.util.Map;
import blackjack.Participant;

public interface CardGameParticipant {
        void playTurn(String participant, Map.Entry<String, Participant.ParticipantState> participantEntry, Map<String, List<Integer>> Cards);

        boolean shouldContinue();
}
