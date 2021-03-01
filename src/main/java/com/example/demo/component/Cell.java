package com.example.demo.component;

import com.example.demo.enums.CellEventEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Saurabh
 * @version 1.0, 28/02/21
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cell {
    private Long           val;
    private CellEventEnums event;
    private Long           to;

    public Cell(Long val, CellEventEnums event) {
        this.val = val;
        this.event = event;
    }
}
