class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        /*
        If we encounter a one then start dfs as long as move is valid where cell = 1
        mark as 0 after visiting 
        */

        int max = 0;
        int rows = grid.length, cols = grid[0].length;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1) {
                    max = Math.max(dfs(grid, r, c), max);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }
}
