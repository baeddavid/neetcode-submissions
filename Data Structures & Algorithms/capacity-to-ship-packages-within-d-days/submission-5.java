class Solution {
    public int shipWithinDays(int[] weights, int days) {
        /*
        The vibe im getting from this problem is similar to koko
        binary search on the range

        the question here is what is the range

        gut instinct is max value in arr but that doesn't work because we can lead more 
        than just a single package in a day

        i mean
        ok
        technically we do have a range
        the range is the running sum of the arr  


        */

        int low = 0, high = 0;
        for(int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while(low < high) {
            int med = low + (high - low) / 2;
            if(canShip(weights, days, med)) {
                high = med;
            } else {
                low = med + 1;
            }
        }

        return low;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1, load = 0;
        for(int w : weights) {
            if(load + w > capacity) {
                daysNeeded++;
                load = 0;
            }
            load += w;
        }
        return daysNeeded <= days;
    }
}