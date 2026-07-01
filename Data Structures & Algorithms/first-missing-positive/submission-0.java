class Solution {
    public int firstMissingPositive(int[] nums) {
        /*
        This is a cyclic sort problem
        negatives we really don't gaf about same for dupes
        our goal is to move a 0 into index 0, 1 into index 1 and so on...

        we then iterate through the fully cycle sorted array and look for the first instance where i != nums[i]
        the one that doesn't match the return value is i

        if we reach the end then it's simply i + 1

        of course we don't iterate to the end 
        we iterate as long as values are increasing 
        */

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int target = nums[i] - 1;
                int tmp = nums[target];
                nums[target] = nums[i];
                nums[i] = tmp;
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}