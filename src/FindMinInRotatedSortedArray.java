// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = 
// [0,1,2,4,5,6,7] might become:
// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
// Given the sorted rotated array nums of unique elements, return the minimum element of this array.
// You must write an algorithm that runs in O(log n) time.

public class FindMinInRotatedSortedArray {
  public int findMin(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    int l = 0, r = nums.length-1;
    int m;
    while (true) {
      if (nums[l] < nums[r])
        return nums[l];
      else if(l == r - 1)
        return Math.min(nums[l], nums[r]);
      m = l + (r - l) / 2;
      if (nums[l] < nums[m]) // left side is sorted
        l = m;
      else
        r = m;
    }
  }

  public static void Run() {
    FindMinInRotatedSortedArray f = new FindMinInRotatedSortedArray();
    int[] nums = {4,5,6,7,0,1,2};
    System.out.println(f.findMin(nums));
    nums = new int[] {3,4,5,1,2};
    System.out.println(f.findMin(nums));
    nums = new int[] {1,2,3,4,5};
    System.out.println(f.findMin(nums));
    nums = new int[] {2,3,4,5,1};
    System.out.println(f.findMin(nums));
    nums = new int[] {11,13,15,17};
    System.out.println(f.findMin(nums));
    nums = new int[] {100};
    System.out.println(f.findMin(nums));
  }
}
