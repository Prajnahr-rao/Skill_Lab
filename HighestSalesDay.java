import java.util.Scanner;

public class HighestSalesDay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of days
        System.out.print("Enter the number of days: ");
        int numberOfDays = scanner.nextInt();

        // Check if the number of days is valid
        if (numberOfDays <= 0) {
            System.out.println("Invalid number of days. Please enter a positive number.");
            return;
        }

        // Create an array to store sales data
        int[] salesData = new int[numberOfDays];

        // Input sales data for each day
        for (int i = 0; i < numberOfDays; i++) {
            System.out.print("Enter sales for day " + (i + 1) + ": ");
            salesData[i] = scanner.nextInt();
        }

        // Find the day with the highest sales
        int highestSalesDay = findHighestSalesDay(salesData);

        // Output the result
        if (highestSalesDay != -1) {
            System.out.println("The day with the highest sales is day " + (highestSalesDay + 1) + " with sales of " + salesData[highestSalesDay] + ".");
        } else {
            System.out.println("No sales data available.");
        }

        // Close the scanner
        scanner.close();
    }

    /**
     * This method finds the day with the highest sales from the given array.
     *
     * @param salesData An array of daily sales data.
     * @return The index of the day with the highest sales, or -1 if the array is empty.
     */
    public static int findHighestSalesDay(int[] salesData) {
        // Check if the array is empty
        if (salesData == null || salesData.length == 0) {
            return -1;
        }

        int maxSales = salesData[0];
        int maxDayIndex = 0;

        // Iterate through the array to find the day with the highest sales
        for (int i = 1; i < salesData.length; i++) {
            if (salesData[i] > maxSales) {
                maxSales = salesData[i];
                maxDayIndex = i;
            }
        }

        return maxDayIndex;
    }
}