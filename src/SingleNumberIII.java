// Given an integer array nums, in which exactly two elements appear only once and all the other elements appear 
// exactly twice. Find the two elements that appear only once. You can return the answer in any order.
// You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

import java.util.Arrays;

public class SingleNumberIII {
  public int[] singleNumber(int[] nums) {
    int marker = 0;
    for (int i : nums)
      marker ^= i; // marker is essentially A ^ B, where A & B are the two elements we are looking for
    int[] ans = new int[2];
    for (int i : nums) {
      if ((i ^ marker) >= i)
        ans[0] ^= i;
      else
        ans[1] ^= i;
    }
    // we are essentially splitting these nums into 2 groups, where the identical element will 
    // always be in the same group (because after XOR'ing with marker, the comparison between the result and i itself
    // is the same). Then for A and B, A ^ marker = B, B ^ marker = A, since A and B are different, they will go 
    // to differetn groups while all the other elements in that group cancels out
    return ans;
  }

  public static void Run() {
    
    int[] nums = new int[] { 1, 2, 1, 3, 2, 5 };
    int[] result = new SingleNumberIII().singleNumber(nums);
    System.out.println(Arrays.toString(result));
  }
}
