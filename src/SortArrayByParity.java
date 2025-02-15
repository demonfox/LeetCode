// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
// Return any array that satisfies this condition.

import java.util.Arrays;

public class SortArrayByParity {
  public int[] sortArrayByParity(int[] nums) {
    if (nums.length <= 1) return nums;
    int start = 0, end = nums.length-1;
    while (start < end) {
      if ((nums[start] & 1) == 0)
        start++;
      else {
        nums[end] = nums[end] ^ nums[start]; 
        nums[start] = nums[end] ^ nums[start]; 
        nums[end] = nums[end] ^ nums[start];
        // int temp = nums[end];
        // nums[end] = nums[start];
        // nums[start] = temp;
        end--;
      }
    }
    return nums;
  }

  public static void Run() {
    SortArrayByParity s = new SortArrayByParity();
    int[] nums = {3,1,2,4};
    int[] res = s.sortArrayByParity(nums);
    // for (int i = 0; i < res.length; i++) {
    //   System.out.print(res[i] + " ");
    // }
    System.out.println(Arrays.toString(res));
  }
}
