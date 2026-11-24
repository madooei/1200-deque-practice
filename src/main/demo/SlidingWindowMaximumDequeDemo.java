package demo;

import java.util.Arrays;
import practice.SlidingWindowMaximumDeque;

/** A demo of SlidingWindowMaximumDeque on the running example from the notes. */
public final class SlidingWindowMaximumDequeDemo {

  private SlidingWindowMaximumDequeDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int[] values = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    System.out.println("values: " + Arrays.toString(values) + ", k = " + k);

    // Six windows of three values each. Expect [3, 3, 5, 5, 6, 7].
    int[] maximums = SlidingWindowMaximumDeque.slidingMaximum(values, k);
    System.out.println("window maximums: " + Arrays.toString(maximums));
  }
}
