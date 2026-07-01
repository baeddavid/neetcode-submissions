class Solution {
    public int characterReplacement(String s, int k) {
        /*
        Don't be baited we don't and shouldn't mutate the string
        essentially take the firt char and set it as our standard 

        then grow the window until k = -1 decrmenting for each char that doesn't equal the standard
        at k = -1 we take the size of the current window as Math.max(current size - 1, max)

        what shrinks out window?
        the next char that does not equal the current standard we compare against
        */

        int[] freq = new int[26];
        int maxFreq = 0, max = 0;
        int left = 0, right = 0;
        while(right < s.length()) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            right++;
            if((right - left) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(right - left, max);
        }
        return max;
    }
}
