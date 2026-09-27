package practice;

import deque.ArrayDeque;
import deque.Deque;

/** The solution to the palindrome checker problem. */
public final class Palindrome {

  private Palindrome() {
    // This class should not be instantiated!
  }

  // Returns true if s reads the same forward and backward. Assumes s is not
  // null.
  public static boolean isPalindrome(String s) {
    Deque<Character> chars = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      chars.addLast(s.charAt(i));
    }

    int count = s.length();
    while (count > 1) {
      char first = chars.getFirst();
      char last = chars.getLast();
      if (first != last) {
        return false;
      }
      chars.removeFirst();
      chars.removeLast();
      count -= 2;
    }

    return true;
  }
}
