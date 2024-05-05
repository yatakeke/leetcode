package SudokuSolver;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @Test
    public void 数字ごとに出現頻度を計算する() {
        char[][] input = {
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

        var solution = new Solution();
        HashMap<String, Integer> frequency = solution.countFrequency(input);
        assertThat(frequency.get("8")).isEqualTo(5);
    }
}