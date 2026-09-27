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
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Removes the oldest item. Throws NoSuchElementException if the queue is
  // empty.
  public void dequeue() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns the oldest item without removing it. Throws NoSuchElementException
  // if the queue is empty.
  public int front() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns the largest item without removing it. Throws NoSuchElementException
  // if the queue is empty.
  public int max() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public boolean isEmpty() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
