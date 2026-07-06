class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        // min-heap of end times: the earliest-ending meeting sits on top
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int maxRooms = 0;
        for (Interval it : intervals) {
            // free every room whose meeting has already ended by the time this one starts
            while (!heap.isEmpty() && heap.peek() <= it.start) {
                heap.poll();
            }
            heap.offer(it.end);
            maxRooms = Math.max(maxRooms, heap.size());
        }
        return maxRooms;
    }
}