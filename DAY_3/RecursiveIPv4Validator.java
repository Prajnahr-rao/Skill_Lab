import java.util.Scanner;

public class RecursiveIPv4Validator {

    public static boolean isValidIPv4(String ip) {
        // Split the IP address into parts using the dot as a delimiter
        String[] parts = ip.split("\\.");

        // Start the recursive validation from the first part
        return validateParts(parts, 0);
    }

    private static boolean validateParts(String[] parts, int index) {
        // Base case: if we've checked all 4 parts
        if (index == 4) {
            return true;
        }

        // Check if there are exactly 4 parts
        if (parts.length != 4) {
            return false;
        }

        String part = parts[index];

        // Check if the part is numeric and within the range 0-255
        if (!part.matches("\\d+") || part.length() == 0 || part.length() > 3) {
            return false;
        }

        int num = Integer.parseInt(part);
        if (num < 0 || num > 255 || (part.length() > 1 && part.startsWith("0"))) {
            return false;
        }

        // Recursive call for the next part
        return validateParts(parts, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Enter an IPv4 address: ");
        String ip = scanner.nextLine();

        if (isValidIPv4(ip)) {
            System.out.println(ip + " is a valid IPv4 address.");
        } else {
            System.out.println(ip + " is not a valid IPv4 address.");
        }

        scanner.close();
    }
}