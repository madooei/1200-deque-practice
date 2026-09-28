# Deque — Practice

Two practice problems. `MaxQueue` is a queue with an extra `getMax` operation, built from two deques. `SlidingWindowMaximum` reports the maximum of every window of width `k` in an array.

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
        MaxQueue.java                            # a queue with a getMax operation
        SlidingWindowMaximum.java                # the maximum of every window (2 solutions)
    test/
      practice/
        MaxQueueTest.java                        # tests for MaxQueue
        SlidingWindowMaximumTest.java            # abstract: the sliding window maximum scenarios
        SlidingWindowMaximumBruteForceTest.java  # runs them against the scan-every-window solution
        SlidingWindowMaximumDequeTest.java       # runs them against the deque solution
  scripts/
    test.sh                                      # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.SlidingWindowMaximumBruteForceTest` — compiles everything and runs only that test class. Use this while you are working on one problem or one solution and the others are still empty.

There is no demo program for these problems; the tests are how you check your work.

## What's here

- `deque.Deque<T>` and `deque.ArrayDeque<T>` — unchanged copies from the chapter. `MaxQueue` and `SlidingWindowMaximum` use them, so they are included here to keep this code self-contained.
- `practice.MaxQueue` — a queue of integers with `getMax`, using one deque for the queue order and one deque for the maximum candidates.
- `practice.MaxQueueTest` — tests for `MaxQueue`.
- `practice.SlidingWindowMaximum` — two solutions side by side: scanning every window, and the deque of indices.
- `practice.SlidingWindowMaximumTest` — the abstract scenario suite for sliding window maximum. It has one subclass per solution, so you can test one solution alone.
