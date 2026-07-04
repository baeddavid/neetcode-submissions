class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*
        Pacific is negative boundaries
        Atlantic is postive boundaries

        bfs since we need to check if we can hit negative/positive boundary errors

        this is so gross though because now we're doing bfs from every cell
        is there a smarter way for us to determine what cells we bfs from
        */

        int rows = heights.length, cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pac = new ArrayDeque<>();
        Queue<int[]> atl = new ArrayDeque<>();

        for(int r = 0; r < rows; r++) {
            pac.offer(new int[] { r, 0 });
            pacific[r][0] = true;
            atl.offer(new int[] { r, cols - 1 });
            atlantic[r][cols - 1] = true;
        }

        for(int c = 0; c < cols; c++) {
            pac.offer(new int[] { 0, c });
            pacific[0][c] = true;
            atl.offer(new int[] { rows - 1, c });
            atlantic[rows - 1][c] = true;
        }

        bfs(heights, pacific, pac);
        bfs(heights, atlantic, atl);

        List<List<Integer>> answer = new ArrayList<>();
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    answer.add(List.of(r, c));
                }
            }
        }
        return answer;
    }

    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        int[][] dirs = {
            { 1, 0 },
            { -1, 0},
            { 0, 1 },
            { 0, -1 }
        };

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for(int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if(nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length)
                    continue;
                if(visited[nr][nc]) 
                    continue;
                if(heights[nr][nc] < heights[r][c])
                    continue;
                visited[nr][nc] = true;
                queue.offer(new int[] { nr, nc });
            }
        }
    }
}
