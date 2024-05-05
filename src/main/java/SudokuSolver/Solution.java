package SudokuSolver;

import java.util.HashMap;

class Solution {
    public void solveSudoku(char[][] board) {
    }

    public HashMap<String, Integer> countFrequency(String[][] input) {
        var result = new HashMap<String, Integer>();
        for (var row: input) {
            for (var element: row) {
                var count = result.getOrDefault(element, 0);
                result.put(element, ++count);
            }
        }
        return result;
    }
}