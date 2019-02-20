package pl.tomaszziemba.sudoku;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class SudokuElement {
    public static final int EMPTY = -1;

    private int value;
    private List<Integer> possibleValues = new ArrayList<>();

    public SudokuElement(int value) {
        this.value = value;
        for(int i = 1; i<10; i++){
            possibleValues.add(i);
        }

    }
    public boolean isEmpty(){
        return value == EMPTY;
    }
}
