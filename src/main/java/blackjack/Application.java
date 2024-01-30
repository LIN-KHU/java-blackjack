package blackjack;

import blackjack.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class Application {

    public static void main(String[] args) {
        Map<String, List<Integer>> Cards = CardDictionary.createCardDictionary();

        List<String> Dealer = Arrays.asList("딜러");
        List<String> participants = InputView.getInput("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)", s -> Arrays.asList(s.split(",")));
        ParticipantSize(participants); //예외 처리

        Collections.shuffle(participants);

        Map<String, Participant.ParticipantState> participantStates = BlackJackGame.simulateCardGame(participants, Cards);
        Map<String, Participant.ParticipantState> dealerState = BlackJackGame.simulateCardGame(Dealer, Cards);
        int DealerSum = 0;

        for (String participant : participants) {
            for (Map.Entry<String, Participant.ParticipantState> entry : participantStates.entrySet()) {
                entry.getValue().getName(participant);
                Between16And21.SumBetween16And21(participant, entry, Cards);
            }
        }

        for (Map.Entry<String, Participant.ParticipantState> entry : dealerState.entrySet()) {
            Between16And21.DealerBetween16And21(Dealer.get(0), entry, Cards);
            DealerSum = entry.getValue().printsum();
        }

        DecideResult.CompareWithDealer(participants, DealerSum, participantStates);
    }

    private static void ParticipantSize(List<String> participants) {
        if (participants.size() > 25) {
            throw new IllegalArgumentException("가능한 참가 인원을 초과하였습니다.");
        }
    }
}

