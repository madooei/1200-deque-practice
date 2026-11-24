package demo;

import practice.MaxQueue;

/** A demo of MaxQueue on the sequence of operations from the notes. */
public final class MaxQueueDemo {

  private MaxQueueDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    MaxQueue queue = new MaxQueue();

    // Enqueue 7, 2, 5, 1, 4. Expect getMax to stay 7 the whole time.
    int[] items = {7, 2, 5, 1, 4};
    for (int item : items) {
      queue.enqueue(item);
      System.out.println("enqueue(" + item + "), getMax: " + queue.getMax());
    }

    // Dequeue three times. Expect getMax to give 5, 5, and then 4.
    for (int i = 0; i < 3; i++) {
      queue.dequeue();
      System.out.println("dequeue(), front: " + queue.front() + ", getMax: " + queue.getMax());
    }
  }
}
