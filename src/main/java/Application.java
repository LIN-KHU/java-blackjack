import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

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
        Map<String, Integer> cardAndValue = new HashMap<>();
        List<String> cardNumbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
        for (String cardShape : List.of("스페이드", "하트", "클로버", "다이아")) {
            for (int i = 0; i < cardNumbers.size(); i++) {
                if (i < 10) {
                    cardAndValue.put(cardNumbers.get(i) + cardShape, i + 1);
                    continue;
                }
                cardAndValue.put(cardNumbers.get(i) + cardShape, 10);
            }
        }

        Map<String, Integer> shuffledCards = new LinkedHashMap<>();
        List<Entry<String, Integer>> entries = new ArrayList<>(cardAndValue.entrySet());
        Collections.shuffle(entries);
        for (Entry<String, Integer> entry : entries) {
            shuffledCards.put(entry.getKey(), entry.getValue());
        }

        // 카드 나눠주기
        // <--- 3. 유저와 딜러에게 카드를 주는 책임 --->
        List<String> cardNames = new ArrayList<>(shuffledCards.keySet());
        LinkedHashMap<String, Integer> dealerCard = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> dealerNameAndCard = new LinkedHashMap<>();

        distributeCard(shuffledCards, cardNames, dealerCard);
        dealerNameAndCard.put(dealerName, dealerCard);

        Map<String, Map<String, Integer>> userNameAndCard = new LinkedHashMap<>();
        for (String user : users) {
            LinkedHashMap<String, Integer> userCard = new LinkedHashMap<>();
            distributeCard(shuffledCards, cardNames, userCard);
            distributeCard(shuffledCards, cardNames, userCard);
            userNameAndCard.put(user, userCard);
        }

        System.out.println(String.format("%s와 %s에게 2장을 나누었습니다", dealerName, String.join(", ", users)));
        System.out.println(String.format("%s: %s", dealerName, String.join(",", dealerCard.keySet())));

        for (String user : users) {
            System.out.println(String.format("%s: %s", user, String.join(",", userNameAndCard.get(user).keySet())));
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
            Map<String, Integer> userCards = userNameAndCard.get(user);
            while ("y".equals(newCardRequired)) {
                distributeCard(shuffledCards, cardNames, userCards);
                Integer userCardValue = calculateScore(userCards);
                System.out.println(String.format("%s: %s", user, String.join(",", userNameAndCard.get(user).keySet())));
                if (userCardValue > 21) {
                    break;
                }
                System.out.println(String.format("%s는 한장의 카드를 더 받겠습니까?(에는 y, 아니요는 n)", user));
                newCardRequired = scanner.nextLine();
            }
        }

        // 딜러 카드 추가로 받기
        // <--- 5. 딜러에게 알맞는 카드를 주는 행위 --->
        int dealerScore = calculateWithBonus(dealerCard);
        while (dealerScore <= 16) {
            System.out.println();
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
            distributeCard(shuffledCards, cardNames, dealerCard);
            dealerScore = calculateScore(dealerCard);

            Integer dealerScoreWithBonus = calculateWithBonus(dealerCard);
            if (dealerScoreWithBonus <= 21 && dealerScoreWithBonus >= 16) {
                dealerScore = dealerScoreWithBonus;
            }
            System.out.println(String.format("%s: %s", dealerName, String.join(",", dealerCard.keySet())));
        }

        // 최중 카드 출력
        // <--- 6. 유저에게 화면을 출력하는 책임 --->
        System.out.println(
            String.format("%s 카드: %s = 결과: %d", dealerName, String.join(", ", dealerCard.keySet()),
                calculateWithBonus(dealerCard)));

        for (String user : users) {
            Map<String, Integer> userCards = userNameAndCard.get(user);
            System.out.println(
                String.format("%s 카드: %s = 결과: %d", user, String.join(", ", userCards.keySet()),
                    calculateWithBonus(userCards)));
        }

        // 최종 승패 출력
        // <--- 7. 승, 패를 판단하는 책임 --->
        int finalDealerCardSum = calculateWithBonus(dealerNameAndCard.get(dealerName));
        if (finalDealerCardSum > 21) {
            finalDealerCardSum = 0;
        }

        Map<String, Integer> dealerResult = new HashMap<>();
        Map<String, String> userResult = new HashMap<>();
        for (String user : users) {
            Map<String, Integer> finalUserCard = userNameAndCard.get(user);
            int finalUserCardSum = calculateWithBonus(finalUserCard);
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

    // <--- 8. 보너스 점수를 고려하여 카드들의 합을 계산하는 로직 --->
    private static int calculateWithBonus(Map<String, Integer> cards) {
        Integer originScore = calculateScore(cards);
        boolean hasAce = cards.keySet().stream()
            .anyMatch(cardName -> cardName.contains("A"));
        int aceBonusScore = 10;
        int scoreWithBonus = originScore + aceBonusScore;
        if (hasAce && scoreWithBonus <= 21) {
            return scoreWithBonus;
        }
        return originScore;
    }

    // <--- 9. 보너스 점수 없이 카드 그대로의 합을 계산하는 로직 --->
    private static Integer calculateScore(Map<String, Integer> userCards) {
        return userCards.values().stream()
            .reduce(Integer::sum)
            .orElseThrow(() -> new IllegalArgumentException("빈 카드는 계산할 수 없습니다."));
    }

    // <--- 3.1 대상에게 실질적으로 카드를 주는 로직 --->
    private static Map<String, Integer> distributeCard(Map<String, Integer> shuffledCards,
                                                       List<String> cardNames,
                                                       Map<String, Integer> cards) {
        String cardName = cardNames.remove(0);
        Integer cardValue = shuffledCards.remove(cardName);
        cards.put(cardName, cardValue);
        return cards;
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
