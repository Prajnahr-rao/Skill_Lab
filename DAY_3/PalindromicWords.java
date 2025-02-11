
import java.util.*;

public class PalindromicWords {

    public static int countDistinctPalindromicWords(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        s = s.toLowerCase();
        String[] words = s.split("\\s+"); // Split by one or more whitespace characters
        Set<String> palindromicWords = new HashSet<>();

        for (String word : words) {
            if (isPalindrome(word)) {
                palindromicWords.add(word);
            }
        }

        return palindromicWords.size();
    }

    private static boolean isPalindrome(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        return new StringBuilder(word).reverse().toString().equals(word);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        int count = countDistinctPalindromicWords(inputString);
        System.out.println("Number of distinct palindromic words: " + count);

        scanner.close();
    }
}
