class Solution {
    public int maxArea(int[] heights) {
        /*
        This is a sliding window problem kind of
        well not really
        not at all tbh

        our window invariant for what grows what shrinks is weak here 

        this is a two pointer problem

        start at left and right of the list
        we are bound by the min of the two values

        Math.min(h[left], h[right]) * (right - left)
        oh the question is how do we know which one to move inward

        hmmm

        the shorter one
        the smaller of the two is moved forward greedily
        */

        int left = 0, right = heights.length - 1;
        int max = 0;

        while(left < right) {
            int min = Math.min(heights[left], heights[right]);
            max = Math.max(max, min * (right - left));
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
