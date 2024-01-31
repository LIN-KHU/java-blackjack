import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        // 유저 입력 받기
        // <--- 1. 유저의 이름을 입력 받는 책임 --->
        System.out.println("게임에 참여할 사람의 이름을 입력하세요. (쉼표 기준으로 분리)");
        Scanner scanner = new Scanner(System.in);
        String userNames = scanner.nextLine();

        // 유저 나누기
        List<String> users = List.of(userNames.split(","));
        String dealerName = "딜러";

        // 카드 생성
        // <--- 2. 랜덤한 카드를 만드는 책임 --->
        List<Card> cards = new ArrayList<>();
        List<String> cardNumbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
        for (String cardShape : List.of("스페이드", "하트", "클로버", "다이아")) {
            for (int i = 0; i < cardNumbers.size(); i++) {
                String cardName = cardNumbers.get(i) + cardShape;
                if (i < 10) {
                    cards.add(new Card(cardName, i + 1));
                    continue;
                }
                cards.add(new Card(cardName, 10));
            }
        }

        Collections.shuffle(cards);

        // 카드 나눠주기
        // <--- 3. 유저와 딜러에게 카드를 주는 책임 --->
        List<Card> dealerCard = new ArrayList<>();
        Map<String, List<Card>> dealerNameAndCard = new LinkedHashMap<>();

        distributeCard(cards, dealerCard);
        dealerNameAndCard.put(dealerName, dealerCard);

        Map<String, List<Card>> userNameAndCard = new LinkedHashMap<>();
        for (String user : users) {
            List<Card> userCard = new ArrayList<>();
            distributeCard(cards, userCard);
            distributeCard(cards, userCard);
            userNameAndCard.put(user, userCard);
        }

        System.out.println(String.format("%s와 %s에게 2장을 나누었습니다", dealerName, String.join(", ", users)));
        printCard(dealerName, dealerCard);

        for (String user : users) {
            printCard(user, userNameAndCard.get(user));
        }

        // 유저 추가 카드 받기
        // <--- 4. 유저의 의사에 따라 유저에게 카드를 주는 책임 --->
        System.out.println();

        for (String user : users) {
            System.out.println(String.format("%s는 한장의 카드를 더 받겠습니까?(에는 y, 아니요는 n)", user));
            String newCardRequired = scanner.nextLine();
            if (!"n".equals(newCardRequired) && !"y".equals(newCardRequired)) {
                throw new IllegalArgumentException("카드를 추가로 받기 위해서는 y or n 을 입력해야함");
            }
            List<Card> userCards = userNameAndCard.get(user);
            while ("y".equals(newCardRequired)) {
                distributeCard(cards, userCards);
                Hands userHands = new Hands(userCards);
                Integer userCardValue = userHands.calculateValue();
                printCard(user, userCards);
                if (userCardValue > 21) {
                    break;
                }
                System.out.println(String.format("%s는 한장의 카드를 더 받겠습니까?(에는 y, 아니요는 n)", user));
                newCardRequired = scanner.nextLine();
            }
        }

        // 딜러 카드 추가로 받기
        // <--- 5. 딜러에게 알맞는 카드를 주는 행위 --->
        Hands dealerHand = new Hands(dealerCard);
        int dealerScore = dealerHand.calculateWithBonusValue();
        while (dealerScore <= 16) {
            System.out.println();
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
            distributeCard(cards, dealerCard);
            Hands cardAddedDealerHand = new Hands(dealerCard);
            dealerScore = cardAddedDealerHand.calculateValue();
            Integer dealerScoreWithBonus = cardAddedDealerHand.calculateWithBonusValue();
            if (dealerScoreWithBonus <= 21 && dealerScoreWithBonus >= 16) {
                dealerScore = dealerScoreWithBonus;
            }
            printCard(dealerName, dealerCard);
        }

        // 최중 카드 출력
        // <--- 6. 유저에게 화면을 출력하는 책임 --->
        Hands endDealerHands = new Hands(dealerCard);
        printFinalCard(dealerName, endDealerHands);

        for (String user : users) {
            List<Card> userCard = userNameAndCard.get(user);
            printFinalCard(user, new Hands(userCard));
        }

        // 최종 승패 출력
        // <--- 7. 승, 패를 판단하는 책임 --->
        Hands hands = new Hands(dealerNameAndCard.get(dealerName));
        int finalDealerCardSum = hands.calculateWithBonusValue();
        if (finalDealerCardSum > 21) {
            finalDealerCardSum = 0;
        }

        Map<String, Integer> dealerResult = new HashMap<>();
        Map<String, String> userResult = new HashMap<>();
        for (String user : users) {
            Hands userHands = new Hands(userNameAndCard.get(user));
            int finalUserCardSum = userHands.calculateWithBonusValue();
            if (finalUserCardSum > 21) {
                finalUserCardSum = 0;
            }
            if (finalDealerCardSum > finalUserCardSum) {
                dealerResult.computeIfPresent("승", (key, value) -> value + 1);
                dealerResult.putIfAbsent("승", 1);
                userResult.put(user, "패");
            }
            if (finalDealerCardSum == finalUserCardSum) {
                dealerResult.computeIfPresent("무", (key, value) -> value + 1);
                dealerResult.putIfAbsent("무", 1);
                userResult.put(user, "무");
            }
            if (finalDealerCardSum < finalUserCardSum) {
                dealerResult.computeIfPresent("패", (key, value) -> value + 1);
                dealerResult.putIfAbsent("패", 1);
                userResult.put(user, "승");
            }
        }

        System.out.println();
        System.out.println("## 최종 승패");
        System.out.println(String.format("딜러: %d승 %d패",
            dealerResult.get("승") == null ? 0 : dealerResult.get("승"),
            dealerResult.get("패") == null ? 0 : dealerResult.get("패")));
        for (Entry<String, String> entry : userResult.entrySet()) {
            System.out.println(String.format("%s: %s", entry.getKey(), entry.getValue()));
        }
    }

    private static void printFinalCard(String name, Hands hands) {
        List<String> cardNames = hands.getCards().stream()
            .map(Card::getName)
            .collect(Collectors.toList());

        System.out.println(
            String.format("%s 카드: %s = 결과: %d", name, String.join(", ", cardNames), hands.calculateWithBonusValue()));
    }

    private static void printCard(String name, List<Card> cards) {
        List<String> cardNames = cards.stream()
            .map(card -> card.getName())
            .collect(Collectors.toList());
        System.out.println(String.format("%s: %s", name, String.join(",", cardNames)));
    }

    // <--- 3.1 대상에게 실질적으로 카드를 주는 로직 --->
    private static void distributeCard(List<Card> deck, List<Card> userCards) {
        userCards.add(deck.remove(0));
    }

    /*
    1. 유저의 이름을 입력 받는 책임
    2. 랜덤한 카드를 만드는 책임
    3. 유저와 딜러에게 카드를 배분하는 책임
        3.1 대상에게 카드를 주는 책임
    4. 유저의 의사에 따라 유저에게 카드를 주는 책임
    5. 딜러에게 알맞는 카드를 주는 책임
    6. 유저에게 화면을 출력하는 책임
    7. 승, 패를 판단하는 책임
    8. 보너스 점수를 고려하여 카드들의 합을 계산하는 로직
    9. 보너스 점수 없이 카드 그대로의 합을 계산하는 로직

    --> 요구 사항을 이런 책임 단위로 정리하는 것이 좋다.
     */
}
