package SudokuSolver;

import org.junit.jupiter.api.BeforeEach;
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
    public void _1行目を抜き出せる() {
        var row = solution.getRow(input, 0);

        assertThat(row).isEqualTo(
                Arrays.asList( "5", "3", ".", "6", ".", ".", ".", "9", "8")
        );
    }

}