package SudokuSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public List<String> extractBlock(char[][] input, int blockNumber) {
        var result = new ArrayList<String>();
        var offsetRow = Math.floorDiv(blockNumber, 3);
        for (var i = 3 * offsetRow; i < 3 * offsetRow + 3; i++) {
            var row = input[i];
            var offsetColumn = Math.floorMod(blockNumber, 3);
            for (var j = 3 * offsetColumn; j < 3 * offsetColumn + 3; j++) {
                result.add(String.valueOf(row[j]));
            }
        }
        return result;
    }
}