// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

import java.util.HashMap;

public class SubarraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
    int result = 0;
    HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
    prefixSumFreq.put(0, 1);
    int currSum = 0;
    for (int num : nums) {
      currSum += num;
      result += prefixSumFreq.getOrDefault(currSum - k, 0);
      prefixSumFreq.put(currSum, prefixSumFreq.getOrDefault(currSum, 0) + 1);
    }
    return result;
  }

  public static void Run() {
    SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
    System.out.println(subarraySumEqualsK.subarraySum(new int[] {1, 1, 1}, 2));
    System.out.println(subarraySumEqualsK.subarraySum(new int[] {1, 2, 3}, 3));
    System.out.println(subarraySumEqualsK.subarraySum(new int[] {1, -1, 0, 1}, 0));
  }
}
