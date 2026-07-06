class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        int[][] DIRS = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != '1') continue;

                count++;
                grid[r][c] = '0';              // mark on enqueue
                queue.offer(new int[]{r, c});

                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    for (int[] d : DIRS) {
                        int nr = cell[0] + d[0];
                        int nc = cell[1] + d[1];
                        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols
                            || grid[nr][nc] != '1') continue;
                        grid[nr][nc] = '0';    // mark on enqueue, not on poll
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return count;
    }
}