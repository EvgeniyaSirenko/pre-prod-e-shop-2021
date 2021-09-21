package com.epam.preprod.sirenko;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TwoListWrapper<E> implements List<E>{
	private List<E> unmodifiedList;
	private List<E> modifiedList;
	
	
	public TwoListWrapper(List<E> unmodifiedList, List<E> modifiedList) {
		this.unmodifiedList = unmodifiedList;
		this.modifiedList = modifiedList;
	}
	
	/**
	 * Returns the number of elements in this list.
	 */
	@Override
	public int size() {
		return unmodifiedList.size() + modifiedList.size();
	}
	
	/**
	 * Returns true if this list contains no elements.
	 *
	 */
	@Override
	public boolean isEmpty() {
		return unmodifiedList.isEmpty() && modifiedList.isEmpty();
	}
	
	/**
	 * Returns true if this list contains the specified element.
	 */
	@Override
	public boolean contains(Object o) {
		return false;
	}
	
	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 *
	 */
	@Override
	public Iterator<E> iterator() {
		return null;
	}
	
	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element).
	 */
	@Override
	public Object[] toArray() {
		return new Object[0];
	}
	
	/**
	 * Returns an array containing all of the elements in this list in
	 * proper sequence (from first to last element)
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}
	
	/**
	 * Appends the specified element to the end of this list
	 */
	@Override
	public boolean add(E e) {
		return false;
	}
	
	/**
	 * Removes the first occurrence of the specified element from this list,
	 * if it is present (optional operation).
	 */
	@Override
	public boolean remove(Object o) {
		return false;
	}
	
	/**
	 * Returns true if this list contains all of the elements of the
	 * specified collection.
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}
	
	/**
	 * Appends all of the elements in the specified collection to the end of
	 * this list, in the order that they are returned by the specified
	 * collection's iterator (optional operation).
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}
	
	/**
	 * Inserts all of the elements in the specified collection into this
	 * list at the specified position (optional operation).  Shifts the
	 * element currently at that position (if any) and any subsequent
	 * elements to the right (increases their indices).  The new elements
	 * will appear in this list in the order that they are returned by the
	 * specified collection's iterator.
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}
	
	/**
	 * Removes from this list all of its elements that are contained in the
	 * specified collection (optional operation).
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}
	
	/**
	 * Retains only the elements in this list that are contained in the
	 * specified collection (optional operation).  In other words, removes
	 * from this list all of its elements that are not contained in the
	 * specified collection.
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}
	
	/**
	 * Removes all of the elements from this list (optional operation).
	 * The list will be empty after this call returns.
	 */
	@Override
	public void clear() {
	
	}
	
	/**
	 * Returns the element at the specified position in this list.
	 */
	@Override
	public E get(int index) {
		return null;
	}
	
	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element (optional operation).
	 */
	@Override
	public E set(int index, E element) {
		return null;
	}
	
	/**
	 * Inserts the specified element at the specified position in this list
	 * (optional operation).  Shifts the element currently at that position
	 * (if any) and any subsequent elements to the right (adds one to their
	 * indices).
	 */
	@Override
	public void add(int index, E element) {
	
	}
	
	/**
	 * Removes the element at the specified position in this list (optional
	 * operation).  Shifts any subsequent elements to the left (subtracts one
	 * from their indices).  Returns the element that was removed from the
	 * list.
	 */
	@Override
	public E remove(int index) {
		return null;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 */
	@Override
	public int indexOf(Object o) {
		return 0;
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 */
	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}
	
	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
}
