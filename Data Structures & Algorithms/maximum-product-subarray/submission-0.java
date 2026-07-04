class Solution {
    public int maxProduct(int[] nums) {
        /*
        This problem is trivial when all the values are positive becauese the answer is 
        just the whole array

        the real difficulty comes from negatives

        When we have a running product that is positive and we encounter a negative it is 
        not a binary decision at the time of encountering it if we take it or we don't

        we take it if we know there is another negative after it 
        we do not take it if there is not another negative

        if we track the largest min/negative value laong the positive we can do this
        */

        List<int[]> dp = new ArrayList<>();
        dp.add(new int[]{ nums[0], nums[0] });   // index 0: max and min both nums[0]
        int answer = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int prevMax = dp.get(i - 1)[0];
            int prevMin = dp.get(i - 1)[1];
            int n = nums[i];

            int curMax = Math.max(n, Math.max(prevMax * n, prevMin * n));
            int curMin = Math.min(n, Math.min(prevMax * n, prevMin * n));

            dp.add(new int[] { curMax, curMin });
            answer = Math.max(curMax, answer);
        }
        return answer;
    }
}
