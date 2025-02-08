public class InversionCount {
    public static int countInversions(int[] arr) {
        int n = arr.length;
        int inversionCount = 0;

        // Loop through each element in the array
        for (int i = 0; i < n; i++) {
            // Compare it with every element after it
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inversionCount++; // Increment the inversion count
                }
            }
        }

        return inversionCount;
    }

    public static void main(String[] args) {
        int[] P = {30, 45, 25, 60, 20}; // Example input
        int result = countInversions(P);
        System.out.println("The inversion count is " + result); // Output: 6
    }
}