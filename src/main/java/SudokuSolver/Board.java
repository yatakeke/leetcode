package SudokuSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
    private final ArrayList<Cell> cells;

    public Board(char[][] rawBoard) {
        this.cells = new ArrayList<Cell>();
        for (var y = 0; y < 9; y++) {
            var row = rawBoard[y];
            for (var x = 0;x < 9; x++) {
                var v = String.valueOf(row[x]);
                var b = Math.floorDiv(y, 3) * 3 + Math.floorDiv(x, 3);
                cells.add(new Cell(x, y, b, v));
            }
        }
    }

    public List<Cell> getBlock(int n) {
        var result = new ArrayList<Cell>();
        for (var c: this.cells) {
            if (c.block() == n) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Cell> getRow(int y) {
        return this.cells.stream().filter(c -> c.y() == y).toList();
    }

    public List<Cell> getColumn(int x) {
        return this.cells.stream().filter(c -> c.x() == x).toList();
    }

    public void updateBy(Map<String, List<Cell>> candidates) {
        for (var num: candidates.keySet()) {
            var c = candidates.get(num);
            if (c.size() == 1) {
                var x = c.get(0).x();
                var y = c.get(0).y();
                var b = c.get(0).block();
                var index = y * 9 + x;
                this.cells.set(index, new Cell(x, y, b, num));
            }
        }
    }

    public char[][] getAnswer() {
        char[][] result = new char[9][9];
        for (var c: cells) {
            result[c.y()][c.x()] = c.value().charAt(0);
        }
        return result;
    }

    public boolean canAnalyze() {
        return this.cells.stream().anyMatch(c -> c.value().equals("."));
    }
}
