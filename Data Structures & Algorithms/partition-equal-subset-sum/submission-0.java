class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;          // odd total can't split into two equal halves

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;                            // sum 0 is always achievable (take nothing)

        for (int num : nums) {                   // consider each number once (0/1 knapsack)
            for (int t = target; t >= num; t--) {   // sweep HIGH TO LOW — this enforces "use once"
                dp[t] = dp[t] || dp[t - num];    // skip num (dp[t]) OR take num (dp[t-num])
            }
        }
        return dp[target];                       // can we hit exactly sum/2?
    }
}