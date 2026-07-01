class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        Can't sort it since it needs to run in O(n)

        we could bucket sort it?
        loop through array once to find max value create an index as key array map
        iterate through the map updating length of max non zero values in a row 

        Space complexity is bound by the largest value in nums

        which is kinda gross

        TreeMap? In a treemap the keys are sorted so we insert all values into a treemap and iterate over
        the keyset 
        */

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) { set.add(num); }
        int longest = 0;

        for(int num : set) {
            if(!set.contains(num - 1)) {
                int length = 1;
                while(set.contains(num + length)) {
                    length++;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
