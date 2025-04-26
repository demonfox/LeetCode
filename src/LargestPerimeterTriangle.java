// Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of 
// these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

import java.util.Arrays;

public class LargestPerimeterTriangle {
  public int largestPerimeter(int[] nums) {
    Arrays.sort(nums);
    for (int i=nums.length-1; i>=2; i--) {
      if (nums[i-2] + nums[i-1] > nums[i])
        return nums[i-2] + nums[i-1] + nums[i];
    }
    return 0;
  }

  public static void Run() {
    LargestPerimeterTriangle lpt = new LargestPerimeterTriangle();
    System.out.println(lpt.largestPerimeter(new int[] {2,1,2}));
    System.out.println(lpt.largestPerimeter(new int[] {1,2,1,10}));
  }
}
