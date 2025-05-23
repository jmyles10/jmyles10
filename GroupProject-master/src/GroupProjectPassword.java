import java.util.Scanner;
import java.util.Random;

public class GroupProjectPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter first and last name
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        // Convert the first name's last letter to uppercase
        char lastLetterFirstName = Character.toUpperCase(firstName.charAt(firstName.length() - 1));

        // Generate a random number from 10 to 99
        Random random = new Random();
        int randomNumber = random.nextInt(90) + 10;

        // Get the first three letters of the last name and convert to lowercase
        String firstThreeLettersLastName = lastName.substring(0, Math.min(3, lastName.length())).toLowerCase();

        // Create the password string
        String password = lastLetterFirstName + String.valueOf(randomNumber) + firstThreeLettersLastName;

        // Print the password string
        System.out.println("Password string: " + password);

        // Use concat method to add four **** values
        password = password.concat("****");

        // Print the password after using concat
        System.out.println("Password after using concat: " + password);

        // Reverse the password using StringBuilder
        StringBuilder reversedPassword = new StringBuilder(password);
        reversedPassword.reverse();

        // Print the reversed password
        System.out.println("Reversed password: " + reversedPassword);

        scanner.close();
    }
}
