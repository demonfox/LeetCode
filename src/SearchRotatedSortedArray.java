// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is rotated at an unknown pivot index 
// k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], 
// nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be 
// rotated at pivot index 3 and become [4,5,6,7,0,1,2].
// Given the array nums after the rotation and an integer target, return the index of target 
// if it is in nums, or -1 if it is not in nums.


public class SearchRotatedSortedArray {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length-1;
    int mid;
    while (left <= right) {
      mid = left + (right-left)/2;
      if (nums[mid] == target)
        return mid;
      if (nums[left] < nums[right]) {
        // now we do regular binary search thingy
        if (nums[mid] < target)
          left = mid+1;
        else
          right = mid-1;
      } else {
        // we are still in a section where the array is rotated
        if (nums[mid] < target) {
          if (nums[mid] > nums[right])
            left = mid + 1;
          else {
            if (target > nums[right])
              right = mid - 1;
            else
              left = mid + 1;
          }

        } else { // nums[mid] > target
          if (nums[left] > nums[mid])
            right = mid - 1;
          else {
            if (target < nums[left])
              left = mid + 1;
            else
              right = mid - 1;
          }
        }
      }
    }
    return -1;
  }

  public static void Run() {
    SearchRotatedSortedArray s= new SearchRotatedSortedArray();
    System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0));
    System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3));
    System.out.println(s.search(new int[]{1}, 0));
    System.out.println(s.search(new int[]{4,5,6,7,8,1,2,3}, 8));
  }
}
