public class CartModel {

    private String itemName;
    private String itemType;
    private double itemPrice;
    private int quantity;

    public CartModel(String itemName, String itemType, double itemPrice, int quantity) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void updateItemPrice(){
        this.itemPrice *= quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateItemPrice();
    }

    @Override
    public String toString(){
        return "Name: " + itemName + "\n" +
                "Type: " + itemType + "\n" +
                "Quantity: " + quantity + "\n" +
                "Price: $" + itemPrice + "\n";
    }
}
