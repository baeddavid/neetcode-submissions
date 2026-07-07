class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        Isn't this just dp with substrings
        cram all words in the dictionary into a set for fast lookup

        then try substrings of s to j [s, j] and see if the set contains it
        if the set contains it we know that [s, j] substring is a valid word
        and if [j, n] is true then we know word break is true

        if a substring at indices (i,j) is true and the substring at (j, n) where n is the end of the string
        is in the set we know it's true

        */

        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int j = 1; j <= n; j++) {
            for(int i = 0; i < j; i++) {
                if(dp[i] && set.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
