class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int[] cache = new int[nums.length];
        cache[0] = nums[0];
        cache[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            cache[i] = Math.max(nums[i] + cache[i - 2], cache[i - 1]);
        }

        return cache[cache.length - 1];
    }
}
