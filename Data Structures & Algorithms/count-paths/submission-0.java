class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        int[] target = new int[] { m - 1, n - 1 };
        int[] start = new int[] { 0, 0 };

        // Down can only be 1
        for(int r = m - 1; r >= 0; r--) {
            grid[r][n - 1] = 1;
        }

        // Right can only be 1
        for(int c = 0; c < n; c++) {
            grid[m - 1][c] = 1;
        }

        for(int r = m - 2; r >= 0; r--) {
            for(int c = n - 2; c >= 0; c--) {
                grid[r][c] = grid[r][c + 1] + grid[r + 1][c];
            }
        }

        return grid[0][0];
    }
}
 