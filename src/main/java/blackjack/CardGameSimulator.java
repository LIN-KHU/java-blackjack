package blackjack;

import java.util.*;


public class CardGameSimulator {

    public static class ParticipantState {
        private int sum;
        private List<String> cardlist;

        public ParticipantState() {
            this.sum = 0;
            this.cardlist = new ArrayList<>();
        }

        public int printsum() {
            return this.sum;
        }

        public List<String> printlist() {
            return this.cardlist;
        }

        public int getSum(Map<String, List<Integer>> Cards) {

            CardOperation sumOperation = shuffledCard -> {
                int value = shuffledCard.getValue();
                this.sum += value;
            };

            performCardOperation(Cards, sumOperation);

            return this.sum;
        }

        public void updateSumAndNameList(int value, String cardNames) {
            this.sum += value;
            this.cardlist.add(cardNames);
        }
    }

    public static Map<String, ParticipantState> simulateCardGame(List<String> participants, Map<String, List<Integer>> Cards) {
        Map<String, ParticipantState> participantStates = new HashMap<>();

        for(String participant : participants) {
            participantStates.put(participant, new ParticipantState());
        }

        for (String participant : participants) {
            ParticipantState participantState = participantStates.get(participant);
            performCardOperation(Cards, shuffledCard -> {
                int value = shuffledCard.getValue();
                String cardName = shuffledCard.getKey();
                participantState.updateSumAndNameList(value, cardName);
            });
        }
        return participantStates;

    }

    interface CardOperation {
        void operate(Map.Entry<String, Integer> shuffledCard);
    }

    private static void performCardOperation(Map<String, List<Integer>> Cards, CardOperation operation) {
        for(int i = 0; i < 2; i++) {
            Map.Entry<String, Integer> shuffledCard = getRandomCard(Cards);
            operation.operate(shuffledCard);
        }
    }

    public static Map.Entry<String, Integer> getRandomCard(Map<String, List<Integer>> Cards) {
        String randomCardName = getRandomCardName(Cards.keySet());

        List<Integer> cardValues = Cards.get(randomCardName);

        int cardvalue = cardValues.get(0);

        Cards.remove(randomCardName);

        return new AbstractMap.SimpleEntry<>(randomCardName, cardvalue);
    }

    public static <T> T getRandomCardName(Set<T> keySet) {
        int randomIndex = new Random().nextInt(keySet.size());
        Iterator<T> iterator = keySet.iterator();
        for(int i = 0; i< randomIndex; i++) {
            iterator.next();

            }
        return iterator.next();
        }
    }




