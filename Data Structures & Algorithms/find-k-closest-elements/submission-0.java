class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    // Step 1: binary search for x's position (insertion point if not found)
    int lo = 0, hi = arr.length - 1;
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] < x) lo = mid + 1;
        else hi = mid;
    }
    // lo is now the index of x, or where x would be inserted

    // Step 2: two pointers expand outward from the pivot
    int left = lo - 1, right = lo;     // left of pivot, and pivot-or-right
    // grab k elements, each time taking the closer side
    while (right - left - 1 < k) {     // window currently holds (right - left - 1) elements
        if (left < 0) {                // left exhausted → must take right
            right++;
        } else if (right >= arr.length) { // right exhausted → must take left
            left--;
        } else if (x - arr[left] <= arr[right] - x) {  // left is closer-or-equal (left bias)
            left--;
        } else {                        // right is strictly closer
            right++;
        }
    }

    // window is (left, right) exclusive → elements arr[left+1 .. right-1]
    List<Integer> result = new ArrayList<>();
    for (int i = left + 1; i < right; i++) result.add(arr[i]);
    return result;
}
}