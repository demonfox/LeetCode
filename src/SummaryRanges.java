// You are given a sorted unique integer array nums.
// A range [a,b] is the set of all integers from a to b (inclusive).
// Return the smallest sorted list of ranges that cover all the numbers in the array exactly. 
// That is, each element of nums is covered by exactly one of the ranges, and there is no integer x 
// such that x is in one of the ranges but not in nums.
// Each range [a,b] in the list should be output as:
// - "a->b" if a != b
// - "a" if a == b

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums.length == 0)
      return result;
    int prev = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == prev + 1) {
        prev++;
        count++;
      } else {
        if (count == 1) {
          result.add(Integer.toString(prev));
        } else {
          result.add(String.format("%d->%d", prev - count + 1, prev));
        }
        prev = nums[i];
        count = 1;
      }
    }
    if (count == 1) {
      result.add(Integer.toString(prev));
    } else {
      result.add(String.format("%d->%d", prev - count + 1, prev));
    }

    return result;
  }

  public static void Run() {
    SummaryRanges sr = new SummaryRanges();
    List<String> result = sr.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 });
    result.forEach(s -> System.out.print(s + " "));
    result = sr.summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 });
    result.forEach(s -> System.out.print(s + " "));
  }
}
