class Solution {
    public List<Integer> majorityElement(int[] nums) {
        /*
        We need to find all elements that appear n/3 times
        freq count makese this trivial 

        we are aksed to solve it in O(1) space and linear which nukes that idea
        no hashmap 
        no index as value map 

        linear means we can't sort it
        we essentially take the array as is

        we can't count via freq maps because that violates the O(1) space

        */

        HashMap<Integer, Integer> freqCount = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int num : nums) {
            freqCount.merge(num, 1, Integer::sum);
        }

        for(int num : freqCount.keySet()) {
            if(freqCount.get(num) > (nums.length / 3)) {
                ans.add(num);
            }
        }
        return ans;
    }
}   