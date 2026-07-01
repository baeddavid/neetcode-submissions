class Solution {
    public String minWindow(String s, String t) {
        /*
        Given two strings s and t, return the shortest substring of s such that every character in t, 
        including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
        You may assume that the correct output is always unique.

        Input: s = "OUZODYXAYZV", t = "XYZ"

        Output: "YXAZ"

        We need a frequency count for string t
        x: 1
        y: 1
        z: 1

        We only care about characters where their current value in ther freq map is not 0

        1 <= s.length <= 1000
        1 <= t.length <= 1000
        s and t consist of uppercase and lowercase English letters.


        */

        int[] bucket = new int[128];
        // Build the bucket
        for(char c : t.toCharArray()) {
            bucket[c]++;
        }

        int required = t.length();
        int left = 0, minLen = Integer.MAX_VALUE, minStart = 0;

        for(int right = 0;  right < s.length(); right++) {
            char c = s.charAt(right);
            if(bucket[c] > 0) required--;
            bucket[c]--;
            while(required == 0) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char lastChar = s.charAt(left);
                bucket[lastChar]++; // give char back
                if(bucket[lastChar] > 0) {
                    required++; // we hit the floor, break the validity
                }
                left++; // slide it forward
            } 
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
