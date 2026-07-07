class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = grid[m - 1][n - 1];

        for (int c = n - 2; c >= 0; c--) {
            dp[m - 1][c] = grid[m - 1][c] + dp[m - 1][c + 1];
        }
        for (int r = m - 2; r >= 0; r--) {
            dp[r][n - 1] = grid[r][n - 1] + dp[r + 1][n - 1];
        }

        for (int r = m - 2; r >= 0; r--) {
            for (int c = n - 2; c >= 0; c--) {
                dp[r][c] = grid[r][c] + Math.min(dp[r + 1][c], dp[r][c + 1]);
            }
        }

        return dp[0][0];
    }
}