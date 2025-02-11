import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    public static Map<String, Integer> countWords(String paragraph) {
        // Create a map to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Split the paragraph into words using whitespace as the delimiter
        String[] words = paragraph.split("\\s+");

        // Iterate through each word
        for (String word : words) {
            // Remove any non-alphabetic characters (e.g., punctuation) and convert to lowercase
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

            // Update the word count in the map if the word is not empty
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a paragraph
        System.out.println("Enter a paragraph:");
        String input = scanner.nextLine();

        // Close the scanner to avoid resource leak
        scanner.close();

        // Count the words in the paragraph
        Map<String, Integer> result = countWords(input);

        // Print the result
        System.out.println(result);
    }
}