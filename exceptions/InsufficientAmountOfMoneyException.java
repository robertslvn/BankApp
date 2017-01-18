// File: InsufficientAmountofMoneyExceptions.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: June 19, 2013 
// Revised on: June 19, 2013

package exceptions;

// Class Description 
//   This exception is thrown when there is insufficient
//   amount of money to carry on an operation such as withdraw

public class InsufficientAmountOfMoneyException extends Exception 
{ 
    // Default constructor
    public InsufficientAmountOfMoneyException( ) 
    {
    } // end of constructor
    
    // Parameterized constructor
    public InsufficientAmountOfMoneyException( String msg )
    {
    	// Question: where is msg stored? Check out Exception class in Java API
        super( msg );
        
    } // end of constructor
    
} // end of InsufficientAmountOfMoneyException class 