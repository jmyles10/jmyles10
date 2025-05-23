import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodOrderSystem {
    private String customerName;
    private double total;
    private List<String> orderedItems;

    public FoodOrderSystem(String customerName) {
        this.customerName = customerName;
        this.total = 0.0;
        this.orderedItems = new ArrayList<>();
    }

    public void startOrdering(Scanner scanner) {
        boolean ordering = true;
        while (ordering) {
            System.out.println("What type of food would you like? \n1. Pizza \n2. Sushi \n3. Burger \n4. Dessert \n5. Beverage");
            String foodType = scanner.nextLine().toLowerCase();
            switch (foodType) {
                case "pizza":
                    orderPizza(scanner);
                    break;
                case "sushi":
                    orderSushi(scanner);
                    break;
                case "burger":
                    orderBurger(scanner);
                    break;
                case "dessert":
                    orderDesserts(scanner);
                    break; // Added break statement
                case "beverage":
                    orderBeverage(scanner);
                    break; // Added break statement
                default:
                    System.out.println("Invalid choice. Please select from: \n1. Pizza \n2. Sushi \n3. Burger \n4. Dessert \n5. Beverage.");
            }
            System.out.println("Would you like to purchase anything else? (yes/no)");
            String continueOrder = scanner.nextLine().toLowerCase();
            ordering = continueOrder.equals("yes");
        }
    }

    private void orderPizza(Scanner scanner) {
        System.out.println("What toppings would you like? \n1. Sausage \n2. Pepperoni \n3. Veggie");
        String pizzaType = scanner.nextLine().toLowerCase();
        total += 10.99;
        orderedItems.add("Pizza: " + pizzaType);
    }

    private void orderSushi(Scanner scanner) {
        System.out.println("What type of sushi would you like? \n1. Crab \n2. Shrimp \n3. Veggie");
        String sushiType = scanner.nextLine().toLowerCase();
        total += 10.99;
        orderedItems.add("Sushi: " + sushiType);
    }

    private void orderBurger(Scanner scanner) {
        System.out.println("What type of burger would you like? \n1. Cheeseburger \n2. Veggie Burger");
        String burgerType = scanner.nextLine().toLowerCase();
        total += 10.99;
        orderedItems.add("Burger: " + burgerType);
    }

    private void orderDesserts(Scanner scanner) {
        System.out.println("What dessert would you like? \n1. Ice Cream \n2. Brownie \n3. Cake");
        String dessertType = scanner.nextLine().toLowerCase();

        double dessertPrice = 0.0;
        switch (dessertType) {
            case "ice cream":
                dessertPrice = 3.99;
                break;
            case "brownie":
                dessertPrice = 4.99;
                break;
            case "cake":
                dessertPrice = 5.99;
                break;
            default:
                System.out.println("Invalid dessert choice. Please select from: \n1. Ice Cream \n2. Brownie \n3. Cake");
                return; // Return without adding to total if invalid choice
        }

        total += dessertPrice;
        orderedItems.add("Dessert: " + dessertType);
    }

    private void orderBeverage(Scanner scanner) {
        System.out.println("What beverage would you like? \n1. Coke \n2. Sprite \n3. Lemonade \n4. Water");
        String beverageType = scanner.nextLine().toLowerCase();

        double beveragePrice = 0.0;
        switch (beverageType) {
            case "coke":
            case "sprite":
            case "lemonade":
            case "water":
                beveragePrice = 1.99;
                break;
            default:
                System.out.println("Invalid beverage choice. Please select from: \n1. Coke \n2. Sprite \n3. Lemonade \n4. Water");
                return; // Return without adding to total if invalid choice
        }
        total += beveragePrice;
        orderedItems.add("Beverage: " + beverageType);
    }

    public double getTotal() {
        return total;
    }

    public List<String> getOrderedItems() {
        return orderedItems;
    }
}
