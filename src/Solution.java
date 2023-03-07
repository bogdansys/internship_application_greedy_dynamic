import java.util.Arrays;

public class Solution {

    /**
     * In this implementation, we first create an array of topic indices, and then sort this array by number of questions in descending order using a lambda expression that compares the questions array elements.
     * We then study each topic in order of decreasing number of questions, until we run out of time or have studied all the topics.
     * If we have enough time to study a whole topic, we do so and add all its questions to our total. Otherwise, we skip the topic and move on to the next one.
     */
    // Greedy solution version
    public static int greedySolution(int n, int m, int[] t, int[] k) {
        // Create an array of topic indices
        Integer[] indices = new Integer[m];
        for (int i = 0; i < m; i++) {
            indices[i] = i;
        }

        // Sort the indices array by efficiency (descending order)
        Arrays.sort(indices, (i, j) -> Double.compare((double) k[j] / t[j], (double) k[i] / t[i]));

        // Study topics in order of decreasing efficiency, until we run out of time
        int questionsStudied = 0;
        for (int i : indices) {
            int timeNeeded = t[i];
            if (timeNeeded <= n) {
                questionsStudied += k[i];
                n -= timeNeeded;
            } else {
                questionsStudied += (int) ((double) n / t[i] * k[i]);
                break;
            }
        }
        return questionsStudied;
    }

    // Dynamic programming version
    public static int dynamicSolution(int n, int m, int[] t, int[] k) {
        // Create a 2D dynamic programming array
        int[][] dp = new int[m + 1][n + 1];

        // Fill in the dynamic programming array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If we don't have enough time to study the current topic, skip it
                if (t[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Choose between studying the current topic and not studying it
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - t[i - 1]] + k[i - 1]);
                }
            }
        }

        // Return the maximum number of questions that can be studied within n hours
        return dp[m][n];
    }

    /**
     * The dynamic programming implementation of the problem uses a 2D array dp, where dp[i][j] represents the maximum number of questions that can be
     * answered by studying topics 1 to i within j hours. We fill in this array using nested loops that iterate over the topics and study times.
     * In each iteration, we check whether we have enough time to study the current topic. If not, we skip the topic and set the maximum number of
     * questions to the maximum number of questions that can be answered by studying topics 1 to i-1 within j hours. If we do have enough time, we choose
     * between two options: not studying the current topic and taking the maximum number of questions that can be answered by studying topics 1 to i-1 within j
     * hours, or studying the current topic and taking the maximum number of questions that can be answered by studying topics 1 to i-1 within j-t[i-1] hours,
     * plus the number of questions that can be answered by studying the current topic.
     * At the end, we return the maximum number of questions that can be answered by studying topics 1 to m within n hours, which is stored in dp[m][n]. This approach takes advantage of the overlapping subproblems
     * property of dynamic programming and allows us to avoid redundant calculations by storing and reusing intermediate results. The time complexity of this
     * implementation is O(mn), where m is the number of topics and n is the available study time.
     */

}
