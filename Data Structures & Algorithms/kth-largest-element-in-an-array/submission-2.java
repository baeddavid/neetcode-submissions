class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        Quick select
        */

        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int pivot = partition(nums, left, right);
            if(pivot == target) return nums[pivot];
            else if(pivot < target) left = pivot + 1;
            else right = pivot - 1;
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right) {
        int pivotVal = nums[right];
        int i = left;
        for(int j = left; j < right; j++) {
            if(nums[j] < pivotVal) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
