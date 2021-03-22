// Given an array of integers heights representing the histogram's bar height where the width 
// of each bar is 1, return the area of the largest rectangle in the histogram.

import java.util.Stack;
import javafx.util.Pair;

public class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] heights) {
    // this stack is used to track a couple things:
    // 1) a list of heights *in an ascending order*; each new height encounterd that
    // is larger
    // than the top of the Stack (that is the highest height left - more on this
    // later)
    // 2) the left-most valid position for the corresponding height
    // What does it mean by "the highest height left" - notice that when we are
    // moving left to
    // right, every time we encounter a height, as long as it is not higher than
    // some of predecessor,
    // we need to pop off all its "taller" predecessors because from this point on,
    // the height of the
    // resulting rectangle will be bounded by this current height (which we will be
    // placing at the top
    // of the stack for calculating the area of the rectangle).
    Stack<Pair<Integer, Integer>> tracker = new Stack<Pair<Integer, Integer>>();
    int result = 0;
    for (int i = 0; i < heights.length; i++) {
      int lastTallerPos = Integer.MAX_VALUE;
      while (!tracker.empty() && tracker.peek().getValue() > heights[i]) {
        lastTallerPos = tracker.peek().getKey();
        Pair<Integer, Integer> bar = tracker.pop();
        // notice that during the first loop, the bar we are examining is just
        // one left to the current bar. See how this helps you to see that
        // the width is "i-bar.getKey()" instead of "i-bar.getKey()+1".
        // Also it is crucial to understand that we are calculating the area between
        // the bar popped from the stack and the bar i, or the area right to the bar
        // popped from the stack.
        // We are always computing the max area as the area to the right of a certain
        // bar.
        int currArea = (i - bar.getKey()) * bar.getValue();
        result = Math.max(currArea, result);
      }

      if (tracker.empty() || tracker.peek().getValue() < heights[i]) {
        Pair<Integer, Integer> bar = new Pair<Integer, Integer>(Math.min(lastTallerPos, i), heights[i]);
        tracker.push(bar);
      }

      // notice that if tracker.peek().getValue() == heights[i], we don't need to push
      // it onto the stack,
      // since we have already record this particular height and its left-most
      // starting position.
    }
    // the following can be replaced by adding a 0 height to the end of the input
    // array
    while (!tracker.empty()) {
      Pair<Integer, Integer> bar = tracker.pop();
      int currArea = (heights.length - bar.getKey()) * bar.getValue();
      result = Math.max(currArea, result);
    }

    return result;
  }

  public static void Run() {
    LargestRectangleInHistogram l = new LargestRectangleInHistogram();
    System.out.println(l.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
    System.out.println(l.largestRectangleArea(new int[] { 2, 4 }));
  }
}
