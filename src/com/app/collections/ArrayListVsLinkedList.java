package com.app.collections;

public class ArrayListVsLinkedList {

	public static void main(String[] args) {
		/*==========Performance Comparison===========
		 * 1)Comparing get()
		 *  Accessing element from ArrayList  Time complexity is O(1)
		 *  Accessing element from LinkedList Time complexity is O(N),fetching the first or the last element is O(1)
		 *  
		 * 2)Comparing insert()
		 *  Inserting element into ArrayList  Time complexity is O(N), O(1) only if added at the end
		 *  Inserting element into LinkedList Time complexity is O(N), O(1) both for insertion at the beginning and at the end
		 * 
		 * 3)Comparing remove()
		 *  ArrayLists will remove elements in O(1) if they're at the end - O(N) in all other cases.
		 * 	LinkedLists have O(1) complexity for removing from the beginning or end, and O(N) in other cases.
		 * 
		 * 4)Internal implementation
		 *  ArrayList  Internally uses Dynamic Array to store elements
		 *  LinkedList Internally uses Doubly Linked List to store elements
		 *  
		 * 5)Implementations
		 *  ArrayList  implements only List interface
		 *  LinkedList implements List and Queue
		 */
	}
}
