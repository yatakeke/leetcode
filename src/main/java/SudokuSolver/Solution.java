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

    public List<String> extractColumn(char[][] input, int rowNumber) {
        var result = new ArrayList<String>();
        for (var row: input) {
            result.add(String.valueOf(row[rowNumber]));
        }
        return result;
    }
}