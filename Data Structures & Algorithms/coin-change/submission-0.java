class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);              // FIX 5: "infinity" sentinel (unreachable-high)
        dp[0] = 0;                                 // 0 coins make amount 0

        for (int i = 1; i <= amount; i++) {        // FIX 1: <= amount, include the target
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {               // FIX 3: coin FITS (not "exactly finishes")
                    dp[i] = Math.min(dp[i],        // FIX 4: min over all coin choices
                                     dp[i - coins[j]] + 1);   // FIX 2: i, not amount
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];   // sentinel survived → impossible → -1
    }
}