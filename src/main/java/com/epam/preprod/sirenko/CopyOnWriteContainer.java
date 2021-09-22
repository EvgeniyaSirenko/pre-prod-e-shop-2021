package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Product;

import java.util.*;

/**
 * Resizable array-implementation of the List interface
 *
 * @author E.Sirenko
 **/
public class CopyOnWriteContainer<E extends Product> implements List<E> {
	private Object[] array;
	private static final String EXCEPTION_INFO_INDEX = "Index: ";
	private static final String EXCEPTION_INFO_SIZE = ", Size: ";
	
	/**
	 * Constructs an empty list with capacity of ten.
	 **/
	public CopyOnWriteContainer() {
		this.array = new Object[]{};
	}
	
	/**
	 * Returns the number of elements
	 **/
	@Override
	public int size() {
		return array.length;
	}
	
	/**
	 * Removes all the elements
	 **/
	@Override
	public void clear() {
		array = new Object[]{};
	}
	
	/**
	 * Appends the specified element to the end of the container
	 **/
	@Override
	public boolean add(E element) {
		Object[] objects = Arrays.copyOf(array, array.length + 1);
		objects[array.length] = element;
		array = objects;
		return true;
	}
	
	/**
	 * Inserts the specified element at the specified position
	 **/
	@Override
	public void add(int index, E element) {
		indexToSizeCheck(index);
		int numMoved = array.length - index;
		Object[] objects = Arrays.copyOf(array, array.length + 1);
		System.arraycopy(objects, index, objects, index + 1, numMoved);
		objects[index] = element;
		array = objects;
	}
	
	/**
	 * Returns true if container has no elements
	 **/
	@Override
	public boolean isEmpty() {
		return array.length == 0;
	}
	
