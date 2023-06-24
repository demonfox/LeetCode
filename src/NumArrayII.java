// Given an integer array nums, handle multiple queries of the following type:
// Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
// Implement the NumArray class:
// NumArray(int[] nums) Initializes the object with the integer array nums.
// int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and 
// right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

public class NumArrayII {
  private int[] numbers;
  private int[] indexedSum;
  public NumArrayII(int[] nums) {
    numbers = new int[nums.length];
    indexedSum = new int[nums.length];
    numbers[0] = indexedSum[0] = nums[0];
    for (int i=1; i<nums.length; i++) {
      numbers[i] = nums[i];
      indexedSum[i] = indexedSum[i-1] + numbers[i];
    }
  }
    
  public int sumRange(int left, int right) {
    return indexedSum[right] - indexedSum[left] + numbers[left];
  }

  public static void Run() {
    NumArray n = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    System.out.println(n.sumRange(0, 2));
    //n.update(1, 2);
    System.out.println(n.sumRange(2, 5));
    System.out.println(n.sumRange(0, 5));
  }
}
