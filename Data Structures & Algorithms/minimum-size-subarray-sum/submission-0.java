class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        /*
        We grow the window while the running sum of the window < target
        we shrink the window once the running sum is >= target

        */

        int left = 0, right = 0;
        int windowSum = 0, minLength = Integer.MAX_VALUE;

        while(right < nums.length) {
            windowSum += nums[right];
            while(windowSum >= target) {
                minLength = Math.min(minLength, (right - left) + 1);
                windowSum -= nums[left];
                left++;
            }
            right++;
        }

        if(minLength == Integer.MAX_VALUE) { return 0; }

        return minLength;
    }
}