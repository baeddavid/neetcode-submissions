class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words) {
            TrieNode node = root;
            for(char c : w.toCharArray()) {
                if(node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = w;
        }

        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length)
            return;

        char ch = board[r][c];
        if(ch == '#' || node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];
        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';
        dfs(board, r + 1, c, node);
        dfs(board, r - 1, c, node);
        dfs(board, r, c + 1, node);
        dfs(board, r, c - 1, node);
        board[r][c] = ch;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
}
