package blackjack;

import java.util.*;

public class Participant {
    public static class ParticipantState {
        private int sum;
        private List<String> cardlist;
        private String name;
        private List<String> WinOrLoss = new ArrayList<>();

        public ParticipantState() {
            this.sum = 0;
            this.cardlist = new ArrayList<>();
            this.name = "";
        }

        public int printsum() {
            return this.sum;
        }

        public List<String> printcardlist() {
            return this.cardlist;
        }

        public String printname() {
            return this.name;
        }

        public String printwinorloss() {
            return this.WinOrLoss.get(0);
        }

        public int getSum(Map<String, List<Integer>> Cards) {

            OperationWithCard.CardOperation sumOperation = shuffledCard -> {
                int value = shuffledCard.getValue();
                this.sum += value;
            };

            OperationWithCard.performCardOperation(Cards, sumOperation);

            return this.sum;
        }

        public String getName(String participant) {
            this.name = participant;
            return this.name;
        }


        public void WinOrLoss(int winorloss) {

            if (winorloss == 0) {
                this.WinOrLoss.add("승");
            }
            if (winorloss == 1) {
                this.WinOrLoss.add("패");
            }
        }

        public void updateSumAndNameList(int value, String cardNames) {
            this.sum += value;
            this.cardlist.add(cardNames);
        }
    }


}
