package SudokuSolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public char[][] solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            var block = extractBlock(board, i);
        }
        return null;
    }

    public HashMap<String, Integer> countFrequency(char[][] board) {
        var result = new HashMap<String, Integer>();
        for (var row: board) {
            for (var c: row) {
                var frequency = result.getOrDefault(String.valueOf(c), 0);
                result.put(String.valueOf(c), ++frequency);
            }
        }
        return result;
    }

    public List<String> extractColumn(char[][] board, int rowNumber) {
        var result = new ArrayList<String>();
        for (var row: board) {
            result.add(String.valueOf(row[rowNumber]));
        }
        return result;
    }

    public List<String> extractBlock(char[][] board, int blockNumber) {
        var result = new ArrayList<String>();
        var offsetRow = Math.floorDiv(blockNumber, 3);
        for (var i = 3 * offsetRow; i < 3 * offsetRow + 3; i++) {
            var row = board[i];
            var offsetColumn = Math.floorMod(blockNumber, 3);
            for (var j = 3 * offsetColumn; j < 3 * offsetColumn + 3; j++) {
                result.add(String.valueOf(row[j]));
            }
        }
        return result;
    }

    public int calculateBlockNumber(int i, int j) {
        return Math.floorDiv(i, 3) * 3 + Math.floorDiv(j, 3);
    }
}