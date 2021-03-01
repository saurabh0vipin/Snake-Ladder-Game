package com.example.demo.component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Saurabh
 * @version 1.0, 28/02/21
 */
@NoArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
public class Player {
    private Long    playerId;
    private Cell    currentCell;
    private Boolean shouldSkip;
    private Boolean outOfGame; //to identify if player have already reached to final destination

    public Player(Long playerId, List<Cell> cellList) {
        this.playerId = playerId;
        this.shouldSkip = false;
        this.currentCell = cellList.get(1);
        this.outOfGame = false;
    }
}
