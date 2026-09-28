package practice;

import deque.ArrayDeque;
import deque.Deque;

/** Solutions to the sliding window maximum problem. */
public final class SlidingWindowMaximum {

  private SlidingWindowMaximum() {
    // This class should not be instantiated!
  }

  // Returns the maximum of every window of width k in values, in order, so
  // the result has length values.length - k + 1. Assumes values is not null
  // and k is between 1 and values.length.
  public static int[] slidingMaximum(int[] values, int k) {
    int[] answer = new int[values.length - k + 1];
    Deque<Integer> candidates = new ArrayDeque<>();

    for (int i = 0; i < values.length; i++) {
      // Remove candidates that are no longer in the window.
      while (!candidates.isEmpty() && candidates.getFirst() <= i - k) {
        candidates.removeFirst();
      }

      // Remove candidates that the new value makes useless.
      while (!candidates.isEmpty()
          && values[candidates.getLast()] <= values[i]) {
        candidates.removeLast();
      }

      candidates.addLast(i);

      // The front is the maximum once the first full window exists.
      if (i >= k - 1) {
        answer[i - k + 1] = values[candidates.getFirst()];
      }
    }

    return answer;
  }

  // The brute-force solution. Returns the maximum of every window of width k
  // in values, in order, so the result has length values.length - k + 1.
  // Assumes values is not null and k is between 1 and values.length.
  public static int[] slidingMaximumBruteForce(int[] values, int k) {
    int[] answer = new int[values.length - k + 1];
    for (int start = 0; start <= values.length - k; start++) {
      int max = values[start];
      for (int i = start + 1; i < start + k; i++) {
        if (values[i] > max) {
          max = values[i];
        }
      }
      answer[start] = max;
    }
    return answer;
  }
}
