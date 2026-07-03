class Solution {
    public int islandPerimeter(int[][] grid) {
        /*
        Isn't this just we iterate through the grid find a cell of 1
        then we dfs from it for all 1's

        at ever 1 value cell the perimeter is 4 - number of adjacent 1's to it 
        */

        int rows = grid.length;
        int cols = grid[0].length;

        int perimeter = 0;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1) {
                    perimeter += 4;
                    if(r > 0 && grid[r - 1][c] == 1) perimeter -= 2;
                    if(c > 0 && grid[r][c - 1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }
}