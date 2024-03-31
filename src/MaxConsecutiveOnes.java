// Given a binary array nums, return the maximum number of consecutive 1's in the array.

public class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      while (i < nums.length && nums[i] == 1) {
        i++;
        count++;
      }
      result = Math.max(count, result);
    }
    return result;
  }

  public static void Run() {
    MaxConsecutiveOnes m = new MaxConsecutiveOnes();
    int[] nums = new int[]{1, 1, 0, 1, 1, 1};
    System.out.println(m.findMaxConsecutiveOnes(nums));
    nums = new int[]{1, 0, 1, 1, 0, 1};
    System.out.println(m.findMaxConsecutiveOnes(nums));
  }
}
