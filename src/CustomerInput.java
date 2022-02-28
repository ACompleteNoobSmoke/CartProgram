import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerInput {

    private Scanner scan = new Scanner(System.in); //Scanner to allow user input

    //An array of menu titles.
    private String[] menuOptions = {"Add Item",
        "Search Item","Update Item", "Remove Item", "Print All Items", "Buy", "Close Program"};

    //******* SCANNER INPUTS(Start) *******//

    private int getInt(){
        int newInt;
        try{
            newInt = scan.nextInt();
        }catch (InputMismatchException e){
            newInt = -1;
        }
        scan.nextLine();
        return newInt;
    }

    private double getDouble(){
        double newDouble = 0;
        try{
            newDouble = scan.nextDouble();
        }catch (InputMismatchException e){
            newDouble = -1;
        }
        scan.nextLine();
        return newDouble;
    }

    public void closeScanner(){
        scan.close();
    }

    //******* SCANNER INPUTS(End) *******//


    //******* PROMPT INPUTS(Start) *******//

    //Main menu display for the user to make a choice.
    public int mainMenu(double totalPrice){
        int option = 0;
        while(option <= 0 || option > menuOptions.length){
            System.out.println("\n**** MAIN MENU ****");
            System.out.println("Current Cart Total: $" + totalPrice);
            int i = 1;
            for(String choice: menuOptions){
                System.out.println(i++ + ". " + choice);
            }
            System.out.print("\nPick Choice(1 - 7): ");
            option = getInt();
        }
        return option;
    }

    //Prompt to get item name from the user
    public String getItemName(){
        String itemName = "";
        while(itemName.isBlank()){
            System.out.print("Please Enter Item Name: ");
            itemName = scan.nextLine();
        }
        return itemName;
    }

    //Prompt to get item type from the user
    public String getItemType(){
        String itemType = "";
        while(itemType.isBlank()){
            System.out.print("Please Enter Item Type: ");
            itemType = scan.nextLine();
        }
        return itemType;
    }

    //Prompt to get item quantity from the user
    public int getItemQuantity(){
        int itemQuantity = -1;
        while(itemQuantity < 0 || itemQuantity >=20){
            System.out.print("Please Enter Quantity: ");
            itemQuantity = getInt();
        }
        return itemQuantity;
    }

    //Prompt to get item price from the user
    public double getItemPrice(){
        double itemPrice = 0;
        while(itemPrice <= 0 || itemPrice >= 70){
            System.out.print("Please Enter Item Price: $");
            itemPrice = getDouble();
        }
        return itemPrice;
    }

    //Prompt to get cart limit from the user
    public int getCartLimit(){
        int cartLimit = 0;
        while(cartLimit <= 0 || cartLimit >= 10){
            System.out.print("Enter Cart Limit: ");
            cartLimit = getInt();
        }
        return cartLimit;
    }

    //Prompt user for print option
    public int getPrintOption(){
        int printChoice = 0;
        while(printChoice <= 0 || printChoice > 3){
            System.out.println("**** Print Options ****");
            System.out.println("1. Print All Items");
            System.out.println("2. Print Items Based On Type");
            System.out.println("3. Back");
            System.out.print("\nAction(1-3): ");
            printChoice = getInt();
        }
        return printChoice;
    }

    public int buyOptions(){
        int buyChoice = 0;
        while(buyChoice <= 0 || buyChoice > 2){
            System.out.println("1. Buy All Items");
            System.out.println("2. Back");
            System.out.print("\nAction(1 - 2): ");
            buyChoice = getInt();
        }
        return buyChoice;
    }

    //******* PROMPT INPUTS(End) *******//
}
