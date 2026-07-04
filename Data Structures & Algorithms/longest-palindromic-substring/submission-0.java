class Solution {
    public String longestPalindrome(String s) {
        /*
        two cases of palindromes
        even count odd count
        odd count has single unique letter at center
        even has two matching as center

        if string s is a palindrome then we know that appending same char to ends of s 
        is also a palindrome

        a single char is a palindrome 

        we 
        */

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        for(int i = 0; i < n; i++) dp[i][i] = true;

        for(int len = 2; len <= n; len++) {
            for(int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    if(len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if(len > maxLen) { start = i; maxLen = len; }
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
