/**
 *	The SimpleList class is a small program for storing
 *	integers in a list. Methods include adding, 
 *	removing, displaying the list, etc.
 * 
 *  @author  Juan M Chavez Garcia
 *  Class ID: 177
 * 	Assignment #2
 * 	@version 2.0
 * 
 */

package cse360assign2;

import java.util.Arrays;
import java.lang.Math;

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
		// The list is full so increase the array by 50%
		if(count == list.length){
			int newLength = (int) Math.floor(list.length * 1.5);
			
			list = Arrays.copyOf(list, newLength);
		}
		
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
		
		// If the list has more than 25% empty places, then decrease the size of the list by 25% of its size
		double percentOfEmptySpaces = 1.0 - ((double) count / (double)list.length);
		
		if(percentOfEmptySpaces > .25) {
			int newLength = list.length - (int) Math.floor(list.length * .25);
			
			list = Arrays.copyOf(list, newLength);
		}
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
	
	/**
	 * Adds an element to the end of the list
	 * 
	 * @param newElement	The value of the new element to be added
	 */
	public void append(int newElement) {
		// The list is full so increase the array by 50%
		if(count == list.length){
			int newLength = (int) Math.floor(list.length * 1.5);
			
			list = Arrays.copyOf(list, newLength);
		}
		
		count++;
		
		list[count] = newElement;
	}
	
	/**
	 * Returns the first element of the list
	 * 
	 * @return the value of the first element
	 */
	public int first() {
		return list[0];
	}
	
	/**
	 * Returns the size of empty spaces on the array
	 * 
	 * @return the number of possible locations on the list
	 */
	public int size() {
		return list.length - count;
	}
}