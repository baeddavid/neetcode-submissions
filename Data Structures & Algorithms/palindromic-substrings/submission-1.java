class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(s.charAt(i) == s.charAt(j) && (dp[i -1][j + 1] || i - j + 1 == 2)) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
