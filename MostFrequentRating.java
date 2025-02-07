import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentRating {

    public static int findMostFrequentRating(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            throw new IllegalArgumentException("The ratings array cannot be null or empty.");
        }

        // Create a HashMap to store the frequency of each rating
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map
        for (int rating : ratings) {
            frequencyMap.put(rating, frequencyMap.getOrDefault(rating, 0) + 1);
        }

        // Find the rating with the highest frequency
        int mostFrequentRating = ratings[0];
        int maxFrequency = frequencyMap.get(mostFrequentRating);

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentRating = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return mostFrequentRating;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of ratings
        System.out.print("Enter the number of ratings: ");
        int n = scanner.nextInt();

        // Check if the number of ratings is valid
        if (n <= 0) {
            System.out.println("Error: The number of ratings must be greater than 0.");
            scanner.close();
            return;
        }

        // Initialize the ratings array
        int[] ratings = new int[n];

        // Prompt the user to enter each rating
        System.out.println("Enter the ratings:");
        for (int i = 0; i < n; i++) {
            System.out.print("Rating " + (i + 1) + ": ");
            ratings[i] = scanner.nextInt();
        }

        // Find and display the most frequent rating
        try {
            int mostFrequentRating = findMostFrequentRating(ratings);
            System.out.println("Most frequent rating: " + mostFrequentRating);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Close the scanner
        scanner.close();
    }
}