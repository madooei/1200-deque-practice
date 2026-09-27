# Deque — Practice

Three practice problems. `SlidingWindowMaximum` reports the maximum of every window of width `k` in an array. `Palindrome` uses a deque to check whether a string reads the same from both ends. `MaxQueue` is a queue with an extra `max` operation, built from two deques.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      deque/
        Deque.java                               # the Deque ADT contract (copied from the chapter)
        ArrayDeque.java                          # circular-array Deque (copied from the chapter)
      practice/
        SlidingWindowMaximum.java                # the maximum of every window (2 solutions)
        Palindrome.java                          # palindrome check from both ends
        MaxQueue.java                            # a queue with a max operation
    test/
      practice/
        SlidingWindowMaximumTest.java            # abstract: the sliding window maximum scenarios
        SlidingWindowMaximumBruteForceTest.java  # runs them against the scan-every-window solution
        SlidingWindowMaximumDequeTest.java       # runs them against the monotonic-deque solution
        PalindromeTest.java                      # tests for Palindrome
        MaxQueueTest.java                        # tests for MaxQueue
  scripts/
    test.sh                                      # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.SlidingWindowMaximumBruteForceTest` — compiles everything and runs only that test class. Use this while you are working on one problem or one solution and the others are still empty.

There is no demo program for these problems; the tests are how you check your work.

## What's here

- `deque.Deque<T>` and `deque.ArrayDeque<T>` — unchanged copies from the chapter. `SlidingWindowMaximum`, `Palindrome`, and `MaxQueue` use them, so they are included here to keep this code self-contained.
- `practice.SlidingWindowMaximum` — two solutions side by side: scanning every window, and the monotonic deque of indices.
- `practice.SlidingWindowMaximumTest` — the abstract scenario suite for sliding window maximum. It has one subclass per solution, so you can test one solution alone.
- `practice.Palindrome` — decides whether a string is a palindrome by comparing and removing characters at both ends of a deque.
- `practice.PalindromeTest` — tests for `Palindrome`.
- `practice.MaxQueue` — a queue of integers with `max`, using one deque for the queue order and one deque for the maximum candidates.
- `practice.MaxQueueTest` — tests for `MaxQueue`.
