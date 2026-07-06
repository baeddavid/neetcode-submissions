/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        /*
        Uh hm
        This problem is essentially counting how many overlaps there are no?

        (0, 40), (5, 10), (15, 20)
        meeting 1 and 2 conflict so we need 2 rooms
        meeting 2 and 3 don't so we don't need another room

        we need to sort this or else we get weird nonsense where we could compare overlaps 
        and keep growing room count when a sequence of rooms would be fine 

        We sort by start and it's fine because we need a new room if the end of a meeting
        overlaps with the starta
        */

        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        int writeIdx = 0;

        for(Interval interval : intervals) {
            start[writeIdx] = interval.start;
            end[writeIdx] = interval.end;
            writeIdx++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0, e = 0, maxCount = 0, count = 0;

        while(s < intervals.size()) {
            if(start[s] < end[e]) { // If we can start a meeting get a room
                count++;
                maxCount = Math.max(maxCount ,count);
                s++;
            }  else {
                count--;
                e++;
            }
        } 
        return maxCount;
    }
}
