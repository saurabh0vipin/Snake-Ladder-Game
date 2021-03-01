package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Saurabh
 * @version 1.0, 28/02/21
 */
@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    private static final Integer MAX_LENGTH = 20;
    private static final Integer MIN_LENGTH = 2;

    @InjectMocks
    private GameService gameService;

    @BeforeEach
    public void setVar() {
        // do nothing
    }

    @Nested
    class testPlayGameAndGetWinners {
        @Test
        void testPlayGameAndGetWinners_badRequestValidation() {
            List<Long> playerList = new ArrayList<>();

            List<Long> resExpected = new ArrayList<>();
            assertEquals(gameService.playGameAndGetWinners(playerList), resExpected);
            Random rand = new Random();
            int rand_val = rand.nextInt(Integer.MAX_VALUE);
            playerList.add(Long.valueOf(rand_val));

            assertEquals(gameService.playGameAndGetWinners(playerList), resExpected);
        }

        @Test
        void testPlayGameAndGetWinners_happyCase() {
            List<Long> playerList = new ArrayList<>();
            Random rand = new Random();
            int rand_val = rand.nextInt(MAX_LENGTH);
            rand_val += MIN_LENGTH;

            while (rand_val > 0) {
                playerList.add(Long.valueOf(rand.nextInt(Integer.MAX_VALUE)));
                rand_val--;
            }
            List<Long> actualRes = gameService.playGameAndGetWinners(playerList);
            assertTrue(checkIfAnyPermutaionOfInput(actualRes, playerList));
        }

        boolean checkIfAnyPermutaionOfInput(List<Long> actualRes, List<Long> playerList) {
            Collections.sort(actualRes);
            Collections.sort(playerList);
            if (actualRes.equals(playerList)) {
                return true;
            }
            return false;
        }
    }
}