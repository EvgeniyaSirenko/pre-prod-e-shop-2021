package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;

import java.math.BigDecimal;
import java.util.*;

/**
 * Resizable array-implementation of the List interface
 *
 * @author E.Sirenko
 **/
public class Container<E extends Product> implements List<E> {
	private int size;
	private int currentCapacity = 10;
	private Object[] array;
	
	/**
	 * Constructs an empty list with capacity of ten.
	 **/
	public Container() {
		this.array = new Object[]{};
	}
	
	/**
	 * Constructs an empty list with the specified initial capacity.
	 **/
	public Container(int initCapacity) {
		if (initCapacity > 0) {
			this.array = new Object[initCapacity];
		} else if (initCapacity == 0) {
			new Container();
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " +
					initCapacity);
		}
	}
	
	/**
	 * Returns the number of elements
	 **/
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Removes all the elements
	 **/
	@Override
	public void clear() {
		size = 0;
	}
	
	/**
	 * Appends the specified element to the end of the container
	 **/
	@Override
	public boolean add(E element) {
		capacityCheckAndResizeIfNeeded(size + 1);
		array[size++] = element;
		return true;
	}
	
	/**
	 * Inserts the specified element at the specified position
	 **/
	@Override
	public void add(int index, E element) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		capacityCheckAndResizeIfNeeded(size + 1);
		array[index] = element;
		size++;
	}
	
	/**
	 * Increases the capacity of this ArrayList instance, if necessary
	 **/
	private void capacityCheckAndResizeIfNeeded(int newCapacity) {
		if (size == 0) {
			array = new Object[currentCapacity];
		} else if (newCapacity - currentCapacity > 0) {
			array = Arrays.copyOf(array, newCapacity);
		}
	}
	
	
	/**
	 * Returns true if container has no elements
	 **/
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns true if container has the specified element
	 **/
	@Override
	public boolean contains(Object object) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(object)) {
				return true;
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
		return array.clone();
	}
	
	/**
	 * Returns an array containing all of the elements in this list
	 **/
	@Override
	public Object[] toArray(Object[] object) {
		int length = size();
		if (object.length < length) {
			return Arrays.copyOf(array, length);
		}
		System.arraycopy(array, 0, object, 0, length);
		if (object.length > length) {
			object[length] = null;
		}
		return object;
	}
	
	/**
	 * Returns the element at the specified position
	 **/
	@Override
	public E get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return (E) array[index];
	}
	
	/**
	 * Replaces the object at the specified position
	 **/
	@Override
	public E set(int index, E element) {
		array[index] = element;
		return (E) array[index];
	}
	
	/**
	 * Removes the element at the specified position in this list
	 **/
	@Override
	public E remove(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		E toRemove = (E) array[index];
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(array, index + 1, array, index,
					numMoved);
		}
		array[--size] = null;
		return toRemove;
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
					removeByIdx(i);
					return true;
				}
		} else {
			for (int i = 0; i < array.length; i++)
				if (array[i].equals(object)) {
					removeByIdx(i);
					return true;
				}
		}
		return false;
	}
	
	private void removeByIdx(int index) {
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(array, index + 1, array, index,
					numMoved);
		}
		array[--size] = null;
	}
	
	/**
	 * Appends all of the elements in the specified collection to the end of this list
	 **/
	@Override
	public boolean addAll(Collection collection) {
		Object[] obj = collection.toArray();
		int objLength = obj.length;
		capacityCheckAndResizeIfNeeded(size + objLength);
		System.arraycopy(obj, 0, array, size, objLength);
		size = size + objLength;
		return objLength != 0;
	}
	
	/**
	 * Inserts all of the elements in the specified collection into this list, starting at the specified position
	 **/
	@Override
	public boolean addAll(int index, Collection collection) {
		Object[] obj = collection.toArray();
		int objLength = obj.length;
		capacityCheckAndResizeIfNeeded(size + objLength);
		
		int numMoved = size - index;
		if (numMoved > 0) {
			System.arraycopy(array, index, array, index + objLength,
					numMoved);
		}
		System.arraycopy(obj, 0, array, index, objLength);
		size = size + objLength;
		return objLength != 0;
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
		int i = 0;
		int k = 0;
		try {
			for (; i < size; i++) {
				if (collection.contains(array[i])) {
					array[k++] = array[i];
				}
			}
		} finally {
			if (i != size) {
				System.arraycopy(array, i, array, k, size - i);
				k = k + size - i;
			}
			if (k != size) {
				for (int j = k; j < size; j++) {
					array[j] = null;
					size = k;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Removes from this list all of its elements that are contained in the
	 * specified collection
	 **/
	@Override
	public boolean removeAll(Collection collection) {
		int i = 0;
		int k = 0;
		try {
			for (; i < size; i++) {
				if (collection.contains(array[i]) == false) {
					array[k++] = array[i];
				}
			}
		} finally {
			if (i != size) {
				System.arraycopy(array, i, array, k, size - i);
				k = k + size - i;
			}
			if (k != size) {
				for (int j = k; j < size; j++) {
					array[j] = null;
					size = k;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns true if this list contains all of the elements of the specified collection
	 **/
	@Override
	public boolean containsAll(Collection collection) {
		for (int i = 0; i < size; i++) {
			if (collection.contains(array[i])) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns an iterator over the elements in this list in proper sequence
	 **/
	@Override
	public Iterator<E> iterator() {
		return new IteratorOnCondition<>(this);
	}
	
	private class IteratorOnCondition<T extends Product> implements Iterator<T> {
		private int index = 0;
		
		public IteratorOnCondition(Container<T> container) {
		}
		
		@Override
		public boolean hasNext() {
			Clothing condition = new Clothing();
			condition.setSeason(Season.WINTER);
			condition.setSize(Size.S);
			condition.setName("jacket");
			condition.setPrice(BigDecimal.valueOf(200));
			for (int i = 0; i < size; i++) {
				if (!array[index].equals(condition)) { //nullPointer
					index++;
				}
			}
			return true;
		}
		
		@Override
		public T next() {
			if (index >= size)
				throw new NoSuchElementException();
			return (T) array[index++]; //index check
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