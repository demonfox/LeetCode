// You are given two jugs with capacities x liters and y liters. You have an infinite water supply. Return whether the 
// total amount of water in both jugs may reach target using the following operations:
// Fill either jug completely with water.
// Completely empty either jug.
// Pour water from one jug into another until the receiving jug is full, or the transferring jug is empty.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaterAndJugProblem {
  public boolean canMeasureWater(int x, int y, int target) {
    if (x > y) { // swap x & y
      x = x + y;
      y = x - y;
      x = x - y;
    }
    // for every state, there are the following possible transitions:
    // 1. fill x if x is not full
    // 2. fill y if y is not full
    // 3. empty x if x is not empty
    // 4. empty y if y is not empty
    // 5. pour from x to y if y is not full
    // 6. pour from y to x if x is not full
    Queue<Integer> stateHorizon = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();

    stateHorizon.offer(0);
    visited.add(0);
    while (!stateHorizon.isEmpty()) {
      Integer s = stateHorizon.poll();
      visited.add(s);
      int currX = s % 10000;
      int currY = s / 10000;
      int currState;
      if (currX != x) {
        // currX = x;
        if (x + currY == target)
          return true;
        currState = currY * 10000 + x;
        if (!visited.contains(currState))
          stateHorizon.offer(currState);
      }

      if (currY != y) {
        // currY = y;
        if (currX + y == target)
          return true;
        currState = y * 10000 + currX;
        if (!visited.contains(currState))
          stateHorizon.offer(currState);
      }

      if (currX != 0) {
        // currX = 0;
        if (0 + currY == target)
          return true;
        currState = currY * 10000 + 0;
        if (!visited.contains(currState))
          stateHorizon.offer(currState);
      }

      if (currY != 0) {
        // currY = 0;
        if (currX + 0 == target)
          return true;
        currState = 0 * 10000 + currX;
        if (!visited.contains(currState))
          stateHorizon.offer(currState);
      }

      if (currY != y) {
        // int diff = y - currY;
        int newX = (currX >= (y - currY)) ? currX - (y - currY) : 0;
        int newY = currY + (currX - newX);
        if (newX + newY == target)
          return true;
        currState = newY * 10000 + newX;
        if (!visited.contains(currState))
          stateHorizon.offer(currState);
      }

      if (currX != x) {
        // int diff = x - currX;
        int newY = (currY >= (x - currX)) ? currY - (x - currX) : 0;
        int newX = currX + (currY - newY);
        if (newX + newY == target)
          return true;
        currState = newY * 10000 + newX;
        if (!visited.contains(currState))
          stateHorizon.offer(currState);
      }
    }
    return false;
  }

  public static void Run() {
    WaterAndJugProblem wjp = new WaterAndJugProblem();
    System.out.println(wjp.canMeasureWater(1, 2, 3));
    System.out.println(wjp.canMeasureWater(3, 5, 4));
    System.out.println(wjp.canMeasureWater(2, 6, 5));
  }
}
