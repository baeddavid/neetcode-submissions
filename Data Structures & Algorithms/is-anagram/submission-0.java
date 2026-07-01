class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        for(int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), -1, Integer::sum);
            if(map.get(t.charAt(i)) < 0) {
                return false;
            } else if(map.get(t.charAt(i)) == 0) {
                map.remove(t.charAt(i)); 
            }
        }
        return map.size() == 0;
    }
}
