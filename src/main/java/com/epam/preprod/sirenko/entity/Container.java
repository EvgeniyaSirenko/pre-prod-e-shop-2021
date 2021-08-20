package com.epam.preprod.sirenko.entity;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Resizable array-implementation of the List interface
 *
 * @author E.Sirenko
 *
 **/
public class Container implements List {
	private int size = 10;
	private Object[] array;
	
	public Container() {
	}
	
	public Container(int length) {
		this.array = new Object[length];
	}
	
	/**
	 *
	 * Returns the number of elements
	 **/
	@Override
	public int size() {
		return size;
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
		Object[] temp = array;
		array = new Object[size + 1];
		System.arraycopy(temp, 0, array, 0, size);
		array[array.length - 1] = o;
		size++;
		return true;
	}
	
	/**
	 *
	 * Inserts the specified element at the specified position
	 **/
	@Override
	public void add(int index, Object o) {
		Object[] temp = array;
		array = new Object[size + 1];
		System.arraycopy(temp, 0, array, 0, size);
		array[index] = o;
		size++;
	}
	
	/**
	 *
	 * Returns true if container has no elements
	 **/
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 *
	 * Returns true if container has the specified element
	 **/
	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(o)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Iterator iterator() {
		return null;
	}
	
	@Override
	public Object[] toArray() {
		return null;
	}
	
	@Override
	public boolean remove(Object o) {
		return false;
	}
	
	@Override
	public boolean addAll(Collection c) {
		return false;
	}
	
	@Override
	public boolean addAll(int index, Collection c) {
		return false;
	}
	
	@Override
	public void replaceAll(UnaryOperator operator) {
	
	}
	
	@Override
	public void sort(Comparator c) {
		Arrays.sort(array, 0, size, c);
	}
	
	
	/**
	 *
	 * Returns the element at the specified position
	 **/
	@Override
	public Object get(int index) {
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

	
	@Override
	public Object remove(int index) {
		return null;
	}
	
	@Override
	public int indexOf(Object o) {
		return 0;
	}
	
	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}
	
	@Override
	public Spliterator spliterator() {
		return Spliterators.spliterator(array, Spliterator.ORDERED | Spliterator.IMMUTABLE);
	}
	
	@Override
	public boolean retainAll(Collection c) {
		return false;
	}
	
	@Override
	public boolean removeAll(Collection c) {
		return false;
	}
	
	@Override
	public boolean containsAll(Collection c) {
		return false;
	}
	
	@Override
	public Object[] toArray(Object[] a) {
		return new Object[0];
	}
	
	@Override
	public ListIterator listIterator() {
		//no realisation
		return null;
	}
	
	@Override
	public ListIterator listIterator(int index) {
		//no realisation
		return null;
	}
	
	@Override
	public List subList(int fromIndex, int toIndex) {
		//no realisation
		return null;
	}
}
