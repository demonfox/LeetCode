// Given an array of integers nums, calculate the pivot index of this array.
// The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of 
// all the numbers strictly to the index's right.
// If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also 
// applies to the right edge of the array.
// Return the leftmost pivot index. If no such index exists, return -1.

public class PivotIndex {
  public int pivotIndex(int[] nums) {
    if (nums.length == 1) return 0;

    int leftSum = 0;
    int rightSum = 0;
    for (int i = 1; i<nums.length; i++) {
      rightSum += nums[i];
    }
    for (int i=0; i<nums.length-1; i++) {
      if (leftSum == rightSum)
        return i;
      leftSum += nums[i];
      rightSum -= nums[i+1];
    }
    return (leftSum == rightSum) ? nums.length - 1 : -1;
  }

  public static void Run() {
    PivotIndex test = new PivotIndex();
    int[] nums = {1,7,3,6,5,6};
    System.out.println(test.pivotIndex(nums));

    nums = new int[]{1,2,3};
    System.out.println(test.pivotIndex(nums));

    nums = new int[]{2,1,-1};
    System.out.println(test.pivotIndex(nums));

    nums = new int[]{1,2,2};
    System.out.println(test.pivotIndex(nums));

    nums = new int[]{1,2,3,4,5,6,7,8,9,10};
    System.out.println(test.pivotIndex(nums));

    nums = new int[]{3,-2,0,0,0,0,0,0,-1,0};
    System.out.println(test.pivotIndex(nums));
  }
}
