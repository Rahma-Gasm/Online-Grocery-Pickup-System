
/* Title: Online Grocery Pickup System */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class OnlineOrderMenu {
    
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter("Output.txt");//create object from printWriter to print in file
        OnlineGroceryQueue queue = new OnlineGroceryQueue();//create object from (OnlineGroceryQueue) class to can invoke method from it
        OnlineGroceryStack stack = new OnlineGroceryStack();// create object from (OnlineGroceryStack) class to can invoke method from it
        int choice;//define variable (choice )
        int order_id = 0;//initialize variable (order_id) and it will increment every time user make order
        int num_order_in_queue = 0;//initialize variable (num_order_in_queue) and it will increment every time order enqueue in queue
        int num_order_in_stack = 0;//initialize variable (num_order_in_stack) and it will increment every time order pushed in stack
        String cus_id = "", cus_name = "", order_time = "", pickup_time = "", item[] = null, quantality[] = null;
        do {
            showMenu(output);//invoke method to show menu
            choice = input.nextInt();//ask user to enter his/her choice
            output.print(choice);
            if (choice == 1) {//check if the user enter one this condition is excuted
                System.out.println("");
                output.println("\n");
                //ask user to enter his/her infomation from id, name, order time, pickup time, order items, quantality.
                System.out.println("Please enter the order information: ");
                output.println("Please enter the order information: ");
                System.out.println("");
                output.println("");
                System.out.print("customer ID: ");
                output.print("customer ID: ");
                cus_id = input.next();
                output.println(cus_id);
                System.out.print("customer name: ");
                output.print("customer name: ");
                cus_name = input.next();
                output.println(cus_name);
                System.out.print("order time: ");
                output.print("order time: ");
                order_time = input.next();
                output.println(order_time);
                //from the user input I replace colon with nothing to can compare order time with pickup time
                String order_time2 = order_time.replace(":", "");
                System.out.print("pickup time: ");
                output.print("pickup time: ");
                pickup_time = input.next();
                output.println(pickup_time);
                String pick_up_time = pickup_time.replace(":", "");
                System.out.print("order items: ");
                output.print("order items: ");
                input.nextLine();
                item = input.nextLine().split("");
                // for loop to print item in file 
                for (int i = 0; i < item.length; i++) {
                    output.print(item[i]);
                }
                System.out.print("quantality: ");
                output.print("\nquantality: ");
                quantality = input.nextLine().split("");
                // for loop to print quantality in file 
                for (int i = 0; i < quantality.length; i++) {
                    output.print(quantality[i]);
                }
                // after replace colon above we substract pickup time with order time to compare them to each other
                int time = (Integer.parseInt(pick_up_time) - Integer.parseInt(order_time2));
                /* if time after substract equal 200 its same meaning (2:00) then excute these instruction
                 another word if difference between order time and pick up time equal or greater than  two hour excute these order  */
                if (time == 200 || time > 200) {
                    //add new order 
                    Order new_order = new Order(order_id++, cus_id, cus_name, order_time, pickup_time, item, quantality, null);
                    queue.enqueue(new_order);//enqueue order 
                    num_order_in_queue++;//every time we enqueue new order this varible will increment (we will need this variable) below
                    System.out.println("");
                    output.println("\n");
                    System.out.println("The order is added!");
                    output.println("The order is added!");
                    System.out.println("");
                    output.println("");
                    //if difference between order time and pick up time less than 2 hour print message
                } else if (Integer.parseInt(pick_up_time) < Integer.parseInt(order_time2)) {
                    System.out.println("");
                    output.println("\n");
                    System.out.println("The system doesn’t allow next day pickup.");
                    output.println("The system doesn’t allow next day pickup.");
                    System.out.println("");
                    output.println("");
                } else {//else will excute in another case example when user put pick up time in next day it not allowed by system 
                    System.out.println("");
                    output.println("\n");
                    System.out.println("Can’t add the order because the order pick-up time less than 2 hours!!!");
                    output.println("Can’t add the order because the order pick-up time less than 2 hours!!!");
                    System.out.println("");
                    output.println("");
                }

            } else if (choice == 2) {
                //invoke method from (OnlineGroceryQueue) class to print first node than enqueued
                queue.PrintFirstNode(output);
                System.out.println("");
                output.println("");
                
            } else if (choice == 3) {
                // in this choice there are two selection
                output.println("\n");
                System.out.println("");
                System.out.println("Please select your option: ");
                output.println("Please select your option: ");
                System.out.println("     1. Fulfill one order ");
                output.println("     1. Fulfill one order ");
                System.out.println("     2. Fulfill multiple orders");
                output.println("     2. Fulfill multiple orders");
                int choice2 = input.nextInt();
                output.print(choice2);
                if (choice2 == 1) { //if the user choice 1
                    output.println("");
                    queue.PrintFirstNode(output);//it will print first node
                    Order ord = queue.dequeue();//dequeue first node from queue
                    //push node that we dequeue above in stack
                    stack.push(order_id++, ord.getCustomerID(), ord.getCustomerName(), ord.getOrderTime(), ord.getPickupTime(), ord.getOrderItems(), ord.getQuantIties());
                    num_order_in_stack++;//increment every time user push new order in stack
                    System.out.println("");
                    output.println("\n");
                    System.out.println("The order is fulfilled! ");
                    output.println("The order is fulfilled! ");
                    System.out.println("");
                    output.println("");

                } else if (choice2 == 2) {
                    System.out.print("Please enter the number of orders that you would like to fulfill: ");
                    output.print("\nPlease enter the number of orders that you would like to fulfill: ");
                    int num = input.nextInt();
                    output.print(num);
                    output.println("");
                    for (int i = 0; i < num; i++) {
                        Order deq = queue.dequeue();//dequeue nodes from queue as per user input
                        //invoke method from OnlineGroceryQueue to print orders that fulfill
                        queue.print_fulfill_order(output, deq);
                        //push node that we dequeue above in stack
                        stack.push(order_id++, deq.getCustomerID(), deq.getCustomerName(), deq.getOrderTime(), deq.getPickupTime(), deq.getOrderItems(), deq.getQuantIties());
                        num_order_in_stack++;//increment every time user push new order in stack
                    }
                    System.out.println("");
                    output.println("");
                    System.out.println("The orders above are fulfilled!! ");
                    output.println("The orders above are fulfilled!! ");
                    System.out.println("");
                    output.println("");

                } else {//this message will print if user enter another choice 
                    System.out.println("This choice doesn't exist. ");
                    output.println("This choice doesn't exist.");
                    System.out.println("");
                    output.println("");
                }

            } else if (choice == 4) {//This selection will allow the store to restock the orders
                System.out.println("");
                output.println("");
                System.out.println("All waiting orders: ");
                output.println("");
                output.println("All waiting orders: ");
                queue.PrintQueue(output);
                output.println("");
                System.out.println("");
                System.out.print("Please enter the number of orders to restock: ");
                output.print("Please enter the number of orders to restock: ");
                int number_order = input.nextInt();
                output.println(number_order);
                //here before restock order check If the number is less than or equal the number of queue elements and then it will restock
                if (number_order <= num_order_in_queue) {
                    for (int i = 0; i < number_order; i++) {
                        queue.restock();

                    }
                    queue.PrintQueue(output);
                    System.out.println("");
                    output.println("");
                    System.out.println("The order(s) restocked successfully!");
                    output.println("The order(s) restocked successfully!");
                    System.out.println("");
                    output.println("");

                } else {//if user enter number greater than number of queue elements this message will print
                    System.out.println("Can’t restock the orders, the number of orders is less than your input!!! ");
                    output.println("Can’t restock the orders, the number of orders is less than your input!!! ");
                }

                /*This selection allow to print the orders that are waiting to be fulfilled first from the queue. 
                 In addition, this method  print out the fulfilled orders from the stack.*/
            } else if (choice == 5) {
                System.out.println("");
                System.out.println("Orders did not fulfill yet: ");
                output.println("\n");
                output.println("Orders did not fulfill yet: ");
                System.out.println("");
                output.println("");
                System.out.println("The orders information:");
                output.println("The orders information:");
                queue.PrintQueue(output);//print the orders that are waiting to be fulfilled first from the queue
                System.out.println("");
                output.println("");
                if (num_order_in_stack > 0) {//check if the stack is not empty and there is an element
                    System.out.println("--------------------------------");
                    output.println("--------------------------------");
                    System.out.println("Already Fulfilled orders: ");
                    output.println("Already Fulfilled orders: ");
                    System.out.println("");
                    output.println("");
                    System.out.println("The orders information: ");
                    output.println("The orders information: ");
                    stack.print(output);//print out the fulfilled orders from the stack
                    System.out.println("");
                    output.println("");
                } else {
                    System.out.println("Stack is empty!!");
                    output.println("Stack is empty!!");
                    System.out.println("");
                    output.println("");
                }
            } else if (choice == 6) {//if user enter 6 it exit user from system
                System.out.println("");
                output.println("\n");
                System.out.println(" >    Goodbye!");
                output.println(" >    Goodbye!");

            } else {//if user enter choice not from (1-6) this message will print
                System.out.println("");
                output.println("\n");
                System.out.println(" >    Wrong selection. Try again.");
                output.println(" >    Wrong selection. Try again.");
                System.out.println("");
                output.println("");
            }

        } while (choice != 6);

        output.flush();
        output.close();
    }

    //this method print menu
    public static void showMenu(PrintWriter output) {
        System.out.println("-----------------------------------------------");
        output.println("-----------------------------------------------");
        System.out.println("---------    Online grocery store    ----------");
        output.println("------------      Online grocery store     ------------");
        System.out.println("-----------------------------------------------");
        output.println("-----------------------------------------------");
        System.out.println("   1. Add a new order                          ");
        output.println("   1. Add a new order                          ");
        System.out.println("   2. Lookup the first order                   ");
        output.println("   2. Lookup the first order                   ");
        System.out.println("   3. Fulfill order                            ");
        output.println("   3. Fulfill order                            ");
        System.out.println("   4. Restock orders                           ");
        output.println("   4. Restock orders                           ");
        System.out.println("   5. Print orders                             ");
        output.println("   5. Print orders                             ");
        System.out.println("   6. Exit                                     ");
        output.println("   6. Exit                                     ");
        System.out.println("-----------------------------------------------");
        output.println("-----------------------------------------------");
        System.out.println("");
        output.println("");
        System.out.print(" > Please enter your choice: ");
        output.print(" > Please enter your choice: ");

    }
}
