// File: elementnotinlistexception.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: June 19, 2013 
// Revised on: June 19, 2013

package exceptions;

// Class Description 
//   This exception is thrown when the element isnt in the list

public class ElementNotInListException extends java.lang.Exception 
{  
    // Default constructor
    public ElementNotInListException( ) 
    {
    	
    } // end of constructor
    
    // Parameterized constructor
    public ElementNotInListException(String msg) 
    {
        super( msg );
        
    } // end of constructor

} // end of ElementNotInListException class