// Given an integer array nums, return true if any value appears at least twice in the array, and 
// return false if every element is distinct.

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> s = new HashSet<Integer>();
    for (int i : nums) {
      if (s.contains(i))
        return true;
      s.add(i);
    }
    return false;
  }

  public static void Run() {
    ContainsDuplicate c = new ContainsDuplicate();
    System.out.println(c.containsDuplicate(new int[] { 1, 2, 3, 1 }));
    System.out.println(c.containsDuplicate(new int[] { 1, 2, 3, 4 }));
    System.out.println(c.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
  }
}
