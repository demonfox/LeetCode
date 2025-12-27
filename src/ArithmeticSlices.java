// An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
// For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
// Given an integer array nums, return the number of arithmetic subarrays of nums.
// A subarray is a contiguous subsequence of the array.

public class ArithmeticSlices {
  public int numberOfArithmeticSlices(int[] nums) {
    if (nums.length <= 2) return 0;
    int result = 0;
    for (int i=0; i<nums.length-2; i++) {
      if ((nums[i+1] - nums[i]) == (nums[i+2] - nums[i+1])) {
        result++;
        int diff = nums[i+1] - nums[i];
        for (int j=i+3; j<nums.length; j++) {
          if ((nums[j] - nums[j-1]) == diff)
            result++;
          else
            break;
        }
      }
    }
    return result;   
  }

  public static void Run() {
    ArithmeticSlices a = new ArithmeticSlices();
    System.out.println(a.numberOfArithmeticSlices(new int[] {1,2,3,4}));
    System.out.println(a.numberOfArithmeticSlices(new int[] {1}));
  }
}
