package romanToInt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "I,1",
            "II,2",
            "V,5",
            "X,10",
            "XX,20",
            "L,50",
            "C,100",
            "CC,200",
            "D,500",
            "M,1000",
    })
    public void ローマ数字を渡すと数字に変換される(String s, int expected){
        var solution = new Solution();
        var result = solution.romanToInt(s);
        assertEquals(expected, result);
    }

}