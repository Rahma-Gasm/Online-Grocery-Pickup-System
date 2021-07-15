
import java.io.PrintWriter;

public class OnlineGroceryQueue {

    OnlineGroceryStack stack = new OnlineGroceryStack();
    private Order front;
    private Order back;
    private int numOrders;

    public OnlineGroceryQueue() {
        front = null;
        back = null;
        numOrders = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    //method to enqueue in queue
    public void enqueue(Order data) {
        if (isEmpty() == true) {
            front = back = enqueue(front, back, data);
        } else {
            back = enqueue(front, back, data);
        }
    }

    private Order enqueue(Order front, Order back, Order data) {
        if (isEmpty() == true) {
            return data;
        } else {
            back.setNext(data);
            return data;
        }
    }

    //method to print order information that eist in queue
    public void PrintQueue(PrintWriter output) {
        PrintQueue(output, front);
    }

    private void PrintQueue(PrintWriter output, Order front) {
        // We need to traverse...so we need a help ptr
        Order help_ptr = front;
        // Traverse to correct insertion point
        while (help_ptr != null) {
            // Print the data value of the node
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
            // Step one node over
            help_ptr = help_ptr.getNext();

        }

    }

    //this method to print first node that contain first order
    public void PrintFirstNode(PrintWriter output) {
        PrintFirstNode(output, front);
    }

    private void PrintFirstNode(PrintWriter output, Order front) {
        // We need to traverse...so we need a help ptr
        Order help_ptr = front;
        // Traverse to correct insertion point
        if (help_ptr != null) {
            System.out.println("The first order information: ");
            output.println("The first order information: ");
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
        } else {
            System.out.println("");
            output.println("");
            System.out.println("The queue is empty, there is no order to print!!");
            output.println("The queue is empty, there is no order to print!!");
            System.out.println("");
            output.println("");
        }

    }

    // every time we want to dequeue from queue this method will invoked
    public Order dequeue() {
        Order temp = front;
        front = dequeue(front);
        if (front == null) {
            back = null;
        }
        return temp;
    }

    private Order dequeue(Order front) {
        front = front.getNext();
        return front;
    }

    //restock order
    public void restock() {
        Order o = dequeue();
        enqueue(o);
        o.setNext(null);

    }

    //method to print fulfill order
    public void print_fulfill_order(PrintWriter output, Order deq) {
        System.out.println("");
        output.println("");
        System.out.println("customer ID: " + deq.getCustomerID());
        output.println("customer ID: " + deq.getCustomerID());
        System.out.println("customer name: " + deq.getCustomerName());
        output.println("customer name: " + deq.getCustomerName());
        System.out.println("order time:" + deq.getOrderTime());
        output.println("order time:" + deq.getOrderTime());
        System.out.println("pickup time: " + deq.getPickupTime());
        output.println("pickup time: " + deq.getPickupTime());
        System.out.print("order items: ");
        output.print("order items: ");
        for (int i = 0; i < deq.getOrderItems().length; i++) {
            System.out.print(deq.getOrderItems()[i]);
            output.print(deq.getOrderItems()[i]);
        }
        System.out.println("");
        output.println("");
        System.out.print("quantality: ");
        output.print("quantality: ");
        for (int i = 0; i < deq.getQuantIties().length; i++) {
            System.out.print(deq.getQuantIties()[i]);
            output.print(deq.getQuantIties()[i]);
        }
        System.out.println("");
        output.println("");
    }
}
