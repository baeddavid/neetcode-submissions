class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();   // indices, heights INCREASING bottom→top
        int best = 0;
        for (int i = 0; i <= heights.length; i++) {
            int curH = (i == heights.length) ? 0 : heights[i];   // sentinel 0 drains the stack at the end
            while (!stack.isEmpty() && heights[stack.peek()] > curH) {
                int height = heights[stack.pop()];               // the bar we're settling
                int leftBound = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftBound - 1;                   // rightReach + leftReach + 1
                best = Math.max(best, height * width);
            }
            stack.push(i);
        }
        return best;
    }
}