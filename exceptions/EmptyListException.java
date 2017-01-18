// File: EmptyListException.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: June 19, 2013 
// Revised on: June 19, 2013
package exceptions;

// Class Description 
//   This exception is thrown when the list is empty

public class EmptyListException extends Exception 
{ 
    // Default constructor
    public EmptyListException( ) 
    {
    } // end of constructor
    
    // Parameterized constructor
    public EmptyListException( String msg )
    {
        super( msg );
        
    } // end of constructor
    
} // end of EmptyListException class 