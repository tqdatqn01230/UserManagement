package fpt.mantv.helper;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringHelper {
    public static boolean isEmpty(String check) {
        return (check == null || check.trim().isEmpty());
    }
    // username
    public static String getUserInputString(Scanner scanner, String regex, String inputMessage, String errorMessage) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        while (true) {
            System.out.print(inputMessage);
            String input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                return input;
            }
            else {
                System.out.println(errorMessage);
            }
        }
    }
    public static int getUserInputInt(Scanner scanner, String inputMessage, String errorMessage) {
        while (true) {
            System.out.print(inputMessage);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException exception) {
                System.out.println(errorMessage);
            }
        }
    }
}
