class Solution {
    public String decodeString(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for(char c : s.toCharArray()) {
        if(c == ']') {
            // pop chars until '[' to get the inner string
            StringBuilder inner = new StringBuilder();
            while(stack.peek() != '[') {
                inner.insert(0, stack.pop());   // prepend, since we pop in reverse
            }
            stack.pop();   // discard the '['

            // pop digits to get the multiplier
            StringBuilder numStr = new StringBuilder();
            while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                numStr.insert(0, stack.pop());  // prepend to keep digit order
            }
            int k = Integer.parseInt(numStr.toString());

            // push the expanded string back, char by char
            String expanded = inner.toString().repeat(k);
            for(char ch : expanded.toCharArray()) {
                stack.push(ch);
            }
        } else {
            stack.push(c);   // digits, letters, '[' all pushed as-is
        }
    }

    // stack holds the final decoded chars, bottom to top
    StringBuilder result = new StringBuilder();
    while(!stack.isEmpty()) {
        result.insert(0, stack.pop());
    }
    return result.toString();
}
}