package SudokuSolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public char[][] solveSudoku(char[][] b) {

        var board = new Board(b);

        while (board.canAnalyze()) {
            for (var n = 0; n < 9; n++) {
                var candidates = initializeCandidates();
                var block = board.getBlock(n);
                for (var cell: block) {
                    if (!cell.value().equals(".")) {
                        candidates.get(cell.value()).add(cell);
                        continue;
                    }

                    var row = board.getRow(cell.y());
                    var column = board.getColumn(cell.x());

                    for (var value: candidates.keySet()) {
                        if (block.stream().anyMatch(c -> c.value().equals(value))) {
                            continue;
                        }
                        if (row.stream().anyMatch(c -> c.value().equals(value))) {
                            continue;
                        }
                        if (column.stream().anyMatch(c -> c.value().equals(value))) {
                            continue;
                        }

                        candidates.get(value).add(cell);
                    }
                }
                board.updateBy(candidates);
            }
        }

        return board.getAnswer();
    }

    private Map<String, List<Cell>> initializeCandidates() {
        var blockCandidate = new HashMap<String, List<Cell>>();
        blockCandidate.put("1", new ArrayList<Cell>());
        blockCandidate.put("2", new ArrayList<Cell>());
        blockCandidate.put("3", new ArrayList<Cell>());
        blockCandidate.put("4", new ArrayList<Cell>());
        blockCandidate.put("5", new ArrayList<Cell>());
        blockCandidate.put("6", new ArrayList<Cell>());
        blockCandidate.put("7", new ArrayList<Cell>());
        blockCandidate.put("8", new ArrayList<Cell>());
        blockCandidate.put("9", new ArrayList<Cell>());
        return blockCandidate;
    }
}