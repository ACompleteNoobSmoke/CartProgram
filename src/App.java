public class App {

    private CartProgram cart;
    private CustomerInput input;
    private double cartTotal;


    public App(){
        this.input = new CustomerInput();
        initializeCart();
    }

    public void appProgram(){
        int option = 0;
        while(option != 7){
            cartTotal = cart.getCartTotalPrice();
            option = input.mainMenu(cartTotal);
            switch (option){
                case 1: addItem(); break;
                case 2: searchItem(); break;
                case 3: updateItem(); break;
                case 4: deleteItem(); break;
                case 5: printItem(); break;
                case 6: buyAllItems(); break;
                case 7: closeApp(); break;
            }
        }
    }

    private void initializeCart(){
        int limit = input.getCartLimit();
        this.cartTotal = 0;
        this.cart = new CartProgram(limit);
    }

    private void addItem(){
        System.out.println("\n**** ADD NEW ITEM ****");
        String itemName = input.getItemName();
        String itemType = input.getItemType();
        double itemPrice = input.getItemPrice();
        CartModel newItem = new CartModel(itemName, itemType, itemPrice, 1);
        cart.addMessage(newItem);
    }

    private void searchItem(){
        System.out.println("\n***** SEARCH ITEM ****");
        String itemName = input.getItemName();
        cart.searchMessage(itemName);
    }

    private void updateItem(){
        System.out.println("\n***** UPDATE ITEM ****");
        String itemName = input.getItemName();
        int itemQuantity = input.getItemQuantity();
        cart.updateMessage(itemName, itemQuantity);
    }

    private void deleteItem(){
        System.out.println("\n***** DELETE ITEM ****");
        String itemName = input.getItemName();
        cart.removeMessage(itemName);
    }

    private void printItem(){
        int printChoice = input.getPrintOption();
        if(printChoice == 1){
            printAllItem();
        }else if(printChoice == 2){
            System.out.println("\n");
            String itemType = input.getItemType();
            printTypeItems(itemType);
        }
    }

    private void printAllItem(){
        System.out.println("\n***** PRINT ALL ITEMS *****");
        cart.printAllCart();
    }

    private void printTypeItems(String itemType){
        System.out.println("\n***** PRINT " + itemType.toUpperCase()
                + " ITEMS *****");
        cart.printAllTypeCart(itemType);
    }

    private void buyAllItems(){
        System.out.println("\n***** BUY ITEMS *****");
        if(cartTotal > 0){
            cart.allItemsTotal();
            int choice = input.buyOptions();
            if(choice == 1)
                cart.buyAllItems();
            return;
        }
        System.out.println("Cart Is Currently Empty!\n" +
                "Going Back To Main Menu\n");
    }

    private void closeApp(){
        System.out.println("\nExiting Cart Program...");
        input.closeScanner();
        System.exit(0);
    }

    public static void main(String[] args){
        App newApp = new App();
        newApp.appProgram();
    }

}
