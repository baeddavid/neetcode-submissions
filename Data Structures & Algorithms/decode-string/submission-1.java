class Solution {
    public String decodeString(String s) {
    Deque<Integer> countStack = new ArrayDeque<>();
    Deque<StringBuilder> stringStack = new ArrayDeque<>();
    StringBuilder curr = new StringBuilder();
    int num = 0;

    for(char c : s.toCharArray()) {
        if(Character.isDigit(c)) {
            num = num * 10 + (c - '0');          // multi-digit build
        } else if(c == '[') {
            countStack.push(num);
            stringStack.push(curr);
            num = 0;
            curr = new StringBuilder();
        } else if(c == ']') {
            int k = countStack.pop();
            StringBuilder prev = stringStack.pop();
            for(int i = 0; i < k; i++) prev.append(curr);
            curr = prev;                          // curr becomes the merged result
        } else {
            curr.append(c);                       // letter
        }
    }
    return curr.toString();
}
}