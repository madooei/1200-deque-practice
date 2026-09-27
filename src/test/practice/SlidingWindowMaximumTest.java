package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    assertMaxima(new int[] {4, 2, 7},
        slidingMaximum(new int[] {4, 2, 7}, 1));
  }

  @Test
  public void windowSpanningTheWholeArrayGivesOneMaximum() {
    assertMaxima(new int[] {5},
        slidingMaximum(new int[] {2, 5, 1}, 3));
  }

  @Test
  public void decreasingValuesKeepTheFirstAsMaximum() {
    assertMaxima(new int[] {9, 8, 7},
        slidingMaximum(new int[] {9, 8, 7, 6, 5}, 3));
  }

  @Test
  public void increasingValuesKeepTheLastAsMaximum() {
    assertMaxima(new int[] {7, 8, 9},
        slidingMaximum(new int[] {5, 6, 7, 8, 9}, 3));
  }

  @Test
  public void maximumLeavingTheWindowIsReplaced() {
    assertMaxima(new int[] {9, 3},
        slidingMaximum(new int[] {9, 1, 2, 3}, 3));
  }

  @Test
  public void equalValuesGiveTheSameMaximum() {
    assertMaxima(new int[] {5, 5, 5},
        slidingMaximum(new int[] {5, 5, 5, 5}, 2));
  }

  @Test
  public void maximumChangesAsTheWindowSlides() {
    assertMaxima(new int[] {3, 3, 5, 5, 6, 7},
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

  // Asserts that actual holds exactly the expected maxima, in order.
  private static void assertMaxima(int[] expected, int[] actual) {
    assertEquals(expected.length, actual.length);
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }
}
