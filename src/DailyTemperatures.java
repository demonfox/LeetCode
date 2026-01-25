// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number 
// of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep 
// answer[i] == 0 instead.

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int index = stack.pop();
        result[index] = i - index;
      }
      stack.push(i);
    }
    // for elements remained in the stack, its corresponding value is just 0
    return result;
  }

  public static void Run() {
    DailyTemperatures obj = new DailyTemperatures();
    int[] temperatures = {73,74,75,71,69,72,76,73};
    int[] result = obj.dailyTemperatures(temperatures);
    System.out.println(Arrays.toString(result));
  }
}
