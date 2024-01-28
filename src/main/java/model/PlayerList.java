package model;

import java.util.List;

public class PlayerList {
    private List<Player> playerList;

    public PlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
