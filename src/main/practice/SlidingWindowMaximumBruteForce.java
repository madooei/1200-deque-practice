package practice;

/** Practice problem: find the maximum of every window by scanning each window. */
public final class SlidingWindowMaximumBruteForce {

  private SlidingWindowMaximumBruteForce() {
    // This class should not be instantiated!
  }

  // The brute-force solution. Returns the maximum of every window of width k
  // in values, in order, so the result has length values.length - k + 1.
  // Assumes values is not null and k is between 1 and values.length.
  public static int[] slidingMaximum(int[] values, int k) {
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
