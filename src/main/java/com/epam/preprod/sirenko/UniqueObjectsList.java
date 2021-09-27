package com.epam.preprod.sirenko;

import java.util.ArrayList;
import java.util.Collection;

public class UniqueObjectsList extends ArrayList<Object> {
	private static final String MESSAGE_CANT_ADD_ELEMENT = "Can't add such element";
	private static final String MESSAGE_CANT_ADD_ELEMENTS = "Can't add such elements";
	
	/**
	 * Appends the specified element to the end of the container
	 **/
	@Override
	public boolean add(Object object) {
		if (contains(object)) {
			throw new IllegalArgumentException(MESSAGE_CANT_ADD_ELEMENT);
		}
		return super.add(object);
	}
	
	/**
	 * Inserts the specified element at the specified position in this
	 * list. Shifts the element to the right
	 */
	@Override
	public void add(int index, Object object) {
		if (contains(object)) {
			throw new IllegalArgumentException(MESSAGE_CANT_ADD_ELEMENT);
		}
		super.add(index, object);
	}
	
	/**
	 * Replaces the element at the specified position in this list with
	 * the specified element
	 */
	@Override
	public Object set(int index, Object object) {
		if (contains(object)) {
			throw new IllegalArgumentException(MESSAGE_CANT_ADD_ELEMENT);
		}
		return super.set(index, object);
	}
	
	/**
	 * Appends all of the elements in the specified collection to the end of
	 * this list
	 */
	@Override
	public boolean addAll(Collection collection) {
		if (containsAll(collection)) {
			throw new IllegalArgumentException(MESSAGE_CANT_ADD_ELEMENTS);
		}
		return super.addAll(collection);
	}
	
	/**
	 * Inserts all of the elements in the specified collection into this
	 * list, starting at the specified position.  Shifts the element
	 * to the right (increases their indices).
	 */
	@Override
	public boolean addAll(int index, Collection collection) {
		if (containsAll(collection)) {
			throw new IllegalArgumentException(MESSAGE_CANT_ADD_ELEMENTS);
		}
		return super.addAll(index, collection);
	}
}