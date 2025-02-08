import java.util.Scanner;

public class MaxSales {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of ratings: ");
        int n = scanner.nextInt();

        // Check if the number of ratings is valid
        if (n <= 0) {
            System.out.println("Please enter a positive number of ratings.");
            return;
        }

        int[] ratings = new int[n];

        System.out.println("Enter the ratings:");
        for (int i = 0; i < n; i++) {
            System.out.print("Rating " + (i + 1) + ": ");
            ratings[i] = scanner.nextInt();
        }

        int maxFrequency = 0; // Maximum frequency of any rating
        int mostFrequentRating = -1; // Stores the most frequent rating
        boolean multipleFrequent = false; // Flag to indicate multiple most frequent

        // Loop through each rating to count frequencies
        for (int i = 0; i < n; i++) {
            int currentRating = ratings[i];
            int count = 0; // Count occurrences of currentRating

            // Count how many times currentRating appears in the ratings
            for (int j = 0; j < n; j++) {
                if (ratings[j] == currentRating) {
                    count++;
                }
            }

            // Update most frequent rating if currentRating has a higher frequency
            if (count > maxFrequency) {
                maxFrequency = count;
                mostFrequentRating = currentRating;
                multipleFrequent = false; // Reset flag as we have a new most frequent
            } else if (count == maxFrequency && currentRating != mostFrequentRating) {
                multipleFrequent = true; // Found another rating with the same frequency
            }
        }

        // Output the result
        if (mostFrequentRating != -1) {
            if (multipleFrequent) {
                System.out.println("Multiple most frequent ratings exist.");
            } else {
                System.out.println("Most frequent rating: " + mostFrequentRating);
            }
        } else {
            System.out.println("No ratings were entered.");
        }

        scanner.close();
    }
}
