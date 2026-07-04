class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;                            // one way to make 0: the empty sequence
        for (int t = 1; t <= target; t++) {   // OUTER: target (this makes it PERMUTATIONS)
            for (int num : nums) {            // INNER: try each number as the LAST one added
                if (num <= t) dp[t] += dp[t - num];   // add ways to make the remainder
            }
        }
        return dp[target];
    }
}