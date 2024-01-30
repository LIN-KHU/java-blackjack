package blackjack;

import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.Map;
import java.util.Collections;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Map<String, List<Integer>> Cards = CardDictionary.createCardDictionary();

        List<String> Dealer = Arrays.asList("딜러");
        List<String> participants = getInput("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)", s -> Arrays.asList(s.split(",")));
        ParticipantSize(participants); //예외 처리

        Collections.shuffle(participants);

        Map<String, CardGameSimulator.ParticipantState> participantStates = CardGameSimulator.simulateCardGame(participants, Cards);
        Map<String, CardGameSimulator.ParticipantState> dealerState = CardGameSimulator.simulateCardGame(Dealer, Cards);
        int DealerSum = 0;

        for (String participant : participants) {
            for (Map.Entry<String, CardGameSimulator.ParticipantState> entry : participantStates.entrySet()) {
                Between16And21.SumBetween16And21(participant, entry, Cards);
            }
        }


        for (Map.Entry<String, CardGameSimulator.ParticipantState> entry : dealerState.entrySet()) {
            Between16And21.DealerBetween16And21(Dealer.get(0), entry, Cards);
            DealerSum = DecideResult.DealerScore(entry);
        }

        DecideResult.CompareWithDealer(participants, DealerSum, participantStates);
    }

    private static <T> T getInput(String prompt, Function<String, T> parser) {
        T participants;

        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String userinput = scanner.nextLine();
        participants = parser.apply(userinput);
        return participants;
    }

    private static void ParticipantSize(List<String> participants) {
        if (participants.size() > 25) {
            throw new IllegalArgumentException("가능한 참가 인원을 초과하였습니다.");
        }
    }





}

