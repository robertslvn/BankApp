// File: BankApp.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: June 19, 2013
// Revised on: June 19, 2013

package app;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import dataCollections.MyFlexibleList;
import exceptions.ElementAlreadyInListException;
import exceptions.ElementNotInListException;
import exceptions.EmptyListException;
import exceptions.InsufficientAmountOfMoneyException;
import exceptions.ZeroOrNegativeAmountOfMoneyException;
import interfaces.Listable;

// Class Description: This class models various bank operations.
//                    It allows for customer operations and bank staff operations via menus.
//                    It allows a customer to deposit money, to withdraw money and 
//                    display the balance of an account.
//                    It allows a bank staff to open and close accounts and display all accounts.
//                    Since there were no requirements stating that the accounts needed 
//                    to be kept in a certain sort order, the data collection 
//                    (collection of accounts) is therefore unsorted.

// Class Invariant: none

public class BankApp {
	
	// static constants
	final static Account ACCOUNT_NOT_FOUND = null;
	final static int QUIT = 0;

    // data members	
    private MyFlexibleList accounts;	// data collection -> my list of accounts
    private Scanner theKbd;             // to help us read keyboard input from user

    // method members
	
	// Default constructor
	public BankApp() {
		accounts = new MyFlexibleList();
		theKbd = new Scanner(System.in);
		System.out.println("Welcome to the Bank Application!");

	}
	
    // Getter method
	private MyFlexibleList getAccounts( ) {
		return accounts;
	}
	
/*
 * Menu methods
 */
	/*
	 * Description: Prints the main menu
	*/
	private void mainMenu() {
		System.out.println("\nCustomer operations\t- Enter 1");
		System.out.println("Bank operations\t\t- Enter 2");
		System.out.println("Quit\t\t\t- Enter 0");
		System.out.print("\nYour selection is: ");
		return;
	}

	/*
	 * Description: Prints the customer operations menu
	*/
	 private void customerOperations() {
		System.out.println("\nDeposit money\t- Enter 3");
		System.out.println("Withdraw money\t- Enter 4");
		System.out.println("Display balance\t- Enter 5");
		System.out.println("Previous menu\t- Enter 0" );
		System.out.print("\nYour selection is: ");
		return;
	}

	/*
	 * Description: Prints the bank staff operations menu
	*/
	 private void bankOperations() {
		System.out.println("\nOpen a new account\t  - Enter 6");
		System.out.println("Close an existing account - Enter 7");
		System.out.println("Display all accounts\t  - Enter 8" );
		System.out.println("Previous menu\t\t  - Enter 0" );
		System.out.print("\nYour selection is: ");
		return;
	}
	 
 /*
  * IO methods
  */

 	/*
 	 * Description: Wrapper method that calls readInt( ) since a selection is an int
 	*/
 	private int readSelection() {

 		int userSelection = QUIT;

 		userSelection = this.readInt("");
 		// Echo user selection:
 		System.out.println("Your selection entered is: " + userSelection);
 		return userSelection;
 	}

 	/*
 	 * Description: Reads a String value entered by user and deals with possible exceptions
 	 */
 	private String readString(String userInstruction) {

 		String aString = null;

 		try {
 			System.out.print(userInstruction);
 			aString = theKbd.nextLine();
 		} catch (NoSuchElementException e) {
 			//if no line was found
 			System.out.println("\nNoSuchElementException error occurred (no line was found) " + e);
 		} catch (IllegalStateException e) {
 			// if this scanner is closed
 			System.out.println("\nIllegalStateException error occurred (scanner is closed)" + e);
 		}

 		return aString;
 	}

 	/*
 	 * Description: Reads an int value entered by user and deals with possible exceptions
 	 */
 	private int readInt(String userInstruction) {

 		int anInt = 0;
                boolean valid = false;
                
                while (!valid) {
                
 		try {
 			System.out.print(userInstruction);
 			anInt = theKbd.nextInt();
 			theKbd.nextLine();
                        valid = true;
                        //if the user does not enter a number
 		} catch (InputMismatchException e) {
 			System.out.println("You must enter one of the numbers listed in the menu above.");
                        System.out.println("Please retype your selection: ");
                        theKbd.nextLine();
 		} catch (NoSuchElementException e) {
 			System.out.println("\nNoSuchElementException error occurred (input is exhausted)" + e);
 		} catch (IllegalStateException e) {
 			System.out.println("\nIllegalStateException error occurred (scanner is closed)" + e);
 		}

 		

 	}
                return anInt;
        }

