// You are given an integer array nums where the largest integer is unique.
// Determine whether the largest element in the array is at least twice as much as every other number in the 
// array. If it is, return the index of the largest element, or return -1 otherwise.

public class LargestNumAtLeastTwice {
  public int dominantIndex(int[] nums) {
    int maxIndex = 0;
    boolean flag = false;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[maxIndex]) {
        if (nums[i] < nums[maxIndex] * 2) {
          flag = true;
        } else {
          flag = false;
        }
        maxIndex = i;
      } else if (nums[i] < nums[maxIndex]) {
        if (nums[maxIndex] < nums[i] * 2) {
          flag = true;
        }
      }
    }
    return flag ? -1 : maxIndex;
  }

  public static void Run() {
    LargestNumAtLeastTwice l = new LargestNumAtLeastTwice();
    int[] nums = { 3, 6, 1, 0 };
    System.out.println(l.dominantIndex(nums));

    nums = new int[] { 1, 2, 3, 4 };
    System.out.println(l.dominantIndex(nums));

    // generate a test case of more than 10 elements
    nums = new int[] { 1, 2, 3, 4, 5, 26, 7, 8, 9, 10, 11 };
    System.out.println(l.dominantIndex(nums));

    nums = new int[] {0, 0, 3, 2};
    System.out.println(l.dominantIndex(nums));
  }
}
