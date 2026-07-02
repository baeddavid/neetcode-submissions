class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), answer);
        return answer;
    }

    private void backtrack(int n, int open, int close, StringBuilder candidate, List<String> answer) {
        if(candidate.length() == (n * 2)) { answer.add(candidate.toString()); return;}

        if(open < n) {
            candidate.append("(");
            backtrack(n, open + 1, close, candidate, answer);
            candidate.deleteCharAt(candidate.length() - 1);
        }

        if(close < open) {
            candidate.append(")");
            backtrack(n, open, close + 1, candidate, answer);
            candidate.deleteCharAt(candidate.length() - 1);
        }

    }
}
