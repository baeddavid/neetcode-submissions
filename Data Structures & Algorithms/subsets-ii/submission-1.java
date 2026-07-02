class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        Ah I see
        no duplicates allowed
        don't we just sort the array
        and if i = i - 1 we skip?
        */
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), answer);
        return answer;

    }

    private void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backtrack(nums, i + 1, list, answer);
            list.remove(list.size() - 1);
        }
    }
}
