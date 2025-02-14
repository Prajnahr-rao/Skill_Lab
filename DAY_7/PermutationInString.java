public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // If s1 is longer than s2, s2 cannot contain a permutation of s1
        if (len1 > len2) {
            return false;
        }

        // Frequency arrays for s1 and the current window in s2
        int[] count1 = new int[52];
        int[] count2 = new int[52];

        // Initialize the frequency map for s1
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // Compare the frequency maps
        if (matches(count1, count2)) {
            return true;
        }

        // Slide the window over s2
        for (int i = len1; i < len2; i++) {
            // Add the new character to the window
            count2[s2.charAt(i) - 'a']++;
            // Remove the old character from the window
            count2[s2.charAt(i - len1) - 'a']--;

            // Compare the frequency maps after sliding the window
            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    // Helper method to compare two frequency arrays
    private boolean matches(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();
        System.out.println(solution.checkInclusion("ab", "eidbaooo")); // Output: true
        System.out.println(solution.checkInclusion("ab", "eidboaoo")); // Output: false
    }
}
