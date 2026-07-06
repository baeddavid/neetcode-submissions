class Solution {
    public int orangesRotting(int[][] grid) {
        /*
        This is also a multisourced bfs 

        since all fruits rot at the same time we go frontier by frontier from every rotted fruit
        we go until we have traverse the whole grid and then iterate the grid checking for any 1's left

        valid move is iff the cell value is 1
        */

        Queue<int[]> queue = new ArrayDeque<>();
        int rows = grid.length, cols = grid[0].length;
        
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 2) {
                    queue.offer(new int[] { r, c });
                }
            }
        }

        int[][] DIRS = new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();           // snapshot BEFORE draining
            boolean rotted = false;
            for (int i = 0; i < size; i++) {   // drain exactly one level
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];
                for (int[] d : DIRS) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols
                        || grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    rotted = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
            if(rotted) count++;                         // one minute per completed level
        }

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1) return -1;
            }
        }

        return count;
    }
}
