/**
 *	The SimpleList class is a small program for storing
 *	up to 10 integers in a list. Methods include adding, 
 *	removing, and displaying the list.
 * 
 *  @author  Juan M Chavez Garcia
 *  Class ID: 177
 * 	Assignment #1
 * 	@version 1.0
 * 
 */

package cse360assign2;

public class SimpleList 
{
	private int list[];
	private int count;
	
	/**
	 * 	Initializes the attributes
	 */
	public SimpleList() 
	{
		count = 0;
		list = new int[10];
	}
	
	/**
	 * 	Adds a new element to the beginning of the list.
	 * 
	 * 	@param newElement	The value of the new element to be added
	 */
	public void add(int newElement) 
	{
		if(count < 10)
			count++;
		
		// Shifts previous elements to the right
		for(int size = (count-1); size > 0; size--) 
		{
			list[size] = list[size-1];
		}
		
		list[0] = newElement;
	}
	
	/**
	 * Remove an element from the list if it exists
	 * 
	 * @param element	The number to be removed from the list
	 */
	public void remove(int element) 
	{
		// Shifts items in the list left to replace removed element
		for(int index = search(element); (index != -1 && index < (count-1)); index++) 
		{
			list[index]=list[index+1];
		}
		
		count--;
	}
	
	/**
	 *  Returns the size of the list
	 *  
	 * 	@return	The number of elements in the list
	 */
	public int count() 
	{
		return count;
	}
	
	/**
	 *  Returns the elements in the list separated by a space
	 */
	public String toString() 
	{
		String text = "";
		
		for(int index = 0; index < count; index++) 
		{
			if(index < (count-1))
				text += list[index] + " ";
			else
				text += list[index];
		}
			
		return text;
	}
	
	/**
	 * Returns the index of an element in the list
	 * 
	 * @param element	The number we are looking for in the list
	 * @return			The location of the number in the list
	 */
	public int search(int element) 
	{
		int indexFound = -1;
		
		for(int index = 0; (index < count && indexFound==-1); index++) 
		{
			if(list[index] == element)
				indexFound = index;
		}
		
		return indexFound;
	}
}