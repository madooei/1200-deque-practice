package deque;

import java.util.NoSuchElementException;

/**
 * A Deque is a collection that supports access at both ends. Items may be
 * added, removed, and inspected at the first end and at the last end: a deque
 * can act like a stack by staying at one end, or like a queue by adding at one
 * end and removing from the other.
 *
 * @param <T> the type of elements in this deque.
 */
public interface Deque<T> {

  /**
   * Adds an item to the first end of this deque.
   *
   * @param item the item to be added to this deque.
   * @throws IllegalArgumentException if the item is null.
   */
  void addFirst(T item);

  /**
   * Adds an item to the last end of this deque.
   *
   * @param item the item to be added to this deque.
   * @throws IllegalArgumentException if the item is null.
   */
  void addLast(T item);

  /**
   * Removes the item at the first end of this deque.
   *
   * @throws NoSuchElementException if this deque is empty.
   */
  void removeFirst();

  /**
   * Removes the item at the last end of this deque.
   *
   * @throws NoSuchElementException if this deque is empty.
   */
  void removeLast();

  /**
   * Returns the item at the first end of this deque without removing it.
   *
   * @return the item at the first end of this deque.
   * @throws NoSuchElementException if this deque is empty.
   */
  T getFirst();

  /**
   * Returns the item at the last end of this deque without removing it.
   *
   * @return the item at the last end of this deque.
   * @throws NoSuchElementException if this deque is empty.
   */
  T getLast();

  /**
   * Returns true if this deque contains no elements.
   *
   * @return true if this deque is empty, false otherwise.
   */
  boolean isEmpty();
}
