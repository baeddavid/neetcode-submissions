class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
        This is a sliding window 
        permutation is just a freq count
        we create a freq count of string s1 
        when we encounter a character in s2 that is in the freq count we begin checking permutation candidacy

        if we encounter a character that is not in the freq count and we have not yet finished decrementing then 
        we know this is not a valid candidate and shrink the window to the current end and begin scanning from window right
        
        Oh hm we overcomplicated this
        this is a fixed window size problem
        s1.length() is the size of the window and we maintain a freq count
        two freq counts

        one for the s1 freq count
        second for the current window freq count

        just iterate to the end
        */

        int n = s1.length(), m = s2.length();
        if(n > m) return false;

        int[] need = new int[26], window = new int[26];
        for(int i = 0; i < n; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(need, window)) return true;

        for(int i = n; i < m; i++) {
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - n) - 'a']--;
            if(Arrays.equals(need, window)) return true;
        }

        return false;
    }
}
 