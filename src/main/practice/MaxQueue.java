package practice;

import deque.ArrayDeque;
import deque.Deque;
import java.util.NoSuchElementException;

/** A queue of integers that also reports its largest item. */
public class MaxQueue {

  private Deque<Integer> items;       // the queue order, oldest at the first end
  private Deque<Integer> candidates;  // the items that could still become the maximum

  public MaxQueue() {
    items = new ArrayDeque<>();
    candidates = new ArrayDeque<>();
  }

  // Adds item at the back of the queue.
  public void enqueue(int item) {
    items.addLast(item);
    while (!candidates.isEmpty() && candidates.getLast() < item) {
      candidates.removeLast();
    }
    candidates.addLast(item);
  }

  // Removes the oldest item. Throws NoSuchElementException if the queue is
  // empty.
  public void dequeue() {
    if (items.isEmpty()) {
      throw new NoSuchElementException();
    }
    int item = items.getFirst();
    items.removeFirst();
    if (item == candidates.getFirst()) {
      candidates.removeFirst();
    }
  }

  // Returns the oldest item without removing it. Throws NoSuchElementException
  // if the queue is empty.
  public int front() {
    if (items.isEmpty()) {
      throw new NoSuchElementException();
    }
    return items.getFirst();
  }

  // Returns the largest item without removing it. Throws NoSuchElementException
  // if the queue is empty.
  public int getMax() {
    if (items.isEmpty()) {
      throw new NoSuchElementException();
    }
    return candidates.getFirst();
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }
}
