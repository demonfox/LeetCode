// Given a sorted integer array nums, where the range f elements are in the inclusive range [lower, upper],
// return its missing ranges.

import java.util.LinkedList;
import java.util.List;

public class MissingRanges {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> result = new LinkedList<>();
    int currLower = lower;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > currLower) {
        result.add(constructRange(currLower, nums[i]));
      }
      currLower = nums[i] + 1;
    }
    if (upper >= currLower)
      result.add(constructRange(currLower, upper + 1));
    return result;
  }

  private String constructRange(int currLower, int i) {
    if (currLower + 1 == i)
      return String.valueOf(currLower);
    return String.valueOf(currLower) + "->" + String.valueOf(i - 1);
  }

  public static void Run() {
    MissingRanges m = new MissingRanges();
    List<String> result = m.findMissingRanges(new int[] { 0, 1, 3, 50, 75 }, 0, 99);
    result.forEach(s -> System.out.print(s + " "));
    System.out.println();
    result = m.findMissingRanges(new int[] { 0, 1, 3, 50, 75, 98, 99 }, 0, 99);
    result.forEach(s -> System.out.print(s + " "));
    System.out.println();
    result = m.findMissingRanges(new int[] { 0, 1, 3, 50, 75, 98, 99 }, 0, 100);
    result.forEach(s -> System.out.print(s + " "));
    System.out.println();
    result = m.findMissingRanges(new int[] { 3, 5, 7, 50, 75, 98 }, 0, 99);
    result.forEach(s -> System.out.print(s + " "));
    System.out.println();
  }
}
