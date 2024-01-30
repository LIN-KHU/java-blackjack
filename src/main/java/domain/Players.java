package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
	private final List<Player> players;

	public Players(String names) {
		validateInputNames(names);
		List<String> playerNames =
				Arrays.stream(names.split(","))
						.collect(Collectors.toUnmodifiableList());
		players = playerNames.stream()
				.map(Player::new)
				.collect(Collectors.toUnmodifiableList());
		validateDuplicateNames(names);
	}

	private void validateInputNames(String names) {
		if (names == null || names.isEmpty()) {
			throw new IllegalArgumentException("1자 이상의 이름을 입력해주세요.");
		}
	}

	private void validateDuplicateNames(String names) {
		List<String> nameList = Arrays.asList(names.split(","));
		long distinctCount = nameList.stream().distinct().count();
		if (distinctCount != nameList.size()) {
			throw new IllegalArgumentException("중복된 이름이 있습니다.");
		}
	}

	public List<String> getPlayersNames() {
		return players.stream()
				.map(Player::getName)
				.map(Name::getName)
				.collect(Collectors.toList());
	}

	public List<Player> getPlayers() {
		return players;
	}
}
