class Solution {
    private static final String[] MAP = new String[] {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
        "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        /*
        Am i retarded
        isn't this just numbers mapped to char arrays and we make permutations?
        */
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) { return result; }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;

    }

    private void backtrack(String digits, int index, StringBuilder sb, List<String> result) {
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letters = MAP[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(digits, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
