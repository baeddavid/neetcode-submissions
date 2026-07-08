class Solution {
    public String longestPalindrome(String s) {
         /*
         well palindrome is recursive in nature
         if substring i,j is a palindrome then appending character same at both ends is true

         this can be done with DP 
         one axis is i, second axis is j
         */
        
        String answer = "";
        if(s.length() == 1) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            answer = s.substring(i, i + 1);
        }

        int maxLen = 0;

        for(int i = 1; i < s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[i - 1][j + 1] && s.charAt(i) == s.charAt(j) || s.charAt(j) == s.charAt(i) && (i - j + 1) == 2) {
                    dp[i][j] = true;
                    if(i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        answer = s.substring(j, i + 1);
                    }
                }
            }
        }
        return answer;
    }
}
