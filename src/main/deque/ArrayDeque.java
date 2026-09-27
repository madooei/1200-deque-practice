package deque;

import java.util.NoSuchElementException;

/**
 * An array-backed implementation of the Deque ADT.
 *
 * @param <T> the type of elements in this deque.
 */
public class ArrayDeque<T> implements Deque<T> {

  private T[] arr;    // the backing array, used as a circular array
  private int front;  // the index of the first item
  private int size;   // how many items are in the deque

  // arr only ever holds T, so the cast is safe.
  @SuppressWarnings("unchecked")
  public ArrayDeque() {
    arr = (T[]) new Object[10];  // start with room for 10 items
    front = 0;                   // the front starts at index 0
    size = 0;                    // the deque starts empty
  }

  // Turns an offset from the first end into an index into arr, wrapping
  // around the end of the array.
  private int index(int offset) {
    return (front + offset) % arr.length;
  }

  // Returns the index one slot to the left of i, wrapping from 0 to the last
  // index. We add arr.length before taking the remainder because Java's % can
  // return a negative result: (0 - 1) % arr.length would be -1.
  private int before(int i) {
    return (i + arr.length - 1) % arr.length;
  }

  @Override
  public void addFirst(T item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    if (size == arr.length) {
      grow();  // out of room: make the backing array bigger first
    }
    // grow resets front to 0, so move front only after the possible grow.
    front = before(front);
    arr[front] = item;
    size++;
  }

  @Override
  public void addLast(T item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    if (size == arr.length) {
      grow();  // out of room: make the backing array bigger first
    }
    arr[index(size)] = item;
    size++;
  }

  @Override
  public void removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    arr[front] = null;  // clear the slot so the object can be garbage collected
    front = index(1);
    size--;
  }

  @Override
  public void removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    arr[index(size - 1)] = null;  // clear the slot so the object can be garbage collected
    size--;                       // front stays where it is
  }

  @Override
  public T getFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return arr[front];
  }

  @Override
  public T getLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return arr[index(size - 1)];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  // bigger only ever holds T, so the cast is safe.
  @SuppressWarnings("unchecked")
  private void grow() {
    T[] bigger = (T[]) new Object[arr.length * 2];
    // The items may wrap around the end of the old array, so copy them in
    // deque order rather than slot by slot.
    for (int i = 0; i < size; i++) {
      bigger[i] = arr[index(i)];
    }
    arr = bigger;
    front = 0;  // the items now start at the beginning of the new array
  }
}
