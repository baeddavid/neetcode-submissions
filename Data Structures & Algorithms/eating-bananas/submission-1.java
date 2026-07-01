class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for(int pile : piles) {
            high = Math.max(high, pile);
        }

        while(low < high) {
            int med = low + (high - low) / 2;
            if(canFinish(piles, h, med)) {
                high = med;
            } else {
                low = med + 1;
            }
        }
        return low;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        int hours = 0;
        for(int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours <= h;
    }
}
