import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; // Initialize the result array
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of the next greater elements

        // Start the recursive function from the last index
        findNextGreater(n - 1, arr, result, stack);
        return result;
    }

    private static void findNextGreater(int index, int[] arr, int[] result, Stack<Integer> stack) {
        // Base case: if we have processed all elements
        if (index < 0) {
            return;
        }

        // Pop elements from the stack that are less than or equal to the current element
        while (!stack.isEmpty() && stack.peek() <= arr[index]) {
            stack.pop();
        }

        // If the stack is empty, there is no greater element
        if (stack.isEmpty()) {
            result[index] = -1;
        } else {
            result[index] = stack.peek();
        }

        // Push the current element onto the stack
        stack.push(arr[index]);

        // Recursive call for the next index
        findNextGreater(index - 1, arr, result, stack);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = nextGreater(arr);
        System.out.println("Next greater elements: " + Arrays.toString(result));

        scanner.close();
    }
}