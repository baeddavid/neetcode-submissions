class Solution {
    public void solve(char[][] board) {
        /*
        Is this not just multisourced bfs?
        We iterate through the matrix add every 0 as a source for bfs

        actually is this even bfs bfs doesnt get us shit

        we can dfs from the 0's and build it upwards
        our answer for if a 0 is enclosed is dependant on its children
        we dfs marking 0's as visited say with '#'
        when we reach the case where we cannot go up/left/down/right because no adjacent
        cells are '0' then that means all prev visited cells are now enclosed
        */

        if(board == null || board.length == 0) { return; }
        int rows = board.length, cols = board[0].length;

        for(int r = 0; r < rows; r++) {
            dfs(board, r, 0);
            dfs(board, r, cols - 1);
        }

        for(int c = 0; c < cols; c++) {
            dfs(board, 0, c);
            dfs(board, rows - 1, c);
        }

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(board[r][c] == 'O')
                    board[r][c] = 'X';
                else if(board[r][c] == '#')
                    board[r][c] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') 
            return;
        board[r][c] = '#';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
