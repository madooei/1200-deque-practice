package practice;

/** Runs the sliding window maximum scenarios against the deque solution. */
public class SlidingWindowMaximumDequeTest extends SlidingWindowMaximumTest {

  @Override
  protected int[] slidingMaximum(int[] values, int k) {
    return SlidingWindowMaximum.slidingMaximum(values, k);
  }
}
