// File: Elementalreadyinlist.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: June 19, 2013 
// Revised on: June 19, 2013

package exceptions;

// Class Description 
// This exception is thrown when the element is already in the list

public class ElementAlreadyInListException extends java.lang.Exception 
{  
    // Default constructor
    public ElementAlreadyInListException( ) 
    {
    	
    } // end of constructor
    
    // Parameterized constructor
    public ElementAlreadyInListException(String msg) 
    {
        super( msg );
        
    } // end of constructor

} // end of ElementAlreadyInListException class