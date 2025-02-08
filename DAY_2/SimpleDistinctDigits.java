import java.util.*;

public class SimpleDistinctDigits {

    public static List<Integer> findDistinctDigits(int[] numbers) {
        Set<Integer> uniqueDigits = new HashSet<>(); // Step 1: Create a set for unique digits

        for (int num : numbers) { // Step 2: Loop through each number
            String numStr = Integer.toString(num); // Step 2a: Convert number to string
            for (char c : numStr.toCharArray()) { // Step 2b: Loop through each character
                uniqueDigits.add(Character.getNumericValue(c)); // Step 2(b)i: Add digit to set
            }
        }

        List<Integer> sortedDigits = new ArrayList<>(uniqueDigits); // Step 3: Convert set to list
        Collections.sort(sortedDigits); // Step 3: Sort the list
        return sortedDigits; // Step 4: Return sorted list
    }

    public static void main(String[] args) {
        int[] inputNumbers = {111, 222, 333, 4444, 666}; // Example input
        List<Integer> output = findDistinctDigits(inputNumbers); // Get distinct digits
        System.out.println(output); // Output: [1, 2, 3, 4, 6]
    }
}