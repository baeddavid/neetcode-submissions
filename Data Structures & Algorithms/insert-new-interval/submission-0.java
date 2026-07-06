class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        If we have an interval to insert and it's already sorted this is kinda chill.
        We scan forward in like two phases 

        first we scan where start belongs
        then scan where end belongs
        insert the interval merging any conflicting intervals from the insertion
        */

        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        while(i < n) {
            result.add(intervals[i++]);
        }

        int[][] resultArr = new int[result.size()][2];
        for(int j = 0; j < resultArr.length; j++) {
            resultArr[j] = result.get(j);
        }
        return resultArr;
    }
}
