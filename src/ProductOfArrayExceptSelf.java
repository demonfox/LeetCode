// Given an integer array nums, return an array answer such that answer[i] is equal to the product 
// of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// Solve it in O(n) time complexity and O(1) constant space complexity.
// (The output array does not count as extra space for space complexity analysis.)

public class ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      result[i] = result[i - 1] * nums[i - 1];
    }
    int reversePass = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] *= reversePass;
      reversePass *= nums[i];
    }
    return result;
  }

  public static void Run() {
    ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
    int[] result = p.productExceptSelf(new int[] { 1, 2, 3, 4 });
    for (int i : result)
      System.out.print(i + " ");
    System.out.println();
    result = p.productExceptSelf(new int[] { -1, 1, 0, -3, 3 });
    for (int i : result)
      System.out.print(i + " ");
    System.out.println();
  }
}
