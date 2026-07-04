class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        Isn't the intuition that we track min seen so far 
        and use that to compare the max seen so far against previous computerd versions?


        */

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int best = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}
