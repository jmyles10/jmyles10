import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

public class Receipt {
    private String customerName;
    private double subtotal;
    private double tax;
    private double tip;
    private double total;
    private String deliveryDriverName;
    private Date date;
    private List<String> orderedItems;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Receipt(String customerName, double subtotal, double tax, double tip, double total, String deliveryDriverName, Date date, List<String> orderedItems) {
        this.customerName = customerName;
        this.subtotal = subtotal;
        this.tax = tax;
        this.tip = tip;
        this.total = total;
        this.deliveryDriverName = deliveryDriverName;
        this.date = date;
        this.orderedItems = orderedItems;
    }

    public void printReceipt() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Date: " + date);
        System.out.println("Ordered Items:");
        for (String item : orderedItems) {
            System.out.println("1. " + item);
        }
        System.out.println("Subtotal: $" + df.format(subtotal));
        System.out.println("Tax (6%): $" + df.format(tax));
        System.out.println("Tip: $" + df.format(tip));
        System.out.println("Total amount: $" + df.format(total));
        System.out.println("___________________________________________________________");

        System.out.println("Thank you for your order! It'll be ready soon.");
        System.out.println("Your deliverer's name is: " + deliveryDriverName);
    }
}