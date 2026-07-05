class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > max) return false;          // i unreachable → trapped, bail
            dp[i] = Math.max(max, nums[i] + i);
            max = dp[i];
        }
        return max >= nums.length - 1;
    }
}