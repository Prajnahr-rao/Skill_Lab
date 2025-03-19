
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int minPrice = prices[0];  // Track the minimum price seen so far
        int maxProfit = 0;         // Track the maximum profit
        
        for (int i = 1; i < prices.length; i++) {
            // Check if selling at the current price gives a better profit
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            
            // Update the minimum price seen so far
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
    }
}
```

The algorithm works as follows:
1. Initialize `minPrice` to the first price in the array
2. Initialize `maxProfit` to 0 (if we can't make any profit, we return 0)
3. Iterate through the prices starting from the second day:
   - Calculate the potential profit if we were to sell at the current price
   - Update `maxProfit` if the current potential profit is greater
   - Update `minPrice` if the current price is lower than our previously recorded minimum

This solution is efficient with:
- Time complexity: O(n) where n is the length of the prices array, as we make a single pass through the array
- Space complexity: O(1) as we only use two variables regardless of input size

This approach works because to maximize profit, we need to buy at the lowest price and sell at the highest price afterward. By tracking the minimum price seen so far and calculating the profit at each step, we can find the optimal buying and selling points.