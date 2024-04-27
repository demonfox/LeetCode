// There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
// Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such 
// that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
// For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
// Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
//You must decrease the overall operation steps as much as possible.

public class SearchRotatedSortedArrayII {
  /*
  public boolean search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return true;
      } else if (nums[mid] < target) {
        // l = mid + 1; <- this is what regular binary search does
        // normally "nums[mid] < target" means target is within the right section, but
        // that is not necessarily true in a rotated array, the new logic is the following:

        // first, since target is > nums[mid] and then if the left section is ascending (or aka: nums[l] < nums[mid]), 
        // then target must be within the right section, which is the "else" part
        // secondly, if nums[l] > nums[mid] AND target >= nums[l], then target is within the left section, which is the "if" part
        // also notice that the "else" part contains the case where nums[l] > nums[mid] AND target < nums[l], then target should
        // also be within the right section
        if (nums[l] > nums[mid] && target >= nums[l]) { 
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      } else { // this is for target < nums[mid]
        // r = mid -1; <- this is what regular binary search does
         // normally "target < nums[mid]" means target is within the left section, but
        // that is not necessarily true in a rotated array, the new logic is the following:

        // first, since target is < nums[mid] and then if the right section is ascending (or aka: nums[mid] < nums[r]), 
        // then target must be within the left section, which is the "else" part
        // secondly, if nums[mid] > nums[r] AND target <= nums[r], then target is within the right section, which is the "if" part
        // also notice that the "else" part contains the case where nums[mid] > nums[r] AND target > nums[r], then target should
        // also be within the left section
        if (nums[mid] > nums[r] && target <= nums[r]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }
    return false;
  }
  */

  public boolean search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (nums[m] == target)
        return true;
      if (nums[l] == nums[m] && nums[m] == nums[r]) {
        l++;
        r--;
        continue;
      }
      if (nums[l] <= nums[m]) // left portion sorted
        if (nums[l] <= target && target <= nums[m])
          r = m - 1;
        else
          l = m + 1;
      else // right portion sorted
        if (nums[m] <= target && target <= nums[r])
          l = m + 1;
        else
          r = m - 1;
    }
    return false;
  }

  public static void Run() {
    int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
    System.out.println((new SearchRotatedSortedArrayII()).search(nums1, 0));
    System.out.println((new SearchRotatedSortedArrayII()).search(nums1, 2));
    System.out.println((new SearchRotatedSortedArrayII()).search(nums1, 3));

    int[] nums2 = {2, 2, 2, 2, 1, 2};
    System.out.println((new SearchRotatedSortedArrayII()).search(nums2, 2));
    System.out.println((new SearchRotatedSortedArrayII()).search(nums2, 1));
    System.out.println((new SearchRotatedSortedArrayII()).search(nums2, 3));
  }
}
