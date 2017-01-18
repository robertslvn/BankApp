/**
 * Filename: MyFlexiblelist.java
 * Author: Robert Silvan
 * SFU ID: 301118114
 * Date of creation: June 13, 2013
 * Revised: June 19, 2013
 * Description: Value-oriented data collection List class (ADT) containing Listable elements.
 * Class invariant: Elements are unsorted and unique (no duplication allowed).
 */

package dataCollections;

import interfaces.*;
import exceptions.*;
import java.util.Scanner;
	
public class MyFlexibleList implements MyListInterface {

	// data members
	private Node theCollection;       // collection of Listable elements - "head"
	private int numberOfElements;     // current number of elements
        private Scanner theKbd = new Scanner(System.in);
	
	// Default constructor
	public MyFlexibleList( )
	{
		theCollection = null;
		numberOfElements = 0;

	} // end default constructor

	// methods members
	public int size( )
	// Description: Returns the number of elements currently stored in the list.
	// Postcondition: Returns 0 if empty otherwise returns the number of elements.
	{
		return numberOfElements;

	} // end of size

	
	public void deleteAll( )
	// Description: Deletes all the elements from the list.
	// Postcondition: List is empty.
	{ 
		numberOfElements = 0;
		theCollection = null;
		    
	} // end of deleteAll
	
	public void insert( Listable element ) throws ElementAlreadyInListException
	// Description: Inserts an element into the list.
	// Precondition: "element" is not already in the list. This is to say: no duplication allowed.
	// Postcondition: "element" has been added to the list.
	// Exception: Throws an ElementAlreadyInListException if "element" is already in the list.
	{	
		Node current = theCollection;
		Node previous = null;
		
		// if the list empty
		if ( numberOfElements <= 0 )
			theCollection = new Node( element, null );			
		else {
			// Verify precondition: If "element" already in list -> throw exception
			while ( current != null ) {
		       if ( current.getElement().compareTo(element) == 0 ) {
                 try {
                    throw new ElementAlreadyInListException( "This element is already in the list." ); }
                catch (ElementAlreadyInListException e){
                System.out.println("This Account ID already exists");
                System.out.println("Returning to main menu.");
                }
	           } else // step forward one Node
				   previous = current;
				   current = current.getNext( );		   
			}

			// Insert the new element at the end of the List
			// Note: element can be inserted anywhere in the List
			previous.setNext(new Node( element, null ));
		}
		
		// and increment the number of elements currently in the data structure by 1.
		numberOfElements++;		

		return;
				
	} // end of insert

	public Listable retrieve( Listable element ) throws EmptyListException, ElementNotInListException	
	// Description: Returns this element.
	// Precondition: List is not empty.
	// Postcondition: If "element" is found in the list, it is returned but not deleted from the list.
	//	              If "element" is not found in the list, an exception is thrown.
	// Exception: Throws an EmptyListException if list is empty.
	// Exception: Throws an ElementNotInListException if "element" is not found in the list.
	{
            Node current = theCollection;
            Node previous = null;
            Listable retrieve = null;
            Boolean success = false;
		
            if ( numberOfElements <= 0 ) {
			
            try {
               throw new EmptyListException( "This list is empty" ); }
               catch (EmptyListException e){
                System.out.println("There are no accounts yet!");
                System.out.println("Returning to main menu.");
                } }
		else {
			// 
			while ( current != null ) {
		       if ( current.getElement().compareTo(element) == 0 ) {
				   retrieve = current.getElement();
                                   success = true;
	           } else // step forward one Node
				   previous = current;
				   current = current.getNext( );		   
			}

		}	
                if (success == false)
                    try {
                    throw new ElementNotInListException("This element is not in the list"); }
                catch (ElementNotInListException e){
                System.out.println("This Account ID does not exist.");
                System.out.println("Returning to main menu.");
                }
                
                            
		return retrieve;
	} // end of retrieve

	
	public void delete( Listable element ) throws EmptyListException, ElementNotInListException
	// Description: Deletes this element from the list.
	// Precondition: List is not empty.
	// Postcondition: If "element" is found in the list, it is deleted from the list. 
	//	               If "element" is not found in the list, an exception is thrown.
	// Exception: Throws an EmptyListException if list is empty.
	// Exception: Throws an ElementNotInListException if "element" is not found in the list.
    {
            Node current = theCollection;
            Node previous = null;
            Listable retrieve = null;
            Boolean success = false;
		
            if ( numberOfElements <= 0 ) {
               try {
               throw new EmptyListException( "This list is empty" ); }
               catch (EmptyListException e){
                System.out.println("There are no accounts yet!");
                System.out.println("Returning to main menu.");
                } }
            
		else {
			// 
			while ( current != null ) {
		       if ( current.getElement().compareTo(element) == 0 ) {
                                   if (previous == null) {
                                   theCollection = theCollection.getNext();
                                   numberOfElements = numberOfElements - 1;
                                   success = true;
                                   }
                                   else {
                                   previous.setNext(current.getNext());
                                   numberOfElements = numberOfElements - 1;
                                   success = true; }
	           } else // step forward one Node
				   previous = current;
				   current = current.getNext( );		   
			}

		}	
             if (success == false) {
               try {
               throw new ElementNotInListException("This element is not in the list"); }
               catch (ElementNotInListException e){
                System.out.println("This Account ID does not exist.");
                System.out.println("Returning to main menu.");
                } }
             else {
                 System.out.println("The account has been deleted!");
             }
                            
	} // end of delete
	
	public String toString( )
	// Description: Outputs all elements.
	// Postcondition: A string containing all elements (their information) is returned.
	{
		Node current = theCollection;
		
		String theString = "";
		if ( numberOfElements <= 0 )
			theString = "\nThere are no elements!";        
		else {
			while ( current != null ) {
				theString += "\n Element => " + current.getElement().toString( );
			    // Go to next node
				current = current.getNext();
			}
		}
		return theString;

	} // end of toString 
	
} // end of MyFlexibleList class

class Node 
{
	// data members
	private Listable element;
	private Node next;

	// constructors
	public Node() {
		this(null, null);
	} // end constructor

	public Node(Listable newElement) {
		this(newElement, null);
	} // end constructor
	
	public Node(Listable newElement, Node nextNode) {
		element = newElement;
		next = nextNode;
	} // end constructor

	// getters
	public Listable getElement() {
		return element;
	} // end getElement

	public Node getNext() {
		return next;
	} // end getNext
	
	// setters
	public void setElement(Listable newElement) {
		element = newElement;
	} // end setElement

	public void setNext(Node nextNode) {
		next = nextNode;
	} // end setNext

}  // end Node