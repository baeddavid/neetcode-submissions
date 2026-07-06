class Solution {
    public int mostBooked(int n, int[][] meetings) {
        /*
        (1,20),(2,10),(3,5),(4,9),(6,8)
        (1, 20), (2, 10), (3, 5) --> meeting (4, 9) is delayed because of (3, 5)
        (1, 20), (2, 10), (5, 10) --> meeting (6, 8) is delayed because of (2, 10)
        (1, 20), (10, 12), (5, 10)

        Of the concurrent n meetings happening you want the smallest end time as that frees up first
        when we insert the new meeting we need to update it's start time to the end time of the 
        conflicting meeting and update the end time to duration of inserted meeting + start time

        Ok so we track the smallest end time as that is the room that frees first

        We now need to track meeting room counts
        this is just a hashmap we iterate over the hashmap looking for max value 

        the real issue is when meetings have conflicting counts
        we'd need to reiterate over hashmap searching for first occurence of max count

        HashMap<Integer, Integer> map
        key is meeeting room, value is count

        We could use a min heap of size n
        min heap top is the end time of meetings
        so we push meetings into min heap until size = n
        when we try to push and size = n 
        poll the heap and insert the new updated time into the heap

        This is complicated though because we don't know what room it's being inserted into 
        Unless the heap is not just an interval

        we have a meeting object
        Meeting {
            int[] interval,
            int meetingRoom
        }

        So when we poll a meeting from the heap we insert the new updated interval based on delay
        into the min heap and assign it the meeting room from the polled meeting

        But what if multiple rooms are free?
        We cant determine in the heap which meetingRoom value to insert into?
        Unless..
        Unless we keep a paralell data structure

        A set
        we use a set where it tells us what rooms are free and iterate through it?
        So say we have 4 rooms 2 are occupied (1, 3)
        Iterate through n for first occurence where i is not preseent in the set that is 
        the room we insert

        the set is the SOT for open rooms
        So when we poll a room we give it back to the set
        when we insert a meeting we take first i that is not in set
        */

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Meeting> busy = new PriorityQueue<>(
            (a, b) -> a.end != b.end ? Integer.compare(a.end, b.end) : Integer.compare(a.room, b.room)
        );

        TreeSet<Integer> free = new TreeSet<>();
        for(int i = 0; i < n; i++) free.add(i);

        int[] count = new int[n];

        for(int[] meeting: meetings) {
            int start = meeting[0], end = meeting[1];
            while(!busy.isEmpty() && busy.peek().end <= start) {
                free.add(busy.poll().room);
            }

            if(!free.isEmpty()) {
                int room = free.pollFirst();
                count[room]++;
                busy.offer(new Meeting(start, end, room));
            } else {
                Meeting earliest = busy.poll();
                int room = earliest.room;
                count[room]++;
                int duration = end - start;
                busy.offer(new Meeting(earliest.end, earliest.end + duration, room));
            }
        }

        int best = 0;
        for(int r = 1; r < n; r++) {
            if(count[r] > count[best])
                best = r;
        }
        return best;
    }
 
    class Meeting {
        int start, end;
        int room;

        Meeting(int start, int end, int room) {
            this.start = start;
            this.end = end;
            this.room = room;
        }
    }
}