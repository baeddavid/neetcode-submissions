class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /*
        Ahh this is more like the one i thought the last one was
        we can only use an element once within a combination

        essentially the english equivalent of "does taking this number give a valid solution"
        no? remove it
        yes? keep it
        */
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> list,
        List<List<Integer>> answer) {
            if(target == 0) {
                answer.add(new ArrayList<>(list));
                return;
            }

            if(target < 0) return;

            for(int i = start; i < candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i - 1]) continue;
                list.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, list, answer);
                list.remove(list.size() - 1);
            }
        }
}
