// Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], 
// answer[j]) of elements in this subset satisfies:
// answer[i] % answer[j] == 0, or
// answer[j] % answer[i] == 0
// If there are multiple solutions, return any of them.

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {
  // cache: cache[i] = longest divisible subset starting from i, including nums[i]
  HashMap<Integer, List<Integer>> cache = new HashMap<Integer, List<Integer>>();
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    cache.clear();

    List<Integer> result = new LinkedList<>();
    for (int i=0; i<nums.length; i++) {
      List<Integer> tmp = memoization(i, nums);
      if (tmp.size() > result.size())
        result = tmp;
    }
    return result;
  }

  public List<Integer> dp(int[] nums) {
    Arrays.sort(nums);
    // DP[i] = longest divisible subset starting from i, including nums[i]
    List<Integer>[] DP = (List<Integer>[]) new List[nums.length];
    for (int i=0; i<nums.length; i++) {
      DP[i] = new LinkedList<Integer>();
      DP[i].add(nums[i]);
    }
    List<Integer> result = new LinkedList<>();
    for (int i=nums.length-1; i>=0; i--) {
      for (int j=i+1; j<nums.length; j++) {
        if (nums[j] % nums[i] == 0) {
          List<Integer> tmp = new LinkedList<>();
          tmp.add(nums[i]);
          tmp.addAll(DP[j]);
          if (tmp.size() > DP[i].size())
            DP[i] = tmp;
        }
      }

      if (DP[i].size() > result.size())
        result = DP[i];
    }
    return result;
  }

  private List<Integer> memoization(int startIndex, int[] nums) {
    if (startIndex == nums.length)
      return new LinkedList<Integer>();
    if (cache.containsKey(startIndex))
      return cache.get(startIndex);
    
    List<Integer> result = new LinkedList<>();
    result.add(nums[startIndex]);

    for (int j=startIndex+1; j<nums.length; j++) {
      if ((nums[j] % nums[startIndex]) == 0) {
        List<Integer> tmp = memoization(j, nums);
        if (tmp.size() >= result.size()) {
          result.clear();
          result.add(nums[startIndex]);
          result.addAll(tmp);
        }
      }
    }
    cache.put(startIndex, result);

    return result;
  }

  public static void Run() {
    int[] nums = {1,2,4,8};
    LargestDivisibleSubset lds = new LargestDivisibleSubset();
    List<Integer> result = lds.largestDivisibleSubset(nums);
    System.out.println(result);
    result = lds.dp(nums);
    System.out.println(result);

    int[] nums2 = {1,2,3};
    result = lds.largestDivisibleSubset(nums2);
    System.out.println(result);
    result = lds.dp(nums2);
    System.out.println(result);
  }
}
