class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int n : nums) total += n;

        if (Math.abs(target) > total || (target + total) % 2 != 0) return 0;
        int s = (target + total) / 2;

        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int j = s; j >= n; j--)   // downward → 0/1, each number once
                dp[j] += dp[j - n];
        return dp[s];
    }
}