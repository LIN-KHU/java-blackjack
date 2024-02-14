package blackjack.model.Participant;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    private final List<Participant> playerList;

    public PlayerList(PlayerNameList playerNameList) {
        this.playerList = new ArrayList<Participant>();
        for (String name : playerNameList.getPlayerNameList()) {
            playerList.add(new Participant(name));
        }
    }

    public List<Participant> getPlayerList() {
        return playerList;
    }
}
