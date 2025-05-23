import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final String[] FIRST_NAMES = {"John", "Alice", "Michael", "Emma", "David", "Olivia", "James", "Sophia", "Robert", "Isabella"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Password creation
        System.out.println("Welcome to Click N Eat! An online ordering system \nLet's first create a password.");
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();

        char lastLetterFirstName = Character.toUpperCase(firstName.charAt(firstName.length() - 1));
        Random random = new Random();
        int randomNumber = random.nextInt(90) + 10;
        String firstThreeLettersLastName = lastName.substring(0, Math.min(3, lastName.length())).toLowerCase();
        String password = lastLetterFirstName + String.valueOf(randomNumber) + firstThreeLettersLastName;
        password = password.concat("****");

        System.out.println("Your password is:" + password);

        System.out.println("\nWelcome!");
        System.out.println("Please enter your password:");
        String userInputPassword = scanner.nextLine();

        if (!userInputPassword.equals(password)) {
            System.out.println("Incorrect password. Access denied. Please try again.");
            return;
        }

        System.out.println("Please enter your full name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your email (Must contain an '@' symbol):");
        String email = scanner.nextLine();
        while (!isValidEmail(email)) {
            System.out.println("Invalid email. Please enter an email with the '@' symbol");
            email = scanner.nextLine();
        }
        System.out.println("Please enter your phone number (10 digits):");
        String phoneNumber = scanner.nextLine();
        while (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Invalid phone number. Please enter a 10-digit number:");
            phoneNumber = scanner.nextLine();
        }

        FoodOrderSystem foodOrderSystem = new FoodOrderSystem(name);
        foodOrderSystem.startOrdering(scanner);

        double subtotal = foodOrderSystem.getTotal();
        final double tax = 0.06 * subtotal;
        double total = subtotal * 1.06;

        System.out.println("Would you like to add a tip? (yes/no)");
        String tipChoice = scanner.nextLine();
        double tip = 0.00;
        if (tipChoice.equals("yes") || tipChoice.equals("y")) {
            System.out.println("Enter the tip amount:");
            tip = scanner.nextDouble();
        }

        total += tip;

        List<String> orderedItems = foodOrderSystem.getOrderedItems();

        Date currentDate = new Date();
        String NameFirst = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String NameLast = LAST_NAMES[random.nextInt(LAST_NAMES.length)];

        Receipt receipt = new Receipt(name, subtotal, tax, tip, total, NameFirst + " " + NameLast, currentDate, orderedItems);
        receipt.printReceipt();

        scanner.close();
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10}");
    }

    private static boolean isValidEmail(String email) {
        return email.contains("@");
    }
}
