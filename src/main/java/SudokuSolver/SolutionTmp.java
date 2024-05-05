package SudokuSolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// MEMO: やり直すために書き直し
class SolutionTmp {
    public char[][] solveSudoku(char[][] board) {

        // 方針: ブロックごとにループした後に各座標で行と列をみて候補を絞っていく
        for (int i = 0; i < 9; i++) {
            var block = extractBlock(board, i);
            var candidates = initializeCandidates();
            for (var element: block) {
                if (!element.equals(".")) {
                    candidates.get(element).add(new Point(1,1));
                    continue;
                }
            }
        }
        return null;
    }

    private static Map<String, List<Point>> initializeCandidates() {
        var blockCandidate = new HashMap<String, List<Point>>();
        blockCandidate.put("1", new ArrayList<Point>());
        blockCandidate.put("2", new ArrayList<Point>());
        blockCandidate.put("3", new ArrayList<Point>());
        blockCandidate.put("4", new ArrayList<Point>());
        blockCandidate.put("5", new ArrayList<Point>());
        blockCandidate.put("6", new ArrayList<Point>());
        blockCandidate.put("7", new ArrayList<Point>());
        blockCandidate.put("8", new ArrayList<Point>());
        blockCandidate.put("9", new ArrayList<Point>());
        return blockCandidate;
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

    record Point(int i, int j) {
    }
}