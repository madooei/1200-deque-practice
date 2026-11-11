package practice;

/** Runs the sliding window maximum scenarios against the scan-every-window solution. */
public class SlidingWindowMaximumBruteForceTest extends SlidingWindowMaximumTest {

  @Override
  protected int[] slidingMaximum(int[] values, int k) {
    return SlidingWindowMaximumBruteForce.slidingMaximum(values, k);
  }
}
