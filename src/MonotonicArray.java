// An array is monotonic if it is either monotone increasing or monotone decreasing.
// An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, 
// nums[i] >= nums[j].
// Given an integer array nums, return true if the given array is monotonic, or false otherwise.


public class MonotonicArray {
  public boolean isMonotonic(int[] nums) {
    if (nums.length == 1) return true;
    int increasing = 0;
    for (int i=1; i<nums.length-1; i++) {
      if (nums[i] == nums[i-1])
        continue;
      if (nums[i] > nums[i-1])
        increasing = 1;
      else if (nums[i] < nums[i-1])
        increasing = -1;
      break;
    }
    if (increasing == 0) return true;

    for (int i = 2; i < nums.length; i++) {
      if ((increasing == 1 && nums[i-1] > nums[i]) || (increasing == -1 && nums[i-1] < nums[i]))
        return false;
    }
    return true;
  }

  public static void Run() {
    MonotonicArray m = new MonotonicArray();
    int[] nums = {1, 2, 2, 3};
    System.out.println(m.isMonotonic(nums));
    nums = new int[] {6, 5, 4, 4};
    System.out.println(m.isMonotonic(nums));
    nums = new int[] {1, 3, 2};
    System.out.println(m.isMonotonic(nums));
    nums = new int[] {1, 1, 1, 1};
    System.out.println(m.isMonotonic(nums));
    nums = new int[] {1, 1, 2};
    System.out.println(m.isMonotonic(nums));
  }
}
