package com.example.demo.controller;

import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Saurabh
 * @version 1.0, 28/02/21
 */
@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    /**
     * API used to playGame and get the result of players in their winning order. i.e last one being the looser.
     * - Accepts List of players's jersey no/id in the sequence of their turn.
     */

    @PostMapping("/play")
    public List<Long> playGameAndGetWinners(@RequestParam(value = "playerListInOrderOfPlay") List<Long> playerList) {
        return gameService.playGameAndGetWinners(playerList);
    }
}
