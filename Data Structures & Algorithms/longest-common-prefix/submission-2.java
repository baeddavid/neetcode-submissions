class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
        Input: strs = ["dance","dag","danger","damage"]
        Output: "da" 

        isnt this just grab first char from first word
        d
        then start comparing against other strings?
        if invalid or end of string reached then return sb.tostring 
        */        

        if(strs == null || strs.length == 0) {
            return "";
        }

        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}