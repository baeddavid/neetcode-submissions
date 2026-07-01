class MinStack {
    /*
    This is just a monotonic stack isn't it?

    This is beacuse if do get min and pop the entire stack we'll get an ascending order
    */

    private static class Node {
        final int val, min;
        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private final Deque<Node> stack = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(val, stack.peek().min);
        stack.push(new Node(val, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
