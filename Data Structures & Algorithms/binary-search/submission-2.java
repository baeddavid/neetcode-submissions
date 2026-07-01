class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int med = low + (high - low) / 2;
            if(nums[med] == target) {
                return med;
            } else if(nums[med] > target) {
                high = med - 1;
            } else {
                low = med + 1;
            }
        }
        return -1;
    }
}
