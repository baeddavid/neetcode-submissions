class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        Essentially the results array at index i is how far in the array until we see a hotter day
        it's a forward scan

        this can be done brute force with a disgusting O(n^2) double scan

        We need to headshot this double scan it's really bad for time

        uh we can map it?
        value to index

        actually this doesn't solve the issue

        this is a next greater problem but done for every element in the array lmao

        oh and we don't care about left from index i we only go rightward


        */

        int n = temperatures.length;
        int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                result[prev] = i - prev;
            }
            stack.push(i);
        }
        return result;
    }
}
