
import java.io.PrintWriter;

public class OnlineGroceryStack {
     
    private Order top;

    //no-arg consructor
    public OnlineGroceryStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    //method to push in stack
    public void push(int orderID, String customerID, String customerName, String orderTime, String pickupTime, String[] orderItems, String[] quantIties) {
        top = new Order(orderID, customerID, customerName, orderTime, pickupTime, orderItems, quantIties, top);

    }

    //method to print order information that exist in stack
    public void print(PrintWriter output) {
        Order help_ptr = top;
        while (help_ptr != null) {
            System.out.println("");
            output.println("");
            System.out.println("customer ID: " + help_ptr.getCustomerID());
            output.println("customer ID: " + help_ptr.getCustomerID());
            System.out.println("customer name: " + help_ptr.getCustomerName());
            output.println("customer name: " + help_ptr.getCustomerName());
            System.out.println("order time:" + help_ptr.getOrderTime());
            output.println("order time:" + help_ptr.getOrderTime());
            System.out.println("pickup time: " + help_ptr.getPickupTime());
            output.println("pickup time: " + help_ptr.getPickupTime());
            System.out.print("order items: ");
            output.print("order items: ");
            for (int i = 0; i < help_ptr.getOrderItems().length; i++) {
                System.out.print(help_ptr.getOrderItems()[i]);
                output.print(help_ptr.getOrderItems()[i]);
            }
            System.out.println("");
            output.println("");
            System.out.print("quantality: ");
            output.print("quantality: ");
            for (int i = 0; i < help_ptr.getQuantIties().length; i++) {
                System.out.print(help_ptr.getQuantIties()[i]);
                output.print(help_ptr.getQuantIties()[i]);
            }
            System.out.println("");
            output.println("");
            help_ptr = help_ptr.getNext();
        }

    }
}
