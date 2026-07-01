class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, result = 0;

        for(int num : nums) {
            sum += num;
            result += map.getOrDefault(sum - k, 0);
            map.merge(sum, 1, Integer::sum);
        }

        return result;
    }
}