// Implement next permutation, which rearranges numbers into the lexicographically next 
// greater permutation of numbers.
// If such an arrangement is not possible, it must rearrange it as the lowest possible order 
// (i.e., sorted in ascending order).
// The replacement must be in place and use only constant extra memory.

import java.util.Arrays;

public class NextPermutation {
  public void nextPermutation(int[] nums) {
    int len = nums.length;
    if (len == 1)
      return;
    int i = len - 2, j = len - 1;
    for (; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        for (; j >= i + 1; j--) {
          if (nums[j] > nums[i]) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            break;
          }
        }
        break;
      }
    }
    // nums[i] has been swapped with nums[j]; now from nums[i+1] to nums[j], these
    // digits are all greater than nums[j], and from nums[j+1] to nums[len-1], these 
    // digits are all smaller than nums[j].
    // Actually, its an ascending array from nums[len - 1] to nums[i+1], so we need
    // to rearrage this portion to the lowest possible order:
    for (int k = i + 1; k <= (len + i) / 2; k++) {
      int temp = nums[k];
      nums[k] = nums[len + i - k];
      nums[len + i - k] = temp;
    }
  }

  public static void Run() {
    NextPermutation n = new NextPermutation();
    int[] nums = new int[] { 1, 1, 5 };
    n.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    nums = new int[] { 1, 2, 3 };
    n.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    nums = new int[] { 3, 2, 1 };
    n.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    nums = new int[] { 1 };
    n.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    nums = new int[] { 4, 5, 6, 1 };
    n.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    nums = new int[] { 4, 5, 6, 2, 1 };
    n.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    nums = new int[] { 4, 3, 2, 5 };
    n.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    nums = new int[] { 1, 3, 2 };
    n.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }
}
