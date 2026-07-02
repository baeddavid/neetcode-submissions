class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        /*
        This seems like a back tracking problem
        essentially we will iterate through nums and try combinations

        when we select a number we must try to select it again as we are allowed to submit
        duplicate numbers unlimited times

        so its like 

        f(num, target)
            for i -> 1 to num.length do:
                target = target - num[i]
                list.add(num[i])
                if target < 0 do:
                    return
                end

                if target == 0 do:
                    answer.add(list)
                end
                f(num, target)
                f(num, target + num[i])
        */
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void backtrack(int[] nums, int target , int start, List<Integer> list,
        List<List<Integer>> answer) {
            if(target == 0) answer.add(new ArrayList<>(list));
            if(target < 0) return;

            for(int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                backtrack(nums, target - nums[i], i, list, answer);
                list.remove(list.size() - 1);
            }
        }
}
