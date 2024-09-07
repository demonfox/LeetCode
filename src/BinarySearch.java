// Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. 
// If target exists, then return its index. Otherwise, return -1.
// You must write an algorithm with O(log n) runtime complexity.

public class BinarySearch {
  public int search(int[] nums, int target) {
    int l, r;
    l = 0;
    r = nums.length-1;
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (nums[m] == target)
        return m;
      if (nums[m] > target)
        r = m - 1;
      else
        l = m + 1;
    }
    return -1;
  }

  public static void Run() {
    BinarySearch bs = new BinarySearch();
    int[] nums = {-1,0,3,5,9,12};
    int target = 9;
    System.out.println(bs.search(nums, target));
    nums = new int[]{-1,0,3,5,9,12};
    target = 2;
    System.out.println(bs.search(nums, target));
  }
}
