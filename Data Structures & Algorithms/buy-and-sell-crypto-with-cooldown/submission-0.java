class Solution {
    
    private Map<String, Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
        //as many transactions as possible ~ atLeast 1 day waiting between them
        //Max Profit

        //Buy  +1
        //Sell +2

        return dfs(0,true,prices);
        
    }

    public int dfs(int i, boolean buy, int[] prices){
        if(i>=prices.length){
        return 0;
        }

        String key = i + "-" + buy;

        if(this.dp.containsKey(key)) return this.dp.get(key);
        int cooldown =  dfs(i+1, buy,prices);

        if(buy){
            int bought = -prices[i]+ dfs(i+1, false,prices);
            this.dp.put(key, Math.max(bought,cooldown));
        }else{

            int sell = prices[i]+ dfs(i+2, true ,prices);
            this.dp.put(key, Math.max(sell,cooldown));

        }
                return this.dp.get(key);

    }    
}
