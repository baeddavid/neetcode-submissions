class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                if(i < map.get(complement)) {
                    return new int[] { i, map.get(complement) };
                } else {
                    return new int[] { map.get(complement), i };
                }
            } 
            map.put(nums[i], i);
        }        
        return new int[] { -1, -1 };
    }
}
