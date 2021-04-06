// Given an integer array nums and two integers k and t, return true if there are two distinct 
// indices i and j in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.

import java.util.TreeSet;

public class ContainsDuplicateIII {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> tset = new TreeSet<>();
    for (int i=0; i<nums.length; i++) {
      Long floor = tset.floor((long)nums[i]);
      if (floor != null && (nums[i] - floor) <= t)
        return true;
      Long ceiling = tset.ceiling((long)nums[i]);
      if (ceiling != null && (ceiling - nums[i]) <= t)
        return true;

      tset.add((long)nums[i]);
 
      if (tset.size() > k)
        tset.remove((long)nums[i-k]);
    }
    return false;
  }

  public static void Run() {
    ContainsDuplicateIII c = new ContainsDuplicateIII();
    System.out.println(c.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
    System.out.println(c.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
    System.out.println(c.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
  }
}
