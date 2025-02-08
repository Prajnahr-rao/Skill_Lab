import java.util.Scanner;

public class PrefixSum {
    public static int[] calculatePrefixSum(int[] Sales) {
        int n = Sales.length;
        int[] PrefixSum = new int[n]; // Initialize the PrefixSum array

        PrefixSum[0] = Sales[0]; // The first element is the same as the first sales amount

        // Loop through the array starting from the second element
        for (int i = 1; i < n; i++) {
            PrefixSum[i] = PrefixSum[i - 1] + Sales[i]; // Add the current sales to the previous prefix sum
        }

        return PrefixSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of hours
        System.out.print("Enter the number of hours: ");
        int n = scanner.nextInt();

        // Initialize the Sales array
        int[] Sales = new int[n];

        // Ask the user to input the sales for each hour
        System.out.println("Enter the sales for each hour:");
        for (int i = 0; i < n; i++) {
            System.out.print("Sales for hour " + (i + 1) + ": ");
            Sales[i] = scanner.nextInt();
        }

        // Calculate the prefix sum
        int[] PrefixSum = calculatePrefixSum(Sales);

        // Print the result
        System.out.println("Prefix Sum array:");
        for (int value : PrefixSum) {
            System.out.print(value + " ");
        }

        scanner.close(); // Close the scanner
    }
}