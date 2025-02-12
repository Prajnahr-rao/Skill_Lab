import java.util.*;

public class KthClosestElement {

    // Helper class to store readings and their distances from the target
    static class ReadingDistance {
        int reading;
        int distance;

        ReadingDistance(int reading, int distance) {
            this.reading = reading;
            this.distance = distance;
        }
    }

    // Function to find the K-th closest element
    public static int findKthClosest(int[] readings, int target, int k) {
        // Step 1: Calculate distances and store in a list
        List<ReadingDistance> distances = new ArrayList<>();
        for (int reading : readings) {
            distances.add(new ReadingDistance(reading, Math.abs(reading - target)));
        }

        // Step 2: Use Quickselect to find the K-th smallest distance
        quickselect(distances, 0, distances.size() - 1, k - 1);

        // Step 3: Return the K-th closest reading
        return distances.get(k - 1).reading;
    }

    // Quickselect algorithm
    private static void quickselect(List<ReadingDistance> distances, int left, int right, int k) {
        if (left >= right) return;

        // Partition the list around a pivot
        int pivotIndex = partition(distances, left, right);

        // If the pivot is the K-th element, return
        if (pivotIndex == k) {
            return;
        }
        // If K is less than the pivot, recurse on the left part
        else if (k < pivotIndex) {
            quickselect(distances, left, pivotIndex - 1, k);
        }
        // If K is greater than the pivot, recurse on the right part
        else {
            quickselect(distances, pivotIndex + 1, right, k);
        }
    }

    // Partition function for Quickselect
    private static int partition(List<ReadingDistance> distances, int left, int right) {
        // Choose the rightmost element as the pivot
        int pivotDistance = distances.get(right).distance;
        int i = left;

        // Move all elements smaller than the pivot to the left
        for (int j = left; j < right; j++) {
            if (distances.get(j).distance < pivotDistance) {
                swap(distances, i, j);
                i++;
            }
        }

        // Move the pivot to its correct position
        swap(distances, i, right);
        return i;
    }

    // Helper function to swap elements in the list
    private static void swap(List<ReadingDistance> distances, int i, int j) {
        ReadingDistance temp = distances.get(i);
        distances.set(i, distances.get(j));
        distances.set(j, temp);
    }

    public static void main(String[] args) {
        int[] readings = {72, 75, 68, 80, 74};
        int target = 73;
        int k = 2;

        int result = findKthClosest(readings, target, k);
        System.out.println("The " + k + "-th closest reading is: " + result);
    }
}