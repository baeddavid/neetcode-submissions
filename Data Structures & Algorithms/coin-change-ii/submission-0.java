class Solution {
    public int change(int amount, int[] coins) {
        /*
        Knapsack problem 
        unbound not 0/1 

        amount = 4
        count = [1,2,3]

        we go by coin amount i think no?
        like we see what is the number of different ways we can make 1,2..,n

        so it's like
        dp[i] = dp[amount - coin[j]] + 1
        this gives us at the amount minus the current coin take the previously computed
        ways to make amount - count and add one

        wait
        it's not one
        wait no it is one because that coin + amount - coin is what equals it 
        */

        int[] dp = new int[amount + 1];
        dp[0] = 1; // only 1 way to make 0

        for(int coin : coins) {
            for(int a = 1; a <= amount; a++) {
                if(coin <= a)
                    dp[a] += dp[a - coin];
            }
        }
        return dp[amount];
    }
}
