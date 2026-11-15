class Solution {
    public int maxProfit(int[] prices) {
        int minPriceSoFar = Integer.MAX_VALUE;  // cheapest buy seen so far
        int maxProfit = 0;                      // 0 if prices only fall

        for (int price : prices) {
            if (price < minPriceSoFar) {
                minPriceSoFar = price;          // a better day to buy
            } else if (price - minPriceSoFar > maxProfit) {
                maxProfit = price - minPriceSoFar;  // a better day to sell
            }
        }
        return maxProfit;
    }
}