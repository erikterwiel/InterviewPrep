class Solution {
  public int maxProfit(int[] prices) {
    
    if (prices.length < 2) {
      return 0;
    }
    
    int buy = 0;
    int sell = 1;
    int maxProfit = 0;
    while (sell < prices.length) {
      if (prices[buy] > prices[sell]) {
        buy = sell;
        sell++;
        continue;
      }
      maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
      sell++;
    }
    return maxProfit;
  }
}