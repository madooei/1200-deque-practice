package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Unit tests for Palindrome. */
public class PalindromeTest {

  @Test
  public void emptyStringIsAPalindrome() {
    assertTrue(Palindrome.isPalindrome(""));
  }

  @Test
  public void singleCharacterIsAPalindrome() {
    assertTrue(Palindrome.isPalindrome("a"));
  }

  @Test
  public void twoEqualCharactersAreAPalindrome() {
    assertTrue(Palindrome.isPalindrome("aa"));
  }

  @Test
  public void twoDifferentCharactersAreNotAPalindrome() {
    assertFalse(Palindrome.isPalindrome("ab"));
  }

  @Test
  public void evenLengthPalindromeIsAPalindrome() {
    assertTrue(Palindrome.isPalindrome("abba"));
  }

  @Test
  public void oddLengthPalindromeIsAPalindrome() {
    assertTrue(Palindrome.isPalindrome("racecar"));
  }

  @Test
  public void mismatchInTheMiddleIsNotAPalindrome() {
    assertFalse(Palindrome.isPalindrome("abca"));
  }
}
