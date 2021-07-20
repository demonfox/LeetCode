// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in 
// the result must be unique and you may return the result in any order.
// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> result = new HashSet<Integer>();
    
    Set<Integer> set = new HashSet<Integer>();
    for (int i : nums1) 
      set.add(i);
    for (int i : nums2)
      if (set.contains(i)) 
        result.add(i); // Note: you can use set.retainAll() to do the same

    int[] rtrn = new int[result.size()];
    int index = 0;
    for (Integer i : result)
      rtrn[index++] = i;
    
    return rtrn;
  }

  public static void Run() {
    IntersectionOfTwoArrays i = new IntersectionOfTwoArrays();
    System.out.println(Arrays.toString(i.intersection(new int[]{1,2,2,1}, new int[]{2,2})));
    System.out.println(Arrays.toString(i.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
  }
}
