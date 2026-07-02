class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<Integer>(), answer);
        return answer;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> list,
        List<List<Integer>> answer) {
            if(list.size() == nums.length) {
                answer.add(new ArrayList<>(list));
                return;
            }

            for(int i = 0; i < nums.length; i++) {
                if(used[i]) continue;
                list.add(nums[i]);
                used[i] = true;
                backtrack(nums, used, list, answer);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
}
