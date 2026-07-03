class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 0) {
                    queue.offer(new int[] { r, c });
                }
            }
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for(int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if(grid[nr][nc] != Integer.MAX_VALUE) continue;

                grid[nr][nc] = grid[r][c] + 1;
                queue.offer(new int[] { nr, nc });
            }
        }
    } 
}
