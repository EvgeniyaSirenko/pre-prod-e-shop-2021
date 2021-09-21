package com.epam.preprod.sirenko;

import java.util.*;

/**
 * Resizable array-implementation of the List interface which contains
 * unmodified and modified lists
 *
 * @author E.Sirenko
 **/
public class TwoListWrapper<E> implements List<E> {
	private List<E> unmodifiedList;
	private List<E> modifiedList;
	
	
	public TwoListWrapper(List<E> unmodifiedList, List<E> modifiedList) {
		this.unmodifiedList = unmodifiedList;
		this.modifiedList = modifiedList;
	}
	
	/**
	 * Returns the number of elements in both lists.
	 */
	@Override
	public int size() {
		return unmodifiedList.size() + modifiedList.size();
	}
	
	/**
	 * Returns true if both lists contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return unmodifiedList.isEmpty() && modifiedList.isEmpty();
	}
	
	/**
	 * Returns true if both lists contains the specified element.
	 */
	@Override
	public boolean contains(Object object) {
		return unmodifiedList.contains(object) || modifiedList.contains(object);
	}
	
	/**
	 * Returns an iterator over the elements in both lists in proper sequence.
	 */
	@Override
	public Iterator<E> iterator() {
		return new TwoListIterator<>();
	}
	
	/**
	 * Returns an iterator over the elements in both lists
	 **/
	private class TwoListIterator<E> implements Iterator<E> {
		
		@Override
		public boolean hasNext() {
			return false;
		}
		
		@Override
		public E next() {
			return null;
		}
	}
	
	/**
	 * Returns an array containing all of the elements in both lists in proper
	 * sequence (from first to last element).
	 */
	@Override
	public Object[] toArray() {
		Object[] unmodifiedListObjects = unmodifiedList.toArray();
		Object[] modifiedListObjects = modifiedList.toArray();
		Object[] objects = new Object[unmodifiedListObjects.length + modifiedListObjects.length];
		System.arraycopy(unmodifiedListObjects, 0, objects, 0, unmodifiedListObjects.length);
		System.arraycopy(modifiedListObjects, 0, objects, unmodifiedListObjects.length,
				modifiedListObjects.length);
		return objects;
	}
	
	/**
	 * Returns an array containing all of the elements in both lists in
	 * proper sequence (from first to last element)
	 */
	@Override
	public Object[] toArray(Object[] object) {
		Object[] unmodifiedListObjects = unmodifiedList.toArray();
		Object[] modifiedListObjects = modifiedList.toArray();
		Object[] listObjects = new Object[unmodifiedListObjects.length + modifiedListObjects.length];
		System.arraycopy(unmodifiedListObjects, 0, listObjects, 0, unmodifiedListObjects.length);
		System.arraycopy(modifiedListObjects, 0, listObjects, unmodifiedListObjects.length,
				modifiedListObjects.length);
		
		if (object.length < listObjects.length) {
			return Arrays.copyOf(listObjects, listObjects.length);
		}
		System.arraycopy(listObjects, 0, object, 0, listObjects.length);
		if (object.length > listObjects.length) {
			for (int i = listObjects.length; i < object.length; i++) {
				object[i] = null;
			}
		}
		return object;
	}
	
	/**
	 * Appends the specified element to the end of modified list
	 */
	@Override
	public boolean add(E element) {
		modifiedList.add(element);
		return true;
	}
	
	/**
	 * Removes the first occurrence of the specified element from modified list,
	 * if it is present (optional operation).
	 */
	@Override
	public boolean remove(Object object) {
		if (unmodifiedList.contains(object)) {
			throw new IllegalArgumentException("Can't remove element to unmodified list");
		}
		return modifiedList.remove(object);
	}
	
