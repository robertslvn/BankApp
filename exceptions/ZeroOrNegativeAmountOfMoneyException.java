// File: ZeroofNegativeAmountofMoneyExceptions.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: June 19, 2013 
// Revised on: June 19, 2013

package exceptions;

// Class Description 
//   This exception is thrown when the amount of money to
//   be either deposited or withdrawn is 0.0 or negative

public class ZeroOrNegativeAmountOfMoneyException extends java.lang.Exception 
{  
    // Default constructor
    public ZeroOrNegativeAmountOfMoneyException( ) 
    {
    	// Question: why do we provide an empty default constructor?
    	
    } // end of constructor
    
    // Parameterized constructor
    public ZeroOrNegativeAmountOfMoneyException(String msg) 
    {
        super( msg );
        
    } // end of constructor

} // end of ZeroOrNegativeAmountOfMoneyException class