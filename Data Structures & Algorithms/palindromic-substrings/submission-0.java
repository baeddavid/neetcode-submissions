class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        // Next we now need to check for all lens starting from 2
        for(int len = 2; len <= n; len++) {
            // Start of our substring
            for(int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1; // j is the end of our substring
                // If chars at i and j match we need to check if the internal is a palindromee
                // edge case check length 2

                if(s.charAt(i) == s.charAt(j)) {
                    if(len == 2 || dp[i + 1][j - 1]) {
                        count++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return count;
    }
}
