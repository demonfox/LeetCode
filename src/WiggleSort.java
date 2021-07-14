// Given an integer array nums, reorder it such that nums[0] <= nums[1] => nums[2] <= nums[3]....
// You may assume the input array always has a valid answer.

import java.util.Arrays;

public class WiggleSort {
  public void wiggleSort(int[] nums) {
    for (int i=0; i<nums.length-1; i++) {
      if ((i & 1) == 0) {
        if (nums[i] > nums[i+1]) {
          int temp = nums[i+1]; nums[i+1] = nums[i]; nums[i] = temp;
        }
      } else {
        if (nums[i] < nums[i+1]) {
          int temp = nums[i+1]; nums[i+1] = nums[i]; nums[i] = temp;
        }
      }
    }
  }

  public static void Run() {
    WiggleSort w = new WiggleSort();
    int[] nums = new int[] {3,5,2,1,6,4};
    w.wiggleSort(nums);
    System.out.println(Arrays.toString(nums));
  }
}
