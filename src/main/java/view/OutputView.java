package view;

import domain.Dealer;
import domain.Player;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

	public static final String DISTRIBUTION_MESSAGE = "딜러와 %s에게 2장을 나누었습니다.";

	public void printDistribution(List<Player> players, Dealer dealer) {
		String playersName = printPlayersName(players);
		System.out.println(String.format(DISTRIBUTION_MESSAGE, playersName));
	}

	public void printDealerCardDeck(Dealer dealer) {
		System.out.println(String.format("딜러: %s", dealer.getCardDeck()));
	}

	public void printPlayersCardDeck(List<Player> players) {
		for (Player player : players) {
			System.out.println(String.format("%s카드: %s", player.getName(), player.getCardDeck()));
		}
	}

	public void printDealerDrawCard() {
		System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
	}

	public void printCardDeckWithScore(List<Player> players, Dealer dealer) {
		System.out.println(
				String.format("%s카드: %s - 결과: %d", dealer.getName(), dealer.getCardDeck(), dealer.getScore()));
		for (Player player : players) {
			System.out.println(String.format("%s카드: %s - 결과: %d", player.getName(), player.getCardDeck(),
					player.getScore()));
		}
	}

	public void printResult(List<Player> players, Dealer dealer) {
		System.out.println("## 최종 승패");
		System.out.println(String.format("%s: %d", dealer.getName(), dealer.getScore()));
		for (Player player : players) {
			System.out.println(String.format("%s: %d", player.getName(), player.getScore()));
		}
	}

	public String printPlayersName(final List<Player> players) {
		return players.stream()
				.map(Player::getName)
				.map(String::valueOf)
				.collect(Collectors.joining(", "));
	}
}
