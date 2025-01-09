package ATMProject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

//OptionMenu class extends Account class, acts as the user interface layer for the ATM. It contains logic for logging in and navigating account-related options
public class OptionMenu extends Account {

    //Attributes: menuInput - A Scanner object to handle user input
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");

    //Attribute: data - A HashMap to simulate a database of customer numbers and PINs
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    //Method getLogin(): prompt user for custmer number and PIN, checks it against the data map
    public void getLogin() throws IOException {
        int x = 1;
        do{
            try{
                data.put(952141, 191904);
                data.put(989947, 71976);

                System.out.println("Welcome to the ATM Project!");
                System.out.println("Enter your customer Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());
            }catch(Exception e){
                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                x = 2;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();

            if(data.containsKey(cn) && data.get(cn) == pn){
                getAccountType();

            }else
                System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");

        }while (x == 1);
    }

    //Method getAccountType(): provide user with optison of two accounts types
    public void getAccountType(){
        System.out.println("Select the Account you Want to Access: ");
        System.out.println("Type 1 = Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch(selection){
            case 1: 
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using this ATM, bye. \n");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
        }
    }

    //Method getChecking() and getSaving(): present user with specific options (view balance, deposit and withdraw)
    public void getChecking(){
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch(selection){
            case 1: 
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getChecking();
        }
    }
    
    public void getSaving(){
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch(selection){
            case 1: 
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
                
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3: 
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM. bye.");

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getSaving();
        }
    }
}
