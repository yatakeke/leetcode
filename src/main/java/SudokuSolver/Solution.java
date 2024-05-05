package SudokuSolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public void solveSudoku(char[][] board) {
    }

    public HashMap<String, Integer> countFrequency(char[][] input) {
        var result = new HashMap<String, Integer>();
        for (var row: input) {
            for (var c: row) {
                var frequency = result.getOrDefault(String.valueOf(c), 0);
                result.put(String.valueOf(c), ++frequency);
            }
        }
        return result;
    }


    public List<String> getRow(char[][] input, Integer rowNumber) {
        var result = new ArrayList<String>();
        var offset = rowNumber * 3;
        for (var i = 0; i < 3; i++) {
            var block = input[i];
            for (var j = offset; j < offset + 3; j++) {
                result.add(String.valueOf(block[j]));
            }
        }
        return result;
    }
}