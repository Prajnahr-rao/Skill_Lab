import java.util.*;

public class MinimumStockPrice {
    public static List<Integer> findMinimumPrices(int[] prices, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            // Remove indices of elements not in the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of all elements greater than the current element
            while (!deque.isEmpty() && prices[deque.peekLast()] > prices[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // If the window has reached size k, add the minimum to the result
            if (i >= k - 1) {
                result.add(prices[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] prices = {120, 110, 115, 100, 105, 98, 102};
        int k = 3;
        List<Integer> minimumPrices = findMinimumPrices(prices, k);
        System.out.println(minimumPrices); // Output: [110, 100, 100, 98, 98]
    }
}