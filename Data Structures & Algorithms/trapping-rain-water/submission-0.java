class Solution {
    public int trap(int[] height) {
        /*
        A good way to think about this problem is what is the maximum amount of water at this current column?

        Maximum water at the current column is defined as the minimum height of the two boundadriesÏ
        */
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while(left < right) {
            if(height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
