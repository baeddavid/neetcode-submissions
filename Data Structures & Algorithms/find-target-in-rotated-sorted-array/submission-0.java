class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int med = low + (high - low) / 2;
            if(nums[med] == target) return med;

            // Left half is sorted
            if(nums[low] <= nums[med]) {
                // If the target is in the left side 
                if(nums[low] <= target && target < nums[med]) {
                    high = med - 1;
                } else {
                    low = med + 1;
                }
            } else {
                if(nums[med] < target && target <= nums[high]) {
                    low = med + 1;
                } else {
                    high = med - 1;
                }
            }
        }
        return -1;
    }
}
