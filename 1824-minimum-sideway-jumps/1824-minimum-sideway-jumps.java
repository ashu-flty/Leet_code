class Solution {
    public int minSideJumps(int[] obstacles) {
         int[][] dp = new int[obstacles.length][3];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 1;

        for (int i = 1; i < obstacles.length; i++) {
            if (obstacles[i] != 0) {
                // Obstacle spot.
                dp[i][obstacles[i]-1] = Integer.MAX_VALUE;
            }
            if (dp[i][0] != Integer.MAX_VALUE) {
                // Min jump from dp[i-1][0] to dp[i][0].
                int jump1 = calcJumps(obstacles, i, 0, 0, dp);
                // Min jump from dp[i-1][1] to dp[i][0].
                int jump2 = calcJumps(obstacles, i, 0, 1, dp);
                // Min jump from dp[i-1][2] to dp[i][0].
                int jump3 = calcJumps(obstacles, i, 0, 2, dp);
                dp[i][0] = minOfThree(jump1, jump2, jump3);
            }
            if (dp[i][1] != Integer.MAX_VALUE) {
                // Min jump from dp[i-1][0] to dp[i][1].
                int jump1 = calcJumps(obstacles, i, 1, 0, dp);
                // Min jump from dp[i-1][1] to dp[i][1].
                int jump2 = calcJumps(obstacles, i, 1, 1, dp);
                // Min jump from dp[i-1][2] to dp[i][1].
                int jump3 = calcJumps(obstacles, i, 1, 2, dp); 
                dp[i][1] = minOfThree(jump1, jump2, jump3);
            }
            if (dp[i][2] != Integer.MAX_VALUE) {
                // Min jump from dp[i-1][0] to dp[i][2].
                int jump1 = calcJumps(obstacles, i, 2, 0, dp);
                // Min jump from dp[i-1][1] to dp[i][2].
                int jump2 = calcJumps(obstacles, i, 2, 1, dp);
                // Min jump from dp[i-1][2] to dp[i][2].
                int jump3 = calcJumps(obstacles, i, 2, 2, dp);      
                dp[i][2] = minOfThree(jump1, jump2, jump3);
            }
        }
        return minOfThree(dp[obstacles.length-1][0], dp[obstacles.length-1][1], dp[obstacles.length-1][2]);
    }

    private int minOfThree(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private int calcJumps(int[] obstacles, int targetIndex, int targetLane, int curLane, int[][] dp) {
        if (obstacles[targetIndex-1] == curLane+1) {
            return Integer.MAX_VALUE;
        }
        if (targetLane == curLane) {
            return dp[targetIndex-1][curLane];
        }
        if (obstacles[targetIndex-1] != targetLane+1) {
            return dp[targetIndex-1][curLane]+1;
        }
        if (obstacles[targetIndex] != curLane+1) {
            return dp[targetIndex-1][curLane] + 1;
        }
        return dp[targetIndex-1][curLane] + 2;
    }
}