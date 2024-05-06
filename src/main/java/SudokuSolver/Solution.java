package SudokuSolver;

import java.util.*;

public class Solution {

    private record Coordinate(int i, int j) {};
    public void solveSudoku(char[][] board) {
        var blocks = createCoordinatesForBlock();

        while (hasEmptyCell(board)) {
            for (var coordinates: blocks) {
                var candidates = initializeCandidates();
                for (var coordinate: coordinates) {
                    findsCandidates(coordinate, candidates);
                }
                update(board, candidates);
            }
        }
    }

    private void update(char[][] board, Map<String, List<Coordinate>> candidates) {
        // TODO
        board[0][0] = '1';
        board[0][3] = '1';
        board[1][3] = '1';
    }

    private void findsCandidates(Coordinate coordinate, Map<String, List<Coordinate>> candidates) {
        // TODO
    }

    public boolean hasEmptyCell(char[][] board) {
        for (var row: board) {
            for (var cell: row) {
                if (".".equals(String.valueOf(cell))) {
                    return true;
                }

            }
        }
        return false;
    }

    public List<String> getRow(char[][] board, int i) {
        var row = board[i];
        return Arrays.asList(row).stream().map(c -> String.valueOf(c)).toList();
    }

    public List<String> getColumn(char[][] board, int j) {

        var column = new ArrayList<String>();
        for (var row: board) {
            column.add(String.valueOf(row[j]));
        }

        return column;
    }

    public List<String> getBlock(char[][] board, int i, int j) {
        var block = new ArrayList<String>();
        var iStart = Math.floorDiv(i, 3) * 3;
        var jStart = Math.floorDiv(j, 3) * 3;
        for (var _i = iStart; _i < iStart + 3; _i++) {
            for (var _j = jStart; _j < jStart + 3; _j++) {
                block.add(String.valueOf(board[_i][_j]));
            }
        }
        return block;
    }

    public List<List<Coordinate>> createCoordinatesForBlock() {
        var result = new ArrayList<List<Coordinate>>();
        for (var n = 0; n < 9; n++) {
            var coordinates = new ArrayList<Coordinate>();
            var iStart = Math.floorDiv(n, 3) * 3;
            var jStart = Math.floorMod(n, 3) * 3;
            for (int i = iStart; i < iStart + 3; i++) {
                for (int j = jStart; j < jStart + 3; j++) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
            result.add(coordinates);
        }
        return result;
    }
    private Map<String, List<Coordinate>> initializeCandidates() {
        var blockCandidate = new HashMap<String, List<Coordinate>>();
        for (int i = 1; i <= 9; i++) {
            blockCandidate.put(String.valueOf(i), new ArrayList<Coordinate>());
        }
        return blockCandidate;
    }

}
