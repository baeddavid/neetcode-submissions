class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for(int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < words.length - 1; i++) {
            if(!inOrder(words[i], words[i + 1], rank))
                return false; 
        }
        return true;
    }

    private boolean inOrder(String a, String b, int[] rank) {
        int n = Math.min(a.length(), b.length());
        for(int i = 0; i < n; i++) {
            char cA = a.charAt(i), cB = b.charAt(i);
            if(cA != cB) {
                return rank[cA - 'a'] < rank[cB - 'a'];
            }
        }
        return a.length() <= b.length();
    }
}