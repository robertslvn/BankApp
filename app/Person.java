// File: Person.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: June 19, 2013 
// Revised on: June 19, 2013

package app;

// Class Description 
//   The Person class models a person with a first and last name.
//   Provides getters and setters to access and modify the first and last name of a person.

// Class Invariants:
//   Can you think of a class invariant for this class?

// Questions:
// Can you think of precondition(s) you would add to some/most/all of the methods of this class?
// Why did I not include "postconditions" to the methods of this class?

public class Person
{
	// static constants
    final static String INITIAL_VALUE = "";  // Used to initialize theFirstName and/or
                                             // theLastName when no values are given
    // data members
    private String theFirstName; // the first name (A)
    private String theLastName;  // the last name  (B)
                                 // Since the name of each of these data members is very 
                                 // descriptive, we could skip the comments (A) and (B) 
                                 // describing the data members

    // method members
    
    // Default constructor
    public Person()
    // Description: Initializes theFirstName and theLastName to INITIAL_VALUE
    {
    	this( INITIAL_VALUE, INITIAL_VALUE );
        
    } // end constructor

    // Parameterized constructor
    public Person(String aFirstName, String aLastName)
    // Description: Initializes theFirstName and theLastName using the given parameters
    {
    	setName( aFirstName, aLastName );
         
    } // end constructor
 
    // Getters
    public String getFirstName( )
    // Description: Returns theFirstName
    {
        return theFirstName;
        
    } // end getFirstName

    public String getLastName()
    // Description: Returns theLastName
    {
        return theLastName;
        
    } // end getLastName
    
    // Setter
    public void setName( String aFirstName, String aLastName )
    // Description: Sets theFirstName and theLastName using the given parameters
    {
         theFirstName = aFirstName;
         theLastName = aLastName;
         
    } // end setName

    public String toString( )
    // Description: Returns a string containing the first and last name of this person
    {
    	return( getFirstName( ) + " " + getLastName( ) );

    } // end toString
  
} // end of Person class