class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int r =1;
        int max = 0;
        while(r<prices.length){
            
            if(prices[l]>prices[r]) l=r; // find the smallest start

            if(prices[l] < prices[r]){
               max = Math.max(prices[r]-prices[l],max); // update for max profit
            }

            r++; 

        }
        return max;
        
    }
}
