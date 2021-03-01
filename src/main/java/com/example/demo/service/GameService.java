package com.example.demo.service;

import com.example.demo.component.Board;
import com.example.demo.component.Cell;
import com.example.demo.component.Player;
import com.example.demo.enums.CellEventEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Saurabh
 * @version 1.0, 28/02/21
 */
@Service
@Slf4j
public class GameService {

    private static final Long       MAX_VAL   = 6L;
    private static final Long       MIN_VAL   = 1L;
    private static final List<Cell> boardList = new Board().getCellList();

    public List<Long> playGameAndGetWinners(List<Long> playerList) {
        List<Long> res = new ArrayList<>();
        //bad request
        if (playerList == null || playerList.size() < 2) {
            return res;
        }
        //we can add one more check to accept only distinct playList elements.

        List<Player> players = new ArrayList<>();
        for (Long p : playerList) {
            players.add(new Player(p, boardList));
        }

        Long rollingTurn = 0L;
        while (res.size() != playerList.size() - 1) {
            Player player = players.get(rollingTurn.intValue());
            if (player.getOutOfGame() || player.getShouldSkip()) {
                if (player.getShouldSkip())
                    player.setShouldSkip(false);
                rollingTurn++;
            } else {
                Long dieOutcome = rollDie();
                boolean nextTurn = play(player, dieOutcome, res);
                if (nextTurn) {
                    rollingTurn++;
                }
            }
            rollingTurn %= playerList.size();
        }
        res.add(getLooser(res, playerList));
        return res;
    }

    //returns true in case of next players turn
    private boolean play(Player player, Long dieOutcome, List<Long> res) {
        log.info("jersey no {} player's turn", player.getPlayerId());
        Long newPos = player.getCurrentCell().getVal() + dieOutcome;
        //if newPos is going beyond 100 then player needs to wait to get exact 100
        if (newPos > 100 || player.getCurrentCell().getVal() == MIN_VAL && dieOutcome != MAX_VAL) {
            return true;
        }

        player.setCurrentCell(boardList.get(newPos.intValue()));
        if (player.getCurrentCell().getVal() == 100) {
            //added in the winner list
            player.setOutOfGame(true);
            res.add(player.getPlayerId());
            return true;
        }

        if (player.getCurrentCell().getEvent() == CellEventEnums.ROLL_AGAIN || dieOutcome == MAX_VAL) {
            return false;
        } else if (player.getCurrentCell().getEvent() == CellEventEnums.LADDER || player.getCurrentCell().getEvent() == CellEventEnums.SNAKE) {
            Long JumpPos = player.getCurrentCell().getTo();
            player.setCurrentCell(boardList.get(JumpPos.intValue()));
        }
        return true;
    }

    private Long rollDie() {
        Random rand = new Random();
        int rand_val = rand.nextInt(MAX_VAL.intValue());

        return Long.valueOf(rand_val + 1);
    }

    private Long getLooser(List<Long> res, List<Long> playerList) {

        Long sumTot = 0L;
        int i = 0;
        for (; i < res.size(); i++) {
            sumTot -= res.get(i);
            sumTot += playerList.get(i);
        }
        sumTot += playerList.get(i);

        return sumTot;
    }

}


