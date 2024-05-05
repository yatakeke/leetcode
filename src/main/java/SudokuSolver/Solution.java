package SudokuSolver;

import java.util.HashMap;

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
}