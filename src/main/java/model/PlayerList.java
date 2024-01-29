package model;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerList {
    private List<Player> playerList;

    public PlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    @Override
    public String toString() {
        return playerList.stream()
                .map(Player::getName)
                .collect(Collectors.joining(", "));
    }
}
