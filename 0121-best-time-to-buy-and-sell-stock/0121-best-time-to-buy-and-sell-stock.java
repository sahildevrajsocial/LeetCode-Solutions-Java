class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0||prices.length == 1){
            return 0;
        }

        int min = prices[0];
        int maxProfit = 0;

        for(int i = 0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            int p = prices[i] - min;
            maxProfit = Math.max(p, maxProfit);
        }
        return maxProfit;
    }
}