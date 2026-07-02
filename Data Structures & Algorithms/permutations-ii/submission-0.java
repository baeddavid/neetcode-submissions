class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, used, new ArrayList<>(), answer);
        return answer;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> list, 
        List<List<Integer>> answer) {
            if(list.size() == nums.length) { answer.add(new ArrayList<>(list)); return; }

            for(int i = 0; i < nums.length; i++) {
                if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
                list.add(nums[i]);
                used[i] = true;
                backtrack(nums, used, list, answer);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
}