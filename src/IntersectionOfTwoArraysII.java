// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in 
// the result must appear as many times as it shows in both arrays and you may return the result in any order.
// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// Explanation: [9,4] is also accepted.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    List<Integer> result = new ArrayList<Integer>();
    for (int i : nums1)
      count.put(i, count.getOrDefault(i, 0) + 1);
    
    for (int i : nums2) {
      if (count.containsKey(i)) {
        result.add(i);
        int newCount = count.get(i) - 1;
        if (newCount == 0)
          count.remove(i);
        else
          count.put(i, newCount);
      }
    }

    int[] rtrn = new int[result.size()];
    int index = 0;
    for (int i : result)
      rtrn[index++] = i;

    return rtrn;
  }

  public static void Run() {
    IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
    System.out.println(Arrays.toString(i.intersect(new int[]{1,2,2,1}, new int[]{2,2})));
    System.out.println(Arrays.toString(i.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
  }
}