	/**
	 * Returns true if container has the specified element
	 **/
	@Override
	public boolean contains(Object object) {
		if (object == null) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					return true;
				}
			}
		} else {
			for (int i = 0; i < array.length; i++) {
				if (array[i] != null && array[i].equals(object)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns an array containing all of the elements in this container
	 * in proper sequence (from first to last element).
	 **/
	@Override
	public Object[] toArray() {
		return Arrays.copyOf(array, array.length);
	}
	
	/**
	 * Returns an array containing all of the elements in this list
	 **/
	@Override
	public Object[] toArray(Object[] object) {
		if (object.length < array.length) {
			return Arrays.copyOf(array, array.length);
		}
		System.arraycopy(array, 0, object, 0, array.length);
		if (object.length > array.length) {
			for (int i = array.length; i < object.length; i++) {
				object[i] = null;
			}
		}
		return object;
	}
	
	/**
	 * Returns the element at the specified position
	 **/
	@Override
	public E get(int index) {
		indexToSizeCheck(index);
		return (E) array[index];
	}
	
	/**
	 * Replaces the object at the specified position
	 **/
	@Override
	public E set(int index, E element) {
		indexToSizeCheck(index);
		Object[] objects = Arrays.copyOf(array, array.length + 1);
		objects[index] = element;
		array = objects;
		return (E) array[index];
	}
	
	/**
	 * Removes the element at the specified position in this list
	 **/
	@Override
	public E remove(int index) {
		indexToSizeCheck(index);
		Object[] objects = Arrays.copyOf(array, array.length);
		E toRemove = (E) objects[index];
		int numMoved = objects.length - index - 1;
		if (numMoved == 0) {
			objects = Arrays.copyOf(objects, objects.length - 1);
			array = objects;
		} else {
			Object[] newObjects = new Object[objects.length - 1];
			System.arraycopy(objects, 0, newObjects, 0, index);
			System.arraycopy(objects, index + 1, newObjects, index, numMoved);
			array = newObjects;
		}
		return toRemove;
	}
	
	public void indexToSizeCheck(int index) {
		if (index >= array.length || index < 0) {
			throw new IndexOutOfBoundsException(EXCEPTION_INFO_INDEX + index + EXCEPTION_INFO_SIZE + array.length);
		}
	}
	
	/**
	 * Removes the first occurrence of the specified element from this list, if it is present.
	 * If the list does not contain the element, it is unchanged
	 **/
	@Override
	public boolean remove(Object object) {
		if (object == null) {
			for (int i = 0; i < array.length; i++)
				if (array[i] == null) {
					remove(i);
					return true;
				}
		} else {
			for (int i = 0; i < array.length; i++)
				if (array[i].equals(object)) {
					remove(i);
					return true;
				}
		}
		return false;
	}
	
	/**
	 * Appends all of the elements in the specified collection to the end of this list
	 **/
	@Override
	public boolean addAll(Collection collection) {
		Object[] objects = array;
		Object[] objectsToAdd = collection.toArray();
		int objectsToAddLength = objectsToAdd.length;
		if (objects.length == 0) {
			objects = objectsToAdd;
			array = objects;
		} else {
			Object[] newObjects = Arrays.copyOf(objects, objects.length + objectsToAddLength);
			System.arraycopy(objectsToAdd, 0, newObjects, objects.length, objectsToAddLength);
			array = newObjects;
		}
		return objectsToAddLength != 0;
	}
	
	/**
	 * Inserts all of the elements in the specified collection into this list,
	 * starting at the specified position
	 **/
	@Override
	public boolean addAll(int index, Collection collection) {
		indexToSizeCheck(index);
		Object[] objects = array;
		Object[] objectsToAdd = collection.toArray();
		int objectsToAddLength = objectsToAdd.length;
		int numMoved = objects.length - index;
		Object[] newObjects;
		if (numMoved == 0) {
			newObjects = Arrays.copyOf(objects, objects.length + objectsToAddLength);
		} else {
			newObjects = new Object[objects.length + objectsToAddLength];
			System.arraycopy(objects, 0, newObjects, 0, index);
			System.arraycopy(objects, index, newObjects, index + objectsToAddLength, numMoved);
		}
		System.arraycopy(objectsToAdd, 0, newObjects, index, objectsToAddLength);
		array = newObjects;
		
		return objectsToAddLength != 0;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element
	 **/
	@Override
	public int indexOf(Object object) {
		if (object == null) {
			for (int i = 0; i < array.length; i++)
				if (array[i] == null)
					return i;
		} else {
			for (int i = 0; i < array.length; i++)
				if (array[i].equals(object)) {
					return i;
				}
		}
		return -1;
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element
	 **/
	@Override
	public int lastIndexOf(Object object) {
		if (object == null) {
			for (int i = array.length - 1; i >= 0; i--) {
				if (array[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = array.length - 1; i >= 0; i--) {
				if (array[i].equals(object)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * Removes from this list all of its elements that are not contained in the
	 * specified collection
	 **/
	@Override
	public boolean retainAll(Collection collection) {
		Object[] objects = array;
		int objectsLength = objects.length;
		int newIndex = 0;
		boolean modified = false;
		for (int oldIndex = 0; oldIndex < objectsLength; oldIndex++) {
			if (collection.contains(objects[oldIndex])) {
				objects[newIndex++] = objects[oldIndex];
				modified = true;
			}
		}
		if (newIndex != objectsLength) {
			for (int j = newIndex; j < objectsLength; j++) {
				objects[j] = null;
				modified = true;
				
			}
		}
		Object[] newObjects = Arrays.copyOf(objects, newIndex);
		System.arraycopy(objects, 0, newObjects, 0, newIndex);
		array = newObjects;
		return modified;
	}
	
	/**
	 * Removes from this list all of its elements that are contained in the
	 * specified collection
	 **/
	@Override
	public boolean removeAll(Collection collection) {
		Object[] objects = array;
		int objectsLength = objects.length;
		int newIndex = 0;
		boolean modified = false;
		for (int oldIndex = 0; oldIndex < objectsLength; oldIndex++) {
			if (!collection.contains(objects[oldIndex])) {
				objects[newIndex++] = objects[oldIndex];
			} else {
				modified = true;
			}
		}
		if (newIndex != objectsLength) {
			for (int j = newIndex; j < objectsLength; j++) {
				objects[j] = null;
				modified = true;
			}
		}
		Object[] newObjects = Arrays.copyOf(objects, newIndex);
		System.arraycopy(objects, 0, newObjects, 0, newIndex);
		array = newObjects;
		return modified;
	}
	
	/**
	 * Returns true if this list contains all of the elements of the specified collection
	 **/
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
	 * Returns an iterator over the elements in copy of this container in proper sequence
	 **/
	@Override
	public Iterator<E> iterator() {
		return new CopyOnWriteIterator<>(array, 0);
	}
	
	/**
	 * Iterates elements in this container in proper sequence
	 **/
	private class CopyOnWriteIterator<T extends Product> implements Iterator<T> {
		private int index;
		private final Object[] arrayCopy;
		
		public CopyOnWriteIterator(Object[] objects, int index) {
			this.arrayCopy = objects;
			this.index = index;
		}
		
		@Override
		public boolean hasNext() {
			return index != arrayCopy.length;
		}
		
		@Override
		public T next() {
			if (index >= arrayCopy.length) {
				throw new NoSuchElementException();
			}
			return (T) arrayCopy[index++];
		}
	}
	
	@Override
	public ListIterator listIterator() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public ListIterator listIterator(int index) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public List subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
}