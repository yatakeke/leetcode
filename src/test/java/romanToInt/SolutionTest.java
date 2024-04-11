package romanToInt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void Iを渡すと1を返す() {

        var s = "I";
        var solution = new Solution();
        var result = solution.romanToInt(s);
        assertEquals(1, result);
    }

    @Test
    public void IIを渡すと2を返す() {

        var s = "II";
        var solution = new Solution();
        var result = solution.romanToInt(s);
        assertEquals(2, result);
    }

    @Test
    public void Xを渡すと10を返す() {

        var s = "X";
        var solution = new Solution();
        var result = solution.romanToInt(s);
        assertEquals(10, result);
    }

    @Test
    public void XXを渡すと20を返す() {

        var s = "XX";
        var solution = new Solution();
        var result = solution.romanToInt(s);
        assertEquals(20, result);
    }
}