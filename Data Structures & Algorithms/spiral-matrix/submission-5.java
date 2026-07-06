class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if (matrix.length == 0 || matrix[0].length == 0) return res;

    int top = 0, bottom = matrix.length - 1;
    int left = 0, right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {
        for (int c = left; c <= right; c++) res.add(matrix[top][c]);   // →
        top++;
        for (int r = top; r <= bottom; r++) res.add(matrix[r][right]); // ↓
        right--;

        if (top <= bottom) {                                          // guard
            for (int c = right; c >= left; c--) res.add(matrix[bottom][c]); // ←
            bottom--;
        }
        if (left <= right) {                                          // guard
            for (int r = bottom; r >= top; r--) res.add(matrix[r][left]);   // ↑
            left++;
        }
    }
    return res;
}
}
