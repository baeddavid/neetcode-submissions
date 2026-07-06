class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        We must determine when do intervals need to be merge

        There are two cases we must consider

        If an interval belongs entirely inside an interval
        [3, 7], [4, 5] -> [3, 7]

        If an interval has an overlap where i[a, b] and i + 1[c, d] wher b > c
        [1, 3], [1, 5] -> [1, 5]

        What we should do first is sort the intervals by start time
        then we compare is b > c? If true then is b > d? 

        If both are true then just doink the the smaller interval 
        If only b > c t hen update the end interval of b and remove the interval after 
        */

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        for(int[] interval : intervals) {
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1], interval[0 == 0 ? 1 : 1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
