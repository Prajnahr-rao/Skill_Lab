import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: if the current string has reached the maximum length (2 * n), add it to the result
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // If we can still add an opening parenthesis, do so
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // If we can add a closing parenthesis (i.e., there are more opening parentheses than closing ones), do so
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        System.out.println(result); // Output: [((())), (()()), (())(), ()(()), ()()()]
    }
}