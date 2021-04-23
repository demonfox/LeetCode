// Given an array nums and two types of queries where you should update the value of an index 
// in the array, and retrieve the sum of a range in the array.
// Implement the NumArray class:
// NumArray(int[] nums) initializes the object with the integer array nums.
// void update(int index, int val) updates the value of nums[index] to be val.
// int sumRange(int left, int right) returns the sum of the subarray nums[left, right] (i.e., nums[left] + nums[left + 1], ..., nums[right]).

public class NumArray {
  FenwickTree ftree;
  private int[] nums;
  public NumArray(int[] nums) {
    ftree = new FenwickTree(nums.length);
    this.nums = new int[nums.length];
    for (int i=0; i<nums.length; i++) {
      this.nums[i] = nums[i];
      ftree.update(i+1, nums[i]);
    }
  }
  
  public void update(int index, int val) {
    ftree.update(index+1, val - nums[index]);
    nums[index] = val;
  }
  
  public int sumRange(int left, int right) {
    // we need to sum up from nums[left] to nums[right]
    // ftree.query(left) = sum(nums[0] ... nums[left-1])
    // ftree.query(right+1) = sum(nums[0] ... nums[right])
    return ftree.query(right+1) - ftree.query(left);
  }

  public static void Run() {
    NumArray n = new NumArray(new int[]{1, 3, 5});
    System.out.println(n.sumRange(0, 2));
    n.update(1, 2);
    System.out.println(n.sumRange(0, 2));
  }
}

