class Solution {
    public void sortColors(int[] nums) {
        /*
         * 0 represents red
         * 1 represents white
         * 2 represents blue
         * 
         * sort array in place such that element of the same color are grouped together and arranged in the order: 0, 1, 2
         * 
         * Dutch flag problem
         * 
         * This is a 3 pointer no?
         * left mid and right?
         * 
         * left and mid start together but mid is the scanner
         * 
         * left is 0 writeIdx
         * 2 is blue writeIdx
         */

        int left = 0, mid = 0, right = nums.length - 1;
        while(mid <= right) {
            if(nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;
                left++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--; 
            }
        }
    }
}