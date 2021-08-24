package com.epam.preprod.sirenko.db.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Resizable array-implementation of the List interface
 *
 * @author E.Sirenko
 *
 **/
public class Container implements List {
	private int size;
	private static final int CAPACITY = 10;
	private Object[] array;
	private static final Object[] EMPTY_CAPACITY = {};
	
	
	/**
	 *
	 * Constructs an empty list with capacity of ten.
	 **/
	public Container() {
		this.array = EMPTY_CAPACITY;
	}
	
	
	/**
	 *
	 * Constructs an empty list with the specified initial capacity.
	 **/
	public Container(int initCapacity) {
		if (initCapacity > 0) {
			this.array = new Object[initCapacity];
		} else if (initCapacity == 0) {
			this.array = new Object[]{};
		} else {
			throw new IllegalArgumentException("Illegal Capacity: "+
					initCapacity);
		}
	}
	
	/**
	 *
	 * Returns the number of elements
	 **/
	@Override
	public int size() {
		return array.length;
	}
	
	/**
	 *
	 * Removes all the elements
	 **/
	@Override
	public void clear() {
		for (int i = 0; i < size; i++)
			array[i] = null;
		size = 0;
	}
	
	/**
	 *
	 * Appends the specified element to the end of the container
	 **/
	@Override
	public boolean add(Object o) {
		capacityCheck(size + 1);
		array[array.length + 1] = o;
		return true;
	}
	
	/**
	 *
	 * Inserts the specified element at the specified position
	 **/
	@Override
	public void add(int index, Object o) {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		capacityCheck(size + 1);
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = o;
		size++;
	}
	
	/**
	 *
	 * Increases the capacity of this ArrayList instance, if necessary
	 **/
	private void capacityCheck(int newCapacity) {
		int minCapacity = (array != EMPTY_CAPACITY) ? 0 : CAPACITY;
		if (newCapacity > minCapacity) {
			if (newCapacity - array.length > 0) {
				array = Arrays.copyOf(array, newCapacity);
			}
		}
	}
	
	/**
	 *
	 * Returns true if container has no elements
	 **/
	@Override
	public boolean isEmpty() {
		return array.length == 0;
	}
	
	/**
	 *
	 * Returns true if container has the specified element
	 **/
	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(o)) {
				return true;
			}
		}
		return false;
		//return indexOf(o) != -1; <-- as another option
	}
	
	/**
	 *
	 * Returns an array containing all of the elements in this container
	 * in proper sequence (from first to last element).
	 **/
	@Override
	public Object[] toArray() {
		return array.clone();
	}
	
	/**
	 *
	 * Returns an array containing all of the elements in this list
	 **/
	@Override
	public Object[] toArray(Object[] a) {
		int size = size();
		if (a.length < size)
			return Arrays.copyOf(array, size);
		System.arraycopy(array, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
		return a;
	}
	
	/**
	 *
	 * Returns the element at the specified position
	 **/
	@Override
	public Object get(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		return array[index];
	}
	
	/**
	 *
	 * Replaces the element at the specified position
	 **/
	@Override
	public Object set(int index, Object element) {
		array[index] = element;
		return array[index];
	}
	
	/**
	 *
	 * Removes the element at the specified position in this list
	 **/
	@Override
	public Object remove(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		
		Object toRemove = array[index];
		
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(array, index + 1, array, index,
					numMoved);
		array[--size] = null;
		
		return toRemove;
	}
	
	/**
	 *
	 * Removes the first occurrence of the specified element from this list, if it is present.
	 * If the list does not contain the element, it is unchanged
	 **/
	@Override
	public boolean remove(Object o) {
		if (o == null) {
			for (int i = 0; i < array.length; i++)
				if (array[i] == null) {
					removeByIdx(i);
					return true;
				}
		} else {
			for (int i = 0; i < array.length; i++)
				if (array[i].equals(o)) {
					removeByIdx(i);
					return true;
				}
		}
		return false;
	}
	
	private void removeByIdx(int i) {
		int numMoved = size - i - 1;
		if (numMoved > 0)
			System.arraycopy(array, i + 1, array, i,
					numMoved);
		array[--size] = null;
	}
	
	/**
	 *
	 * Appends all of the elements in the specified collection to the end of this list
	 **/
	@Override
	public boolean addAll(Collection c) {
		Object[] obj = c.toArray();
		int objLength = obj.length;
		capacityCheck(size + objLength);
		System.arraycopy(obj, 0, array, size, objLength);
		size = size + objLength;
		return objLength != 0;
	}
	
	/**
	 *
	 * Inserts all of the elements in the specified collection into this list, starting at the specified position
	 **/
	@Override
	public boolean addAll(int index, Collection c) {
		Object[] obj = c.toArray();
		int objLength = obj.length;
		capacityCheck(size + objLength);
		
		int numMoved = size - index;
		if (numMoved > 0)
			System.arraycopy(array, index, array, index + objLength,
					numMoved);
		
		System.arraycopy(obj, 0, array, index, objLength);
		size = size + objLength;
		return objLength != 0;
	}
	
	/**
	 *
	 * Returns the index of the first occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element
	 **/
	@Override
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < array.length; i++)
				if (array[i] == null)
					return i;
		} else {
			for (int i = 0; i < array.length; i++)
				if (array[i].equals(o))
					return i;
		}
		return -1;
	}
	
	/**
	 *
	 * Returns the index of the last occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element
	 **/
	@Override
	public int lastIndexOf(Object o) {
		if (o == null) {
			for ( int i = array.length - 1; i >= 0; i--) {
				if (array[i] == null)
					return i;
			}
		} else {
			for (int i = array.length -1; i >= 0; i --) {
				if(array[i].equals(o))
					return i;
			}
		}
		return -1;
	}
	
	//batchRemove analog needed?
	
	@Override
	public boolean retainAll(Collection c) {
		return false;
	}
	
	@Override
	public boolean removeAll(Collection c) {
		return true;
	}
	
	/**
	 *
	 * Returns true if this list contains all of the elements of the specified collection
	 **/
	@Override
	public boolean containsAll(Collection c) {
		Object[] obj = c.toArray();
		int objLength = obj.length;
		for (int i = 0; i < objLength; i++) {
			for (int j = 0; j < size; j++) {
				if (array[i].equals(obj[j])) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public Iterator iterator() {
		return null;
	}
	
	@Override
	public ListIterator listIterator() {
		//no realisation needed
		return null;
	}
	
	@Override
	public ListIterator listIterator(int index) {
		//no realisation needed
		return null;
	}
	
	@Override
	public List subList(int fromIndex, int toIndex) {
		//no realisation needed
		return null;
	}
}
