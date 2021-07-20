// Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
// You may assume the input array always has a valid answer.

import java.util.Arrays;

public class WiggleSortII {
  public void wiggleSort(int[] nums) {
    int[] temp = Arrays.copyOf(nums, nums.length);
    Arrays.sort(temp);
    int r = nums.length - 1;
    int m = r / 2;
    int l = 0;
    boolean isEvenLen = ((nums.length & 1) == 0);
    while (m > 0 || (m==0 && isEvenLen)) { // if length is even, we will finish the work within the while loop
      nums[2*l] = temp[m];
      nums[2*l+1] = temp[r];
      r--;
      m--;
      l++;
    }
    // if length is odd, we have one extra element to process
    if (!isEvenLen)
      nums[nums.length-1] = temp[0];
  }

  public static void Run() {
    WiggleSortII w = new WiggleSortII();
    int[] nums = new int[] {1,5,1,1,6,4};
    w.wiggleSort(nums);
    System.out.println(Arrays.toString(nums));
    nums = new int[] {1,3,2,2,3,1};
    w.wiggleSort(nums);
    System.out.println(Arrays.toString(nums));
  }
}
