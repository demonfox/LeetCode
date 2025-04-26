// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in 
// non-decreasing order.

import java.util.Arrays;

public class SquaresOfSortedArray {
  public int[] sortedSquares(int[] nums) {
    int[] result = new int[nums.length];
    int positiveIndex = 0;
    while (positiveIndex < nums.length && nums[positiveIndex] < 0)
      positiveIndex++;
    int negativeIndex = positiveIndex - 1;
    int index = 0;
    while(true) {
      if (positiveIndex == nums.length) {
        while (negativeIndex >=0) {
          result[index++] = nums[negativeIndex] * nums[negativeIndex];
          negativeIndex--;
        }
        break;
      } else if (negativeIndex == -1) {
        while (positiveIndex < nums.length) {
          result[index++] = nums[positiveIndex] * nums[positiveIndex];
          positiveIndex++;
        }
        break;
      }
      if (nums[positiveIndex] * nums[positiveIndex] < nums[negativeIndex] * nums[negativeIndex]) {
        result[index++] = nums[positiveIndex] * nums[positiveIndex];
        positiveIndex++;
      } else if (nums[positiveIndex] * nums[positiveIndex] > nums[negativeIndex] * nums[negativeIndex]) {
        result[index++] = nums[negativeIndex] * nums[negativeIndex];
        negativeIndex--;
      } else {
        result[index++] = nums[positiveIndex] * nums[positiveIndex];
        result[index++] = nums[positiveIndex] * nums[positiveIndex];
        positiveIndex++;
        negativeIndex--;
      }
    }
    return result;
  }

  public static void Run() {
    SquaresOfSortedArray ssa = new SquaresOfSortedArray();
    int[] nums = new int[] {-4,-1,0,3,10};
    int[] result = ssa.sortedSquares(nums);
    System.out.println(Arrays.toString(result));
    nums =  new int[] {-7,-3,2,3,11};
    result = ssa.sortedSquares(nums);
    System.out.println(Arrays.toString(result));
  }
}
