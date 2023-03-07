import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testSolution1() {
        int n = 10;
        int m = 4;
        int[] t = {2, 3, 4, 5};
        int[] k = {5, 8, 3, 6};
        int expectedOutput = 19;
        int output = Solution.greedySolution(n, m, t, k);
        assertEquals(expectedOutput, output);
        assertEquals(expectedOutput, Solution.dynamicSolution(n, m, t, k));
    }

    @Test
    public void testSolution2() {
        int n = 3;
        int m = 2;
        int[] t = {1, 2};
        int[] k = {4, 5};
        int expectedOutput = 9;
        int output = Solution.greedySolution(n, m, t, k);
        assertEquals(expectedOutput, output);
        assertEquals(expectedOutput, Solution.dynamicSolution(n, m, t, k));
    }

    @Test
    public void testSolution3() {
        int n = 6;
        int m = 3;
        int[] t = {3, 2, 1};
        int[] k = {3, 2, 1};
        int expectedOutput = 6;
        int output = Solution.greedySolution(n, m, t, k);
        assertEquals(expectedOutput, output);
        assertEquals(expectedOutput, Solution.dynamicSolution(n, m, t, k));
    }

    @Test
    public void testSolution4() {
        int n = 5;
        int m = 1;
        int[] t = {4};
        int[] k = {1};
        int expectedOutput = 1;
        int output = Solution.greedySolution(n, m, t, k);
        assertEquals(expectedOutput, output);
        assertEquals(expectedOutput, Solution.dynamicSolution(n, m, t, k));
    }
}