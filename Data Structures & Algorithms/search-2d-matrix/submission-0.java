class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while(low <= high) {
            int med = low + (high - low) / 2;
            int val = valueAt(matrix, med, n);
            if(val == target) {
                return true;
            } else if(val > target) {
                high = med - 1;
            } else {
                low = med + 1;
            }
        }
        return false;
    }

    private int valueAt(int[][] matrix, int flatIndex, int cols) {
        int row = flatIndex / cols;
        int col = flatIndex % cols;
        return matrix[row][col];
    }
}
