class Solution {
    public void solve(char[][] board) {
        /*
        Uhh the cringeness of the problem is that if we encounter a O and dfs it to see if it hits an edge
        it's fucking annoying

        ok say it doesnt hit an edge
        it's fine we move on because we mark as visited with X
        but if we hit a boundary then we have to go back and unmark them

        Even if we did a third state and marked them as A's we have no way of differentiating is this enclosed
        or not without going backwards lmfao 

        so we would dfs from a candidate find it not enclosed
        then we have to go backwards and set it to open

        that's two traversals per non enclosed region
        */

        int rows = board.length, cols = board[0].length;
        // We should only dfs from perimeter inwards and mark all connected ones as safe
        for(int r = 0; r < rows; r++) {
            // left perimeter
            if(board[r][0] == 'O') {
                dfs(board, r, 0);
            } 
        }

        for(int c = 0; c < cols; c++) {
            if(board[0][c] == 'O') {
                dfs(board, 0, c);
            }
        }

        for(int r = 0; r < rows; r++) {
            if(board[r][cols - 1] == 'O') {
                dfs(board, r, cols - 1);
            }
        }

        for(int c = 0; c < cols; c++) {
            if(board[rows - 1][c] == 'O') {
                dfs(board, rows - 1, c);
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') return;
        board[r][c] = '#';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
