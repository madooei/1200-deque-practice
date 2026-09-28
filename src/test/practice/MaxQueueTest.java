package practice;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/** Unit tests for MaxQueue. */
public class MaxQueueTest {

  private MaxQueue queue;

  @BeforeEach
  public void setup() {
    queue = new MaxQueue();
  }

  @Test
  public void newQueueIsEmpty() {
    assertTrue(queue.isEmpty());
  }

  @Test
  public void dequeueOnEmptyQueueThrows() {
    try {
      queue.dequeue();
      fail("expected NoSuchElementException when dequeuing an empty queue");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void frontOnEmptyQueueThrows() {
    try {
      queue.front();
      fail("expected NoSuchElementException when calling front on an empty queue");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void maxOnEmptyQueueThrows() {
    try {
      queue.getMax();
      fail("expected NoSuchElementException when calling getMax on an empty queue");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void enqueueMakesQueueNonEmpty() {
    queue.enqueue(4);
    assertFalse(queue.isEmpty());
  }

  @Test
  public void frontReturnsTheOnlyItem() {
    queue.enqueue(4);
    assertEquals(4, queue.front());
  }

  @Test
  public void maxOfSingleItem() {
    queue.enqueue(4);
    assertEquals(4, queue.getMax());
  }

  @Test
  public void frontReturnsTheOldestItem() {
    queue.enqueue(4);
    queue.enqueue(7);
    assertEquals(4, queue.front());
  }

  @Test
  public void enqueuingALargerItemBecomesTheMaximum() {
    queue.enqueue(4);
    queue.enqueue(7);
    assertEquals(7, queue.getMax());
  }

  @Test
  public void enqueuingASmallerItemKeepsTheMaximum() {
    queue.enqueue(4);
    queue.enqueue(1);
    assertEquals(4, queue.getMax());
  }

  @Test
  public void dequeueRevealsTheNextItem() {
    queue.enqueue(4);
    queue.enqueue(7);
    queue.dequeue();
    assertEquals(7, queue.front());
  }

  @Test
  public void dequeuingANonMaximumKeepsTheMaximum() {
    queue.enqueue(4);
    queue.enqueue(1);
    queue.enqueue(7);
    queue.dequeue();
    assertEquals(7, queue.getMax());
  }

  @Test
  public void dequeuingTheMaximumRecoversTheNextMaximum() {
    queue.enqueue(7);
    queue.enqueue(3);
    queue.dequeue();
    assertEquals(3, queue.getMax());
  }

  @Test
  public void dequeuingTheMaximumOfSeveralItemsRecoversTheNextMaximum() {
    queue.enqueue(7);
    queue.enqueue(2);
    queue.enqueue(5);
    queue.enqueue(1);
    queue.enqueue(4);
    queue.dequeue();
    assertEquals(5, queue.getMax());
  }

  @Test
  public void dequeuingOneOfTwoEqualMaximaKeepsTheOther() {
    queue.enqueue(5);
    queue.enqueue(5);
    queue.enqueue(2);
    queue.dequeue();
    assertEquals(5, queue.getMax());
  }

  @Test
  public void dequeuingBothEqualMaximaRecoversTheNextMaximum() {
    queue.enqueue(5);
    queue.enqueue(5);
    queue.enqueue(2);
    queue.dequeue();
    queue.dequeue();
    assertEquals(2, queue.getMax());
  }

  @Test
  public void dequeuingEveryItemLeavesQueueEmpty() {
    queue.enqueue(4);
    queue.enqueue(7);
    queue.dequeue();
    queue.dequeue();
    assertTrue(queue.isEmpty());
  }
}