	/**
	 * Returns true if both lists contains all of the elements of the
	 * specified collection.
	 */
	@Override
	public boolean containsAll(Collection collection) {
		for (Object o : collection) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Appends all of the elements in the specified collection to the end of
	 * modified list, in the order that they are returned by the specified
	 * collection's iterator (optional operation).
	 */
	@Override
	public boolean addAll(Collection collection) {
		modifiedList.addAll(collection);
		return true;
	}
	
	/**
	 * Inserts all of the elements in the specified collection into modified list
	 * at the specified position (optional operation).  Shifts the
	 * element currently at that position (if any) and any subsequent
	 * elements to the right (increases their indices).
	 */
	@Override
	public boolean addAll(int index, Collection collection) {
		if (index < unmodifiedList.size()) {
			throw new IllegalArgumentException("Can't add element to unmodified list");
		} else {
			modifiedList.addAll(index - unmodifiedList.size(), collection);
		}
		return true;
	}
	
	/**
	 * Removes from modified list all of its elements that are contained in the
	 * specified collection (optional operation).
	 */
	@Override
	public boolean removeAll(Collection collection) {
		for (Object o : collection) {
			if (unmodifiedList.contains(o)) {
				throw new IllegalArgumentException("Can't remove collection from unmodified list");
			}
		}
		modifiedList.removeAll(collection);
		return true;
	}
	
	/**
	 * Retains only the elements in modified list that are contained in the
	 * specified collection (optional operation).  In other words, removes
	 * from this list all of its elements that are not contained in the
	 * specified collection.
	 */
	@Override
	public boolean retainAll(Collection collection) {
		if (!collection.containsAll(unmodifiedList)) {
			throw new IllegalArgumentException("Can't retain collection of unmodified list");
		} else {
			modifiedList.retainAll(collection);
		}
		return true;
	}
	
	/**
	 * Removes all of the elements from modified list.
	 */
	@Override
	public void clear() {
		modifiedList.clear();
	}
	
	/**
	 * Returns the element at the specified position in this list.
	 */
	@Override
	public E get(int index) {
		if (index < unmodifiedList.size()) {
			return unmodifiedList.get(index);
		}
		return modifiedList.get(index - unmodifiedList.size());
	}
	
	/**
	 * Replaces the element at the specified position in modified list with the
	 * specified element (optional operation).
	 */
	@Override
	public E set(int index, E element) {
		if (index < unmodifiedList.size()) {
			throw new IllegalArgumentException("Can't set element to unmodified list");
		} else {
			modifiedList.set(index - unmodifiedList.size(), element);
		}
		return modifiedList.get(index - unmodifiedList.size());
	}
	
	/**
	 * Inserts the specified element at the specified position in modified list
	 * (optional operation).  Shifts the element currently at that position
	 * (if any) and any subsequent elements to the right (adds one to their
	 * indices).
	 */
	@Override
	public void add(int index, E element) {
		if (index < unmodifiedList.size()) {
			throw new IllegalArgumentException("Can't add element to unmodified list");
		} else {
			modifiedList.add(index - unmodifiedList.size(), element);
		}
	}
	
	/**
	 * Removes the element at the specified position in modified list.
	 * Shifts any subsequent elements to the left (subtracts one
	 * from their indices).  Returns the element that was removed from the
	 * list.
	 */
	@Override
	public E remove(int index) {
		E toRemove;
		if (index < unmodifiedList.size()) {
			throw new IllegalArgumentException("Can't remove element to unmodified list");
		} else {
			toRemove = modifiedList.get(index - unmodifiedList.size());
			modifiedList.remove(index - unmodifiedList.size());
		}
		return toRemove;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 */
	@Override
	public int indexOf(Object object) {
		if (unmodifiedList.contains(object)) {
			return unmodifiedList.indexOf(object);
		}
		return modifiedList.indexOf(object) + unmodifiedList.size();
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 */
	@Override
	public int lastIndexOf(Object object) {
		if (unmodifiedList.contains(object)) {
			return unmodifiedList.lastIndexOf(object);
		}
		return modifiedList.lastIndexOf(object) + unmodifiedList.size();
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