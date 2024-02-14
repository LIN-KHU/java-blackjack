package blackjack;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class CardGenerator {

    private String[][] cardArray = new String[4][12];

    public CardGenerator() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                String[] cardShapeArray = {"하트", "클로버", "다이아", "스페이드"};
                String[] cardCountArray = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};

                cardArray[i][j] = cardCountArray[j] + cardShapeArray[i];
            }
        }
    }

    public HashMap<String, Integer> getCard() {

        HashMap<String, Integer> cardMap = new HashMap<>();

        while(true){
            int i = Randoms.pickNumberInRange(0, 3);
            int j = Randoms.pickNumberInRange(0, 11);

            if(cardArray[i][j] != null){
                /**
                 * 1. j == 0 인 경우(A) 1혹은 11 선택
                 * 2. j == 9,10,11 인 경우(J,Q,K) 10
                 * */

                cardMap.put(cardArray[i][j], getCardNumber(j));

                cardArray[i][j] = null;
                break;
            }
        }

        return cardMap;
    }

    private int getCardNumber(int index){
        if(index == 9 || index == 10 || index == 11){
            return 10;
        }
        return index + 1;
    }
}
