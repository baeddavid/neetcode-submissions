class Solution {
    private final int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if(board[r][c] == word.charAt(0) && dfs(board, word, visited, r, c, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int index) {
        if(index == word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(visited[row][col]) return false;
        if(board[row][col] != word.charAt(index)) return false;

        visited[row][col] = true;
        for(int[] dir : dirs) {
            if(dfs(board, word, visited, row + dir[0], col + dir[1], index + 1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}