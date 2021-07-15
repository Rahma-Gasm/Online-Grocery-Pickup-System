
public class Order {
    
    private int orderID;
    private String customerName;
    private String customerID;
    private String orderTime;
    private String[] orderItems;
    private String[] quantIties;
    private String pickupTime;
    private Order next;

    public Order() {
        orderID = 0;
        customerName = null;
        customerID = null;
        orderTime = null;
        orderItems = null;
        quantIties = null;
        pickupTime = null;
        next = null;
    }

    public Order(int orderID, String customerID, String customerName, String orderTime, String pickupTime, String[] orderItems, String[] quantIties, Order next) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.customerID = customerID;
        this.orderTime = orderTime;
        this.orderItems = orderItems;
        this.quantIties = quantIties;
        this.pickupTime = pickupTime;
        this.next = next;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(String[] orderItems) {
        this.orderItems = orderItems;
    }

    public String[] getQuantIties() {
        return quantIties;
    }

    public void setQuantIties(String[] quantIties) {
        this.quantIties = quantIties;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Order getNext() {
        return next;
    }

    public void setNext(Order next) {
        this.next = next;
    }

}
