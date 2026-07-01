class Solution {
    public boolean isValid(String s) {
        /*
        
        */

        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            if(isOpening(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) return false;
                char open = stack.pop();
                if(!match(open, s.charAt(i))) { return false; }
            }
        }
        return stack.size() == 0;
    }

    private boolean match(char open, char c) {
        if(open == '[' && c == ']') {
            return true;
        } else if(open == '{' && c == '}') {
            return true;
        } else if(open == '(' && c == ')') {
            return true;
        }
        return false;
    }

    private boolean isOpening(char c) {
        if(c == '[' || c =='{' || c == '(') {
            return true;
        }
        return false;
    }
}
