// Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return 
// the number of tuples (i, j, k, l) such that:
// 0 <= i, j, k, l < n
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

import java.util.Map;
import java.util.HashMap;

public class FourSumII {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    int result = 0;
    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    for (int n1 : nums1) {
      for (int n2 : nums2) {
        count.put(n1+n2, count.getOrDefault(n1+n2, 0) + 1);
      }
    }
    for (int n3 : nums3) {
      for (int n4 : nums4) {
        result += count.getOrDefault(-(n3+n4), 0);
      }
    }
    
    return result;
  }

  public static void Run() {
    FourSumII f = new FourSumII();
    System.out.println(f.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
    System.out.println(f.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
  }
}
