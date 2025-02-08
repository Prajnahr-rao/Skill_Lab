import java.util.Scanner;

public class PostfixSum {
    public static void main(String[] args) {
        // Create a Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Ask the user for the number of delivery points
        System.out.print("Enter the number of delivery points: ");
        int m = sc.nextInt();

        // Create an array to store fuel consumption
        int[] Fuel = new int[m];

        // Take input for fuel consumption at each delivery point
        System.out.println("Enter the fuel consumed at each delivery point:");
        for (int i = 0; i < m; i++) {
            Fuel[i] = sc.nextInt();
        }

        // Create an array to store the postfix sums
        int[] PostfixSum = new int[m];

        // Calculate the postfix sum
        int sum = 0;
        for (int i = m - 1; i >= 0; i--) {
            sum += Fuel[i];
            PostfixSum[i] = sum;
        }

        // Print the postfix sum array
        System.out.println("PostfixSum[] = " + java.util.Arrays.toString(PostfixSum));

        // Close the scanner
        sc.close();
    }
}