// You are given an array of integers stones where stones[i] is the weight of the ith stone.
// We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. 
// Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
// If x == y, both stones are destroyed, and
// If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
// At the end of the game, there is at most one stone left.
// Return the weight of the last remaining stone. If there are no stones left, return 0.


import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for (int stone : stones) {
      maxHeap.add(stone);
    }

    while (maxHeap.size() > 1) {
      int y = maxHeap.poll();
      int x = maxHeap.poll();
      if (y != x) {
        maxHeap.add(y - x);
      }
    }

    return maxHeap.isEmpty() ? 0 : maxHeap.poll();
  }

  public static void Run() {
    LastStoneWeight solution = new LastStoneWeight();

    int[][] testCases = {
      {2, 7, 4, 1, 8, 1},
      {1},
      {2, 2},
      {10, 4, 2, 10}
    };
    int[] expected = {1, 1, 0, 2};

    for (int i = 0; i < testCases.length; i++) {
      int actual = solution.lastStoneWeight(testCases[i]);
      if (actual != expected[i]) {
        throw new AssertionError(
          "Test case " + (i + 1) + " failed: expected " + expected[i] + ", got " + actual
        );
      }
    }

    System.out.println("LastStoneWeight: all " + testCases.length + " tests passed.");
  }
}

