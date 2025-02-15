import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count1 = new int[52]; // Stores frequency of s1
        int[] count2 = new int[52]; // Stores frequency of s2's window

        // Initialize frequency counts for s1 and first len1 characters of s2
        for (int i = 0; i < len1; i++) {
            count1[getCharIndex(s1.charAt(i))]++;
            count2[getCharIndex(s2.charAt(i))]++;
        }

        // If the first window is a match, return true
        if (Arrays.equals(count1, count2)) return true;

        // Sliding window technique
        for (int i = len1; i < len2; i++) {
            count2[getCharIndex(s2.charAt(i))]++;         // Add new character
            count2[getCharIndex(s2.charAt(i - len1))]--;  // Remove old character

            if (Arrays.equals(count1, count2)) return true;
        }

        return false;
    }

    // Converts character to index (0-25 for a-z, 26-51 for A-Z)
    private int getCharIndex(char ch) {
        return (ch >= 'a') ? (ch - 'a') : (ch - 'A' + 26);
    }

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));  // true
        System.out.println(solution.checkInclusion("AB", "eidbaOOo"));  // true
        System.out.println(solution.checkInclusion("xyz", "YXZabcd"));  // true
    }
}
