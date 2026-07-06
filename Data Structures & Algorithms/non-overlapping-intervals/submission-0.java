class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        /*
        [1,2] [1, 4] [2, 4]

        The problem essentially just devolves into counting the number of overlaps
        however we need to be mindful of double counting

        For example (1,2) and (1,4) are overlapping but if we do not move the indices correctly
        or handle it correctly we risk comparing (1,4) against another interval when it should 
        be against (1,2)


        */

        int count = 0;
        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}
