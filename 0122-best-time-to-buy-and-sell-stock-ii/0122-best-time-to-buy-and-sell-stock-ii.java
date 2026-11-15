class Solution {
    public int maxProfit(int[] prices) {

        int totalProfit =0;

        int a =0;
        int b=1;
        

        while(b<prices.length){
            if(prices[a]<prices[b]){
                totalProfit = totalProfit+(prices[b]-prices[a]);
                a++;
                b++;
            }else if(prices[a]>prices[b]){
                a++;
                b++;
            }else{
                b++;
                a++;
            }

        }

        return totalProfit;
        
    }
}