package demo;

import java.util.Arrays;
import practice.SlidingWindowMaximumBruteForce;

/** A demo of SlidingWindowMaximumBruteForce on the running example from the notes. */
public final class SlidingWindowMaximumBruteForceDemo {

  private SlidingWindowMaximumBruteForceDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int[] values = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    System.out.println("values: " + Arrays.toString(values) + ", k = " + k);

    // Six windows of three values each. Expect [3, 3, 5, 5, 6, 7].
    int[] maximums = SlidingWindowMaximumBruteForce.slidingMaximum(values, k);
    System.out.println("window maximums: " + Arrays.toString(maximums));
  }
}
