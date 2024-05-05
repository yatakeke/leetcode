package SudokuSolver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;

import static com.google.common.truth.Truth.assertThat;

class SolutionTest {


    private char[][] board;
    private Solution solution;

    @BeforeEach
    void setUp() {
        board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solution = new Solution();
    }

    @Test
    public void 数字ごとに出現頻度を計算する() {

        HashMap<String, Integer> frequency = solution.countFrequency(board);
        assertThat(frequency.get("8")).isEqualTo(5);
        assertThat(frequency.get("9")).isEqualTo(4);
    }

    @Test
    @DisplayName("列が抜き出せる")
    public void canExtractColumn() {
        var column = solution.extractColumn(board, 0);
        assertThat(column).isEqualTo(
                Arrays.asList("5", "6", ".", "8", "4", "7", ".", ".", ".")
        );
    }

    @Test
    @DisplayName("1つ目のブロックが抜き出せる")
    public void canExtractFirstBlock() {
        var block = solution.extractBlock(board, 0);
        assertThat(block).isEqualTo(
                Arrays.asList("5","3",".","6",".",".",".","9","8")
        );
    }
    @Test
    @DisplayName("9つ目のブロックが抜き出せる")
    public void canExtractNinthBlock() {
        var block = solution.extractBlock(board, 8);
        assertThat(block).isEqualTo(
                Arrays.asList("2","8",".",".",".","5",".","7","9")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,0",
            "2,4,1",
            "8,8,8"
    })
    @DisplayName("座標からブロック番号が割り出せる")
    public void canCalculateBlockNumber(int i, int j, int expect) {
        assertThat(solution.calculateBlockNumber(i, j)).isEqualTo(expect);
    }

    @Test
    @Disabled
    @DisplayName("1行6列目が8であることが確定できる")
    public void test() {
        var answer = solution.solveSudoku(board);
        assertThat(answer[0][5]).isEqualTo("8");
    }
}