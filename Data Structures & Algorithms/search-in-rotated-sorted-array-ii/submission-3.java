class Solution {
    public boolean search(int[] nums, int target) {
        /*
        1,1,1,0,1
        1,0,1,1,1


        */

        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int med = low + (high - low) / 2;
            if(nums[med] == target) { return true; }

            if(nums[low] == nums[med] && nums[med] == nums[high]) {
                low++;
                high--;
            } else if(nums[low] <= nums[med]) {
                if(nums[low] <= target && target <= nums[med]) {
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
        return false;
    }
}