package blackjack;

import blackjack.Participant;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    private final List<Participant> playerList;

    public PlayerList() {
        this.playerList = new ArrayList<Participant>();
    }

    public List<Participant> getPlayerList() {
        return playerList;
    }

    public void add(Participant player) {
        playerList.add(player);
    }

    public int size() {
        return playerList.size();
    }
}
