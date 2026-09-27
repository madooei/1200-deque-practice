package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * The scenarios for the sliding window maximum problem. A concrete subclass
 * supplies slidingMaximum() to pick the solution under test.
 */
public abstract class SlidingWindowMaximumTest {

  // Calls the solution under test.
  protected abstract int[] slidingMaximum(int[] values, int k);

  @Test
  public void windowOfOneCopiesEachValue() {
    assertArrayEquals(new int[] {4, 2, 7},
        slidingMaximum(new int[] {4, 2, 7}, 1));
  }

  @Test
  public void windowSpanningTheWholeArrayGivesOneMaximum() {
    assertArrayEquals(new int[] {5},
        slidingMaximum(new int[] {2, 5, 1}, 3));
  }

  @Test
  public void decreasingValuesKeepTheFirstAsMaximum() {
    assertArrayEquals(new int[] {9, 8, 7},
        slidingMaximum(new int[] {9, 8, 7, 6, 5}, 3));
  }

  @Test
  public void increasingValuesKeepTheLastAsMaximum() {
    assertArrayEquals(new int[] {7, 8, 9},
        slidingMaximum(new int[] {5, 6, 7, 8, 9}, 3));
  }

  @Test
  public void maximumLeavingTheWindowIsReplaced() {
    assertArrayEquals(new int[] {9, 3},
        slidingMaximum(new int[] {9, 1, 2, 3}, 3));
  }

  @Test
  public void equalValuesGiveTheSameMaximum() {
    assertArrayEquals(new int[] {5, 5, 5},
        slidingMaximum(new int[] {5, 5, 5, 5}, 2));
  }

  @Test
  public void maximumChangesAsTheWindowSlides() {
    assertArrayEquals(new int[] {3, 3, 5, 5, 6, 7},
        slidingMaximum(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
  }

  @Test
  public void windowSizeZeroThrows() {
    try {
      slidingMaximum(new int[] {1, 2, 3}, 0);
      fail("expected IllegalArgumentException when k is 0");
    } catch (IllegalArgumentException e) {
      return;
    }
  }

  @Test
  public void windowLargerThanArrayThrows() {
    try {
      slidingMaximum(new int[] {1, 2, 3}, 4);
      fail("expected IllegalArgumentException when k exceeds the array length");
    } catch (IllegalArgumentException e) {
      return;
    }
  }
}
