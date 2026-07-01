class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        Uhh isn't this just two sum but the input is sorted and it's one indexed or am i oversimplifying


        */

        int left = 0, right = nums.length - 1;
        while(left < right) {
            if(nums[left] + nums[right] > target) {
                right--;
            } else if(nums[left] + nums[right] == target){
                return new int[] { left + 1, right + 1 };
            } else {
                left++;
            }
        }
        return new int[] { -1, -1 };
    }
}
