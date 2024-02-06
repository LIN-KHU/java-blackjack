package controller;

import constants.Constant;
import constants.Result;
import domain.BlackJack;
import domain.DealerWinChecker;
import participant.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameManager {

    private InputView inputView;
    private OutputView outputView;
    private BlackJack blackJack;

    public GameManager() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void gameStart() {
        List<Player> playerList = getPlayerList();

        List<Participant> participants = new ArrayList<Participant>();
        Dealer dealer = new Dealer();
        participants.add(dealer);
        for (Player player : playerList) {
            participants.add((Participant) player);
        }

        List<String> playerNameList = new ArrayList<String>();
        for (Player player : playerList) {
            playerNameList.add(player.getName());
        }
        outputView.printInitialCardDistributionMessage(playerNameList);

        this.blackJack = new BlackJack(participants);
        for (Participant participant : participants) {
            outputView.printParticipantCardList(participant);
        }

        outputView.printEmptyLine();

        for (Participant participant : participants) {
            if (participant instanceof Player) {
                askForAdditionCard(participant);
            }
        }

        outputView.printEmptyLine();

        if (blackJack.isDealerAboveThreshold(dealer)) {
            outputView.printDealerGetOneMoreCard();
        }

        for (Participant participant : participants) {
            int score = participant.getScore();
            outputView.printScore(participant, score);
        }

        outputView.printEmptyLine();

        DealerWinChecker dealerWinChecker = new DealerWinChecker(dealer);
        HashMap<String, String> playerResult = new HashMap<>();
        for (Participant participant : participants) {
            if (participant instanceof Player) {
                Result result = dealerWinChecker.checkDealerWin((Player) participant);
                playerResult.put(participant.getName(), result.getValue());
            }
        }

        List<Integer> dealerResult = new ArrayList<Integer>();
        dealerResult.add(dealerWinChecker.getWinNum());
        dealerResult.add(dealerWinChecker.getLoseNum());
        dealerResult.add(dealerWinChecker.getPushNum());

        outputView.printFinalResult(dealerResult, playerResult);

    }

    private List<Player> getPlayerList() {
        try {
            outputView.printInputPlayerNameMessage();
            List<String> nameList = inputView.inputPlayerName();
            PlayerList playerList = new PlayerList(nameList);
            return playerList.getPlayerList();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerList();
        }
    }

    private void askForAdditionCard(Participant participant) {
        String name = participant.getName();
        try {
            outputView.printAskForAdditionalCard(name);
            String answer = inputView.askForAdditionalCard();
            if (answer.equals(Constant.YES)) {
                this.blackJack.distributeCard(participant);
                outputView.printParticipantCardList(participant);
                askForAdditionCard(participant);
            }
            if (answer.equals(Constant.NO)) {
                outputView.printParticipantCardList(participant);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            askForAdditionCard(participant);
        }
    }
}