 	/*
 	 * Description: Reads a double value entered by user and deals with possible exceptions
 	 */
 	private double readDouble(String userInstruction) {

 		double aDouble = 0;
                boolean valid = false;

                while (!valid){
 		try {
 			System.out.print(userInstruction);
 			aDouble = theKbd.nextDouble();
 			theKbd.nextLine();
                        valid = true;
 		} catch (InputMismatchException e) {
 			System.out.println("You must enter a valid number");
                        System.out.println("Please retype your selection: ");
                        theKbd.nextLine();
 		} catch (NoSuchElementException e) {
 			System.out.println("\nNoSuchElementException error occurred (input is exhausted)" + e);
 		} catch (IllegalStateException e) {
 			System.out.println("\nIllegalStateException error occurred (scanner is closed)" + e);
 		}
                }
 		return aDouble;

 	}

 	/*
 	 * Description: Reads customer's last and first name from user and
 	 *              create a Person object to represent the customer              
 	 */
 	private Person readAndCreateCustomer() {

 		// Deal with customer's last name
 		String theCustomerLastName = this.readString("\nEnter customer last name: ");
 		// Echo user input:
 		System.out.println("The customer's last name entered is: " + theCustomerLastName);

 		// Deal with customer's first name
 		String theCustomerFirstName = this.readString("\nEnter customer first name: ");
 		// Echo user input:
 		System.out.println("The customer's first name entered is: " + theCustomerFirstName);

 		return new Person(theCustomerFirstName, theCustomerLastName);
 	}

 	/*
 	 * Description: Reads a balance from user and 
 	 *              ensures that the balance is >= 0 (to do)
 	 */
 	private double readBalance() {

 		double theBalance = Account.INITIAL_BALANCE;

 		theBalance = this.readDouble("\nEnter a balance (must be >= 0): ");
 		// Echo user input:
 		System.out.println("The balance entered is: " + theBalance);
 		return theBalance;
 	}

 	/*
 	 * Description: Reads an account ID number from user
 	 */
 	private int readAccountNumber() {

 		int theAccountNumber;
 		
 		theAccountNumber = this.readInt("\nEnter the account ID number: ");
 		// Echo user input:
 		System.out.println("The account ID number entered is: " + theAccountNumber);
 		return theAccountNumber;
 	}
        
/*
 * Methods implementing customer and bank staff functions
 * (incomplete)
 *
 */
 		
	/*
	 * Description: Creates an account object
	*/
 	private void openAccount() throws ElementAlreadyInListException {

		Account anAccount = new Account(this.readAndCreateCustomer(), this.readBalance());
		
		this.getAccounts().insert(anAccount);
		System.out.println("\nAccount created successfully:\n" + anAccount);
		
        return;
	}

	/*
	 * Description: Closes an account object by deleting it
	*/
	private void closeAccount() throws EmptyListException, ElementNotInListException {

		if ((this.getAccounts()).size() <= 0)
			// There are no accounts
			System.out.println("\nThere are no accounts!\n");
		else	{		
		    (this.getAccounts()).delete(new Account(this.readAccountNumber()));
                     }

		return;
	}

	/*
	 * Description: Transforms into a string all the account objects in the data collection
	 * Postcondition: The string containing all the account information is returned
	 */	
	public String toString( )
	{
		String theString = "";
		
		if (this.getAccounts().size( ) <= 0)
			// No accounts to display
			theString += "\nThere are no accounts yet! :-)";
		else 
			theString += "\n" + this.getAccounts();
		
		return theString;
	} // end of toString 
        
