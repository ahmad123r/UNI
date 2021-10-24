package ven;


import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        VendingMachineInterface machineInterface = new TextVendingMachineInterface();

        machineInterface.displayProducts();

        String selectedProduct = scanner.nextLine();
        machineInterface.selectProduct(Integer.parseInt(selectedProduct));

        machineInterface.displayEnterCoinsMessage();

        String userEnteredCoins = scanner.nextLine();
        int[] enteredCoins = Coin.parseCoins(userEnteredCoins);
        machineInterface.enterCoins(enteredCoins);
        
        String userEnteredNotes = scanner.nextLine();
        int[] enteredNotes = Coin.parseCoins(userEnteredNotes);
        machineInterface.enterCoins(enteredNotes);

        machineInterface.displayChangeMessage();

    }
}
