class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1, curr = nums[i];
            while(left < right) {
                if(curr + nums[left] + nums[right] > 0) {
                    right--;
                } else if(curr + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(curr, nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
