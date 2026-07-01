class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        Classic sliding window
        we grow the window greedily until we encounter a duplicate character
        then we must shrink the window until the failed constraint (no duplicates) is removed
        */

        int left = 0, right = 0, max = 0;
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();

        while(right < s.length()) {
            if(!set.contains(chars[right])) {
                set.add(chars[right]);
                right++;
            } else {
                max = Math.max(max, set.size());
                while(set.contains(chars[right])) {
                    set.remove(chars[left]);
                    left++;
                }
            }
        }
        max = Math.max(max, set.size());
        return max;
    }
}
