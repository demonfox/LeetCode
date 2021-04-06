// Given an integer array nums and an integer k, return true if there are two distinct indices i 
// and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

import java.util.Map;
import java.util.HashMap;

public class ContainsDuplicateII {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && ((i - map.get(nums[i])) <= k)) {
        return true;
      }
      map.put(nums[i], i);
    }
    return false;
  }

  public static void Run() {
    ContainsDuplicateII c = new ContainsDuplicateII();
    System.out.println(c.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
    System.out.println(c.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
    System.out.println(c.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
  }
}
