class Solution {
    public void setZeroes(int[][] matrix) {
        /*
        Oh fun
        We can risk overwriting the entire array to zeros
        because there are two kinds of zeros

        original 0's
        and set 0's

        we are only setting columns and rows to set 0's when the matrix iteration finds an original 
        0

        We can do this by storing all cells in a list with original 0's and set 0's based on that

        O(1) space follow up
        hmm

        */

        List<int[]> originalZ = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(matrix[r][c] == 0) {
                    originalZ.add(new int[] {r,c});
                }
            }
        }

        for(int[] cell : originalZ) {
            mutate(matrix, cell[0], cell[1]);
        }
    }

    private void mutate(int[][] matrix, int r, int c) {
        for(int i = r; i < matrix.length; i++) {
            matrix[i][c] = 0;
        }

        for(int i = r; i >= 0; i--) {
            matrix[i][c] = 0;
        }

        for(int i = c; i < matrix[0].length; i++) {
            matrix[r][i] = 0;
        }

        for(int i = c; i >= 0; i--) {
            matrix[r][i] = 0;
        }
    } 
}
