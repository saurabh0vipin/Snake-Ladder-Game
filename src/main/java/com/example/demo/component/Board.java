package com.example.demo.component;

import com.example.demo.enums.CellEventEnums;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author Saurabh
 * @version 1.0, 28/02/21
 */
@Getter
public class Board {
    private static List<Cell> cellList;

    public Board() {
        //manually plotting board for now
        List<Cell> cellList = Arrays.asList(new Cell[101]);
        Cell cell;

        cell = new Cell(9L, CellEventEnums.LADDER, 30L);
        cellList.set(9, cell);
        cell = new Cell(21L, CellEventEnums.LADDER, 42L);
        cellList.set(21, cell);
        cell = new Cell(15L, CellEventEnums.LADDER, 58L);
        cellList.set(15, cell);
        cell = new Cell(49L, CellEventEnums.LADDER, 71L);
        cellList.set(49, cell);
        cell = new Cell(69L, CellEventEnums.LADDER, 94L);
        cellList.set(69, cell);
        cell = new Cell(55L, CellEventEnums.LADDER, 87L);
        cellList.set(55, cell);
        cell = new Cell(64L, CellEventEnums.LADDER, 99L);
        cellList.set(64, cell);

        cell = new Cell(28L, CellEventEnums.SNAKE, 6L);
        cellList.set(28, cell);
        cell = new Cell(61L, CellEventEnums.SNAKE, 4L);
        cellList.set(61, cell);
        cell = new Cell(68L, CellEventEnums.SNAKE, 36L);
        cellList.set(68, cell);
        cell = new Cell(89L, CellEventEnums.SNAKE, 50L);
        cellList.set(89, cell);
        cell = new Cell(97L, CellEventEnums.SNAKE, 32L);
        cellList.set(97, cell);
        cell = new Cell(82L, CellEventEnums.SNAKE, 57L);
        cellList.set(82, cell);

        cell = new Cell(13L, CellEventEnums.ROLL_AGAIN);
        cellList.set(13, cell);
        cell = new Cell(56L, CellEventEnums.ROLL_AGAIN);
        cellList.set(56, cell);
        cell = new Cell(86L, CellEventEnums.ROLL_AGAIN);
        cellList.set(86, cell);

        cell = new Cell(27L, CellEventEnums.SKIP_ROLL);
        cellList.set(27, cell);
        cell = new Cell(59L, CellEventEnums.SKIP_ROLL);
        cellList.set(59, cell);
        cell = new Cell(77L, CellEventEnums.SKIP_ROLL);
        cellList.set(28, cell);

        for (Long i = 1L; i < 101L; i++) {
            if (cellList.get(i.intValue()) == null) {
                cellList.set(i.intValue(), new Cell(i, CellEventEnums.NONE));
            }
        }

        this.cellList = cellList;
    }

    public List<Cell> getCellList() {
        return this.cellList;
    }
}
