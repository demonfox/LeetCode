// A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive 
// and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element and 
// a sequence with two non-equal elements are trivially wiggle sequences.
// For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between 
// positive and negative.
// In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. The first is not because its first two 
// differences are positive, and the second is not because its last difference is zero.
// A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining 
// elements in their original order.
// Given an integer array nums, return the length of the longest wiggle subsequence of nums.

public class WiggleSubsequence {
  public int wiggleMaxLength(int[] nums) {
    if (nums.length == 1) return nums.length;
    if (nums.length == 2 && nums[0] == nums[1]) return 1;
    if (nums.length == 2 && nums[0] != nums[1]) return 2;

    boolean isDownTrend = true;
    int startIndex = 1;
    int result = 1;
    while (nums[startIndex] == nums[startIndex-1] && startIndex < nums.length)
      startIndex++;
    if (nums[startIndex] > nums[startIndex-1]) {
      result++;
      isDownTrend = false;
    } else {
      result++;
    }

    for (int i=startIndex+1; i<nums.length; i++) {
      if (nums[i] > nums[i-1]) {
        if (isDownTrend) {
          result++;
          isDownTrend = false;
        }
      }
      if (nums[i] < nums[i-1]) {
        if (!isDownTrend) {
          result++;
          isDownTrend = true;
        }
      }
    }
    return result;
  }

  public static void Run() {
    WiggleSubsequence w = new WiggleSubsequence();
    int[] nums = {1, 7, 4, 9, 2, 5};
    System.out.println(w.wiggleMaxLength(nums)); // Output: 6
    
    int[] nums2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
    System.out.println(w.wiggleMaxLength(nums2)); // Output: 7
    
    int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(w.wiggleMaxLength(nums3)); // Output: 2
  }
}
