// Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to 
// target.
// The test cases are generated so that the answer can fit in a 32-bit integer.

import java.util.Arrays;
import java.util.HashMap;

public class CombinationSumIV {
  private HashMap<Integer, Integer> cache = new HashMap<>();
  public int combinationSum4(int[] nums, int target) {
    cache.clear();
    Arrays.sort(nums);
    return memoization(nums, target);
  }

  public int memoization(int[] nums, int target) {
    if (target == 0)
      return 1;
    if (cache.containsKey(target))
      return cache.get(target);
    int totalCom = 0;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] > target)
        break;
      totalCom += memoization(nums, target - nums[i]);
    }
    cache.put(target, totalCom);
    return totalCom;
  }

  private int totalCom;
  public int combinationSum4_2(int[] nums, int target) {
    totalCom = 0;
    Arrays.sort(nums);
    backtrack(nums, target);
    return totalCom;
  }

  public void backtrack(int[] nums, int target) {
    if (target == 0) {
      totalCom++;
      return;
    }
    for (int i=0; i<nums.length; i++) {
      if (nums[i] > target)
        return;
      backtrack(nums, target - nums[i]);
    }
  }

  public static void Run() {
    CombinationSumIV cs = new CombinationSumIV();
    int[] nums = {1,2,3};
    int target = 4;
    System.out.println(cs.combinationSum4(nums, target));

    nums = new int[]{9};
    target = 3;
    System.out.println(cs.combinationSum4(nums, target));

    nums = new int[] {3};
    target = 9;
    System.out.println(cs.combinationSum4(nums, target));

    nums = new int[] {2};
    target = 9;
    System.out.println(cs.combinationSum4(nums, target));
  }
}

