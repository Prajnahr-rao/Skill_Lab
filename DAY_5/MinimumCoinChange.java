public class MinimumCoinChange {
    public static int minCoins(int[] coins, int amount) {
        // Create a DP array to store the minimum number of coins for each amount
        int[] dp = new int[amount + 1];
        
        // Initialize the DP array with a value larger than the maximum possible number of coins
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        
        // Base case: 0 coins are needed to make the amount 0
        dp[0] = 0;
        
        // Fill the DP array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still greater than amount, it means it's not possible to make the amount with the given coins
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = minCoins(coins, amount);
        System.out.println("Minimum number of coins required: " + result);
    }
}