       //method called with the user wants to deposit into an existing account
       public void depositAccount() throws EmptyListException, ElementNotInListException, ZeroOrNegativeAmountOfMoneyException {
                //If there are no accounts, method ends after printing out this information 
                if (accounts.size() <= 0 ) {
                     System.out.println("There are no accounts yet!");
                     System.out.println("Returning to main menu.");
                     } 
              else {
        try {
        int theID = this.readInt("Enter your account ID: ");
        Account current = new Account(theID);
        double theDeposit = this.readDouble("Enter the amount to be deposited: ");
        Account caccount = (Account)accounts.retrieve(current);
        caccount.deposit(theDeposit);
        System.out.println("Your new balance is: $" + caccount.theBalance); }
         catch (NullPointerException e) {
         System.out.println("");
         }}
}
      //method called with the user wants to withdraw from an existing account
       public void withdrawAccount() throws EmptyListException, ElementNotInListException, InsufficientAmountOfMoneyException, ZeroOrNegativeAmountOfMoneyException {
                //If there are no accounts, method ends after printing out this information
                if (accounts.size() <= 0 ) {
                     System.out.println("There are no accounts yet!");
                     System.out.println("Returning to main menu.");
                     } 
              else {
        try {
        int theID = this.readInt("Enter your account ID: ");
        double theWithdraw = this.readDouble("Enter the amount to be withdrawn: ");
        Account current = new Account(theID);
        Account caccount = (Account)accounts.retrieve(current);
        caccount.withdraw(theWithdraw);
        System.out.println("Your new balance is: $" + caccount.theBalance); }
        catch (NullPointerException e) {
         System.out.println("");
         }}
}
      //method called with the user wants to see their account balance
       public void balanceOfAccount() throws EmptyListException, ElementNotInListException {
              //If there are no accounts, method ends after printing out this information
              if (accounts.size() <= 0 ) {
                     System.out.println("There are no accounts yet!");
                     System.out.println("Returning to main menu.");
                     } 
              else {
         try {
        int theID = this.readInt("Enter your account ID: ");
        Account current = new Account(theID);
        Account caccount = (Account)accounts.retrieve(current);
        System.out.println("Your current balance is: $" + caccount.theBalance); }
         catch (NullPointerException e) {
         System.out.println("");
         }}
}
	/*
	 * Description: Gets the ball rolling
	 */	
	public static void main(String[] args) throws ElementAlreadyInListException, EmptyListException, ElementNotInListException, ZeroOrNegativeAmountOfMoneyException, InsufficientAmountOfMoneyException {
		
		// Instantiate an object of the BankApp class
		BankApp theBankApp = new BankApp();
		int userSelection = QUIT;

		// Display initial menu
		theBankApp.mainMenu();
		
		// Read in user selection
		userSelection = theBankApp.readSelection();

		// While user has not selected QUIT
		while (userSelection != QUIT) {
			switch (userSelection) {
			// If user selected Customer Operations
			case 1:
				// Display Customer Operations menu
				theBankApp.customerOperations();
				// Read in customer selection
				userSelection = theBankApp.readSelection();

				switch (userSelection) {
				case 3:
				
					// If user has selected "Deposit money into an account"
					// Call the method that deposits money into an account
                                        theBankApp.depositAccount();
                                       
					break;
				case 4:
					// If user has selected "Withdraw money from an account"
					// Call the method that withdraws money from an account
                                        theBankApp.withdrawAccount();
					break;
				case 5:
					// If user has selected "Display balance of an account"
					// Call the method that displays balance of an account
					theBankApp.balanceOfAccount();
					break;
				}

				break;


				// If user has selected Bank Operations
			case 2:
				// Display Bank Operations menu
				theBankApp.bankOperations();
				// Read in banker selection
				userSelection = theBankApp.readSelection();

				switch (userSelection) {
				case 6:
					// If user has selected "Open a new account"
					theBankApp.openAccount();
					break;
				case 7:
					// If user has selected "Close an existing account"
					theBankApp.closeAccount();
					break;
				case 8:
					// If user has selected "Display all accounts"
					System.out.println(theBankApp);
					break;
				}
				break;
			}

			// Display initial menu
			theBankApp.mainMenu();
			// Read in user selection
			userSelection = theBankApp.readSelection();
		}
		// Exit
		System.out.println("Bye!");
	}
} // end of BankApp class