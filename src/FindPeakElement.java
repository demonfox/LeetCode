// A peak element is an element that is strictly greater than its neighbors.
// Given an integer array nums, find a peak element, and return its index. If the array 
// contains multiple peaks, return the index to any of the peaks.
// You may imagine that nums[-1] = nums[n] = -∞.

public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int m = l + (r - l) / 2;
      if (nums[m] > nums[m + 1])
        r = m;
      else
        l = m + 1;
    }
    return l;
  }

  public static void Run() {
    FindPeakElement f = new FindPeakElement();
    System.out.println(f.findPeakElement(new int[] { 1, 2, 3, 1 }));
    System.out.println(f.findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
  }
}
