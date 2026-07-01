class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        So two ways to solve this
        anagrams are just a freq count essentially at their core
        in the list of words let's go ahead and say we sort it by chars
        act and cat are the same then 

        this is fine but can we do better?
        we can serialize the freqcount as the string
        since these are all chars we can use an int[26]. Then when we build the key we serialize it via
        non zero values broken up with # as the delimiter since strings keyed in a map always hash 
        consistently


        */        

        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] freqCount = new int[26];
            for(int i = 0; i < str.length(); i++) {
                freqCount[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int n : freqCount) {
                sb.append(n);
                sb.append('#');
            }
            String key = sb.toString();
            map.computeIfAbsent(key, x -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
