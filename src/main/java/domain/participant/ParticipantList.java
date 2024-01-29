package domain.participant;

import java.util.ArrayList;
import java.util.List;

public class ParticipantList {

    List<Participant> participantList;
    Dealer dealer;
    PlayerList playerList;

    public ParticipantList(Dealer dealer, PlayerList playerList) {
        this.dealer = dealer;
        this.playerList = playerList;
    }

    public List<Participant> getParticipantList() {
        this.participantList = new ArrayList<Participant>();
        this.participantList.add(dealer);
        participantList.addAll(playerList.getPlayerList());
        return this.participantList;
    }

}
