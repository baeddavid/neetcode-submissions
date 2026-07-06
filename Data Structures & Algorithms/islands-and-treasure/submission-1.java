class Solution {
    public void islandsAndTreasure(int[][] grid) {
        /*
        This is probably easier if we start from the chests
        so we start with 0's

        the thing is we need to set INF tiles to the value closest to the 0's

        so that would mean we cant just do bfs from every 0 as that overwrites cells
        what we need to do is bfs from every 0 at the same time

        so peel away one ring around each treasure chest per iteration
        we only write to a cell if it's value is INF

        so we essentially can only travel to a cell if it's valid
        it's validity is any cell where it's value is INF because we don't want to overwrite
        we just essentially find the cell where we came from and add + 1 to it 
        */

        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 0) {
                    queue.offer(new int[] {r,c});
                }
            }
        }

        int[][] DIRS = new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            
            for(int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != Integer.MAX_VALUE) continue;
                grid[nr][nc] = grid[r][c] + 1;
                queue.offer(new int[] { nr, nc });
            }
        }
    }
}
