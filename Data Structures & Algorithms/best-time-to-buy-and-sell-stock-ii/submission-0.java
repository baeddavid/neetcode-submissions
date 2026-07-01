class Solution {
    public int maxProfit(int[] prices) {
        /*
        This is a peaks and valleys problem
        Oh we can do it unlimited number of times
        so we just record every upmovement lol
        */
        int max = 0;

        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i + 1]) {
                max += prices[i + 1] - prices[i];
            } 
        }
        return max;
    } 
}