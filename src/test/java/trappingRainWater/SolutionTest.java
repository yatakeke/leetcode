package trappingRainWater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test() {
        var solution = new Solution();
        int[] input = createInput();
        var result = solution.trap(input);
        assertEquals(9, result);
    }

    private static int[] createInput() {
        var input = new int[10];
        // [0,2,0,3,1,0,1,3,2,1]
        input[0] = 0;
        input[1] = 2;
        input[2] = 0;
        input[3] = 3;
        input[4] = 1;
        input[5] = 0;
        input[6] = 1;
        input[7] = 3;
        input[8] = 2;
        input[9] = 1;
        return input;
    }

}