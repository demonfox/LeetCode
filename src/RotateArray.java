// Given an array, rotate the array to the right by k steps, where k is non-negative.

import java.math.BigInteger;

public class RotateArray {
  public void rotate(int[] nums, int k) {
    k = k % nums.length; // we really just need to deal with k's value after modding the total length
    int gcd = BigInteger.valueOf(nums.length).gcd(BigInteger.valueOf(k)).intValue();
    int rotateTimes = nums.length / gcd;
    // I don't know what to tell you. Just need to look at this long enough and have
    // a great sense for numbers.
    for (int startIndex = 0; startIndex < gcd; startIndex++) {
      int currIndex = startIndex;
      int currVal = nums[currIndex];
      for (int i = 0; i < rotateTimes; i++) {
        int nextIndex = (currIndex + k) % nums.length;
        int nextVal = nums[nextIndex];
        nums[nextIndex] = currVal;
        currVal = nextVal;
        currIndex = nextIndex;
      }
    }
  }

  public static void Run() {
    RotateArray r = new RotateArray();
    int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
    r.rotate(nums, 3);
    for (int i : nums)
      System.out.print(i + " ");
    System.out.println();
    nums = new int[] { -1, -100, 3, 99 };
    r.rotate(nums, 2);
    for (int i : nums)
      System.out.print(i + " ");
    System.out.println();
  }
}
