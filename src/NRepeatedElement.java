// You are given an integer array nums with the following properties:
// nums.length == 2 * n.
// nums contains n + 1 unique elements.
// Exactly one element of nums is repeated n times.
// Return the element that is repeated n times.

import java.util.HashSet;

public class NRepeatedElement {
  public int repeatedNTimes(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i : nums) {
      if (set.contains(i)) return i;
      set.add(i);
    }
    return -1;
  }

  public static void Run() {
    NRepeatedElement n = new NRepeatedElement();
    System.out.println(n.repeatedNTimes(new int[] { 1, 2, 3, 3 }));
    System.out.println(n.repeatedNTimes(new int[] { 2, 1, 2, 5, 3, 2 }));
    System.out.println(n.repeatedNTimes(new int[] { 5, 1, 5, 2, 5, 3, 5, 4 }));
  }
}
