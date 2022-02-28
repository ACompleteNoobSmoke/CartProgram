public class CartProgram {

    private int cartSize;
    private int cartLimit;
    private double cartTotalPrice;
    private CartModel[] cartItems;

    public CartProgram(int cartLimit){
        this.cartLimit = cartLimit;
        resetCart();
    }

    public double getCartTotalPrice(){
        return cartTotalPrice;
    }

    private void resetCart(){
        this.cartSize = 0;
        this.cartTotalPrice = 0;
        this.cartItems = new CartModel[cartLimit];
    }

    //Check if the quantity in the cart matches the limit
    private boolean isFull(){
        return cartSize == cartLimit;
    }

    //Check if the cart is currently empty
    private boolean isEmpty(){
        return cartSize == 0;
    }

    //Add CartItem object to the array while if the cart is not full
    private boolean addToCart(CartModel newItem){
        String itemName = newItem.getItemName();
        if(!isFull() && searchItemName(itemName) == null){
            cartItems[cartSize++] = newItem;
            cartTotalPrice += newItem.getItemPrice();
            return true;
        }
        return false;
    }

    //Search the array to see if cart item object exists based on the name
    private CartModel searchItemName(String itemName){
        if(!isEmpty()){
            for(int i = 0; i < cartSize; i++){
                if(cartItems[i].getItemName().equalsIgnoreCase(itemName))
                    return cartItems[i];
            }
        }
        return null;
    }

    //Search and update the quantity of an existing cart item.
    //Updating the quantity will thus update the price.
    //If item exists and quantity is 0 then the item will be removed from the cart.
    private CartModel updateQuantityAndPrice(String itemName, int quantity){
        CartModel updateItem = searchItemName(itemName);
        if(updateItem != null){
            if(quantity > updateItem.getQuantity()){
                System.out.println("Before");
                System.out.println(updateItem);
                cartTotalPrice -= updateItem.getItemPrice();
                updateItem.setQuantity(quantity);
                cartTotalPrice += updateItem.getItemPrice();
            }
        }
        return updateItem;
    }

    //Remove an item from the cart based on the item name
    private boolean removeItem(String itemName){
        if(!isEmpty() && searchItemName(itemName) != null){
            CartModel[] newCart = new CartModel[cartLimit];
            for(int i = 0, j = 0; i < cartSize && j < newCart.length; i++){
                if(cartItems[i].getItemName().equalsIgnoreCase(itemName)){
                    cartTotalPrice -= cartItems[i].getItemPrice();
                    continue;
                }
                newCart[j++] = cartItems[i];
            }
            cartItems = newCart;
            cartSize--;

            return true;
        }
        return false;
    }


    public void allItemsTotal(){
       if(isEmpty() || cartTotalPrice == 0) return;
       printAllCart();
       System.out.println("\nTotal: $" + cartTotalPrice);
    }

    //public version of the add functionality that displays a message if
    //item has been added or not
    public void addMessage(CartModel newItem){
        String itemName = newItem.getItemName();
        String addMessage = addToCart(newItem) ?
                itemName + " Was Added To The Cart" :
                itemName + " Was Not Added To The Cart!";
        System.out.println(addMessage);
    }

    //public search functionality to search the array for an item based on the item name.
    //Displays a message whether the item exists or not.
    public void searchMessage(String itemName){
        CartModel foundItem = searchItemName(itemName);
        String searchMessage = (foundItem != null) ?
                foundItem.toString()
                :itemName + " Could Not Be Found";
        System.out.println(searchMessage);
    }

    //public update functionality that searches for an item and update the quantity.
    public void updateMessage(String itemName, int quantity){
        CartModel updatedItem = updateQuantityAndPrice(itemName, quantity);
        if(updatedItem != null && quantity == 0){
           removeMessage(itemName);
           return;
        }else if(updatedItem != null){
            System.out.println("After");
            System.out.println(updatedItem);
            return;
        }
        System.out.println(itemName + " Was Not Updated!");
    }

    //public remove functionality that deletes an item from the array based on the item name
    public void removeMessage(String itemName){
        String message = removeItem(itemName) ?
                itemName + " Has Been Removed From Cart" :
                "Nothing Was Removed From The Cart";
        System.out.println(message);
    }

    //Buy every item in the cart and resets the cart
    public void buyAllItems(){
        System.out.println("Items Have Been Bought");
        resetCart();
    }


    //prints all the content of an array.
    public void printAllCart(){
        if(!isEmpty()){
            for(int i = 0; i < cartSize; i++){
                System.out.println(cartItems[i]);
            }
            return;
        }
        System.out.println("Cart Is Currently Empty!!");
    }

    //print all the content according to the item type
    public void printAllTypeCart(String itemType){
        if(!isEmpty()){
            for(int i = 0; i < cartSize; i++){
                if(cartItems[i].getItemType().equalsIgnoreCase(itemType))
                    System.out.println(cartItems[i]);
            }
            return;
        }
        System.out.println("Cart Is Currently Empty!!");
    }
}
