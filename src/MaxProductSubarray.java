// Given an integer array nums, find a contiguous non-empty subarray within the array 
// that has the largest product, and return the product.
// It is guaranteed that the answer will fit in a 32-bit integer.
// A subarray is a contiguous subsequence of the array.

public class MaxProductSubarray {
  public int maxProduct(int[] nums) {
    int[] productArray = new int[nums.length];

    int max = Integer.MIN_VALUE;

    for (int i=0; i<nums.length; i++) {
      for (int j=i; j<nums.length; j++) {
        productArray[j] = (j == i) ? nums[j] : productArray[j-1] * nums[j];
        max = Math.max(max, productArray[j]);
      }
    }

    return max;
  }

  public int maxProduct2(int[] nums) {
    int[][] dp = new int[2][2];
    dp[0][0] = nums[0];
    dp[0][1] = nums[0];
    int result = nums[0];

    for (int i=1; i<nums.length; i++) {
      int i1 = i%2;
      int i2 = (i-1)%2;
      dp[i1][0] = Math.max(Math.max(dp[i2][0]*nums[i], dp[i2][1]*nums[i]), nums[i]);
      dp[i1][1] = Math.min(Math.min(dp[i2][0]*nums[i], dp[i2][1]*nums[i]), nums[i]);
      result = Math.max(dp[i1][0], result);
    }

    return result;
  }

  public static void Run() {
    MaxProductSubarray s = new MaxProductSubarray();
    System.out.println(s.maxProduct(new int[] {2,3,-2,4}));
    System.out.println(s.maxProduct(new int[] {-2,0,-1}));
    System.out.println(s.maxProduct2(new int[] {2,3,-2,4}));
    System.out.println(s.maxProduct2(new int[] {-2,0,-1}));
  }
}
