public class Item {

    private String name;
    private int stockQuantity;
    private int cartQuantity;

    public Item(String name, int stockQuantity){
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.cartQuantity = 0;
    }

    public void setStockQuantity(int quantity){
        this.stockQuantity = quantity;
    }

    public void setCartQuantity(int quantity){
        this.cartQuantity = quantity;
    }


    
}
