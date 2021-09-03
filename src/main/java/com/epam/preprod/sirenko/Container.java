package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;

import java.util.*;
import java.util.function.Predicate;

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
			new Container<E>();
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
		for (int i = 0; i < size; i++) {
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
		int oldIndex = 0;
		int newIndex = 0;
		Boolean modified = false;
			for (; oldIndex < size; oldIndex++) {
				if (collection.contains(array[oldIndex])) {
					array[newIndex++] = array[oldIndex];
				}
			}
			if (newIndex != size) {
				for (int j = newIndex; j < size; j++) {
					array[j] = null;
					size = newIndex;
					modified = true;
				}
			}
		return modified;
	}
	
	/**
	 * Removes from this list all of its elements that are contained in the
	 * specified collection
	 **/
	@Override
	public boolean removeAll(Collection collection) {
		int oldIndex = 0;
		int newIndex = 0;
		Boolean modified = false;
		for (; oldIndex < size; oldIndex++) {
				if (!collection.contains(array[oldIndex])) {
					array[newIndex++] = array[oldIndex];
				}
			}
			if (newIndex != size) {
				for (int j = newIndex; j < size; j++) {
					array[j] = null;
					size = newIndex;
					modified = true;
				}
			}
		return modified;
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
		return new Iter<>();
	}
	
	/**
	 * Returns an iterator over the elements in this list on condition
	 **/
	public Iterator<E> iterator(Predicate<Product> predicate) {
		return new IteratorOnCondition<>(predicate);
	}
	
	private class Iter<T extends Product> implements Iterator<T> {
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			return index != size;
		}
		
		@Override
		public T next() {
			if (index >= size) {
				throw new NoSuchElementException();
			}
			return (T) array[index++];
		}
	}
	
	private class IteratorOnCondition<T extends Product> implements Iterator<T> {
		private int index = 0;
		Predicate<Product> predicate;
		
		public IteratorOnCondition(Predicate<Product> predicate) {
			this.predicate = predicate;
		}
		
		@Override
		public boolean hasNext() {
			for (; index < size; index++) {
				T element = (T) array[index];
				if (predicate.test(element)) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public T next() {
			while (index < size) {
				T element = (T) array[index++];
				if (predicate.test(element)) {
					return element;
				}
			}
			throw new NoSuchElementException();
		}
	}
	
	public static void main(String[] args) {
		DryFood dryFood = new DryFood();
		Clothing clothing = new Clothing();
		Food food = new Food();
		Container<Product> container = new Container<>();
		container.add(dryFood);
		container.add(clothing);
		container.add(food);
		container.add(clothing);
		container.add(clothing);
		container.add(dryFood);
		container.add(food);
		Container<Product> container1 = new Container<>();
		container1.add(dryFood);
		container1.add(dryFood);
//		Predicate<Product> isClothing = x -> x.equals(clothing);
		Iterator<Product> iterator = container.iterator();
		System.out.println(container.retainAll(container1));
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
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