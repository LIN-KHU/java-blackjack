package participant;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    private List<Player> playerList;

    public PlayerList(List<String> playerNameList) {
        List<String> nameList = hasDuplicateNames(playerNameList);
        this.playerList = generatePlayerList(nameList);
    }

    private void IsNameEqualsDealer(String name) {
        if (name.equals("딜러")) {
            throw new IllegalArgumentException("딜러 이름 사용 불가");
        }
    }

    private List<String> hasDuplicateNames(List<String> playerNameList) {
        List<String> processedNameList = new ArrayList<String>();
        for (String name : playerNameList) {
            String trimmedName = name.trim();
            if (processedNameList.contains(trimmedName)) {
                throw new IllegalArgumentException("이름 중복");
            }
            processedNameList.add(trimmedName);
        }
        return processedNameList;
    }

    private List<Player> generatePlayerList(List<String> processedNameList) {
        List<Player> playerList = new ArrayList<Player>();
        for (String name : processedNameList) {
            IsNameEqualsDealer(name);
            playerList.add(new Player(new Name(name)));
        }
        return playerList;
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }

}
