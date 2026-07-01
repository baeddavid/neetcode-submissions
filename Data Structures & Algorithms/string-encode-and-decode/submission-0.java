class Solution {

    /*
    Am I stupid there's not much input on how to encode this are they telling us just to pick our own hashing algorithm?
    I mean we could literally just do a bound 256 ascii hashing with a delimiter between characters to ensure that 11 for example is read as 1 1 not 11

    Decoding is just get substring until delimiter lookup in the table and then decode it assembling string char  by char
    */

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str); 
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            StringBuilder sb = new StringBuilder();
            j++;

            while(len > 0) {
                sb.append(str.charAt(j));
                j++;
                len--;
            } 
            result.add(sb.toString());
            i = j; 
        }
        return result;
    }
}
