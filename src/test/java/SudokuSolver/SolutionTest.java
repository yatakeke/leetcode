package SudokuSolver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    private char[][] input;
    private Solution solution;

    @BeforeEach
    void setUp() {
        input = new char[][]{
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

        HashMap<String, Integer> frequency = solution.countFrequency(input);
        assertThat(frequency.get("8")).isEqualTo(5);
        assertThat(frequency.get("9")).isEqualTo(4);
    }

    @Test
    @DisplayName("列が抜き出せる")
    public void canExtractColumn() {
        var column = solution.extractColumn(input, 0);
        assertThat(column).isEqualTo(
                Arrays.asList("5", "6", ".", "8", "4", "7", ".", ".", ".")
        );
    }
}