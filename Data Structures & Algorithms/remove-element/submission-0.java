class Solution {
    public int removeElement(int[] nums, int val) {
        int writeIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[writeIdx++] = nums[i];
            }
        }        
        return writeIdx;
    }
}