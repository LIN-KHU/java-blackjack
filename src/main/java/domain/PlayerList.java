package domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private List<Player> playerList;

    public PlayerList() {
        this.playerList = new ArrayList<Player>();
    }

    public void generatePlayerList(String playerNameStr) {
        String[] playerNameList = playerNameStr.split(",");
        validateDuplicatedPlayerName(playerNameList);
        for (String playerName : playerNameList) {
            Player player = new Player(playerName.trim());
            this.playerList.add(player);
        }
    }

    private void validateDuplicatedPlayerName(String[] playerNameList) {
        List<String> processedPlayerNameList = new ArrayList<String>();
        for (String playerName : playerNameList) {
            if (processedPlayerNameList.contains(playerName.trim())) {
                throw new IllegalArgumentException("플레이어 이름 중복");
            }
            processedPlayerNameList.add(playerName.trim());
        }
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }

}
