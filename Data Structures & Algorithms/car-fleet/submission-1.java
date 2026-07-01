class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /*
        This is an interesting one
        essentially we are asked to see any convergences before inclusive up until target

        LMFAO a part of me wants to convert this to a linked list it's pretty intuitive to think of it that way
        target = 10, position = [4,1,0,7], speed = [2,2,1,1]

        linked list length of 10
        pointers start at 4, 1, 0 ,7
        first two ponters double jump last two increment singularly 

        then we just treat it as iteration and see when do these converge

        thinking we could also simulate it
        4 + 2 until <= target
        1 + 2 until <= target
        0 + 1 until <= target
        7 + 1 until <= target

        we build this then count unique numbers 
        but this seems really bad
        */

        int n = position.length;
        Integer[] idx = new Integer[n];
        for(int i = 0; i < n ; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> position[b] - position[a]);

        int fleets = 0;
        double leadTime = 0.0;
        for(int i : idx) {
            double time = (double)(target - position[i]) / speed[i];
            if(time > leadTime) {
                fleets++;
                leadTime = time;
            }
        }
        return fleets;
    }
}
