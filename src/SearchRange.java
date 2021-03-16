import java.util.Arrays;

// Given an array of integers nums sorted in ascending order, find the starting 
// and ending position of a given target value.
// If target is not found in the array, return [-1, -1].

public class SearchRange {
  public int[] searchRange(int[] nums, int target) {
    int left = 0;
    int right = nums.length-1;
    int mid = 0;
    while (left <= right) {
      mid = left + (right-left)/2;
      if (nums[mid] == target)
        break;
      if (nums[mid] < target)
        left = mid + 1;
      else
        right = mid - 1;
    }
    if (left > right)
      return new int[]{-1,-1};
    int temp = mid+1;
    while (mid >=0) {
      if (nums[mid] == target)
        mid--;
      else {
        break;
      } 
    }
    left = mid + 1;
    mid = temp;
    while (mid <=nums.length-1) {
      if (nums[mid] == target)
        mid++;
      else {
        break;
      } 
    }
    right = mid-1;

    return new int[]{left, right};
  }

  public static void Run() {
    SearchRange f = new SearchRange();
    for (int i : f.searchRange(new int[]{5,7,7,8,8,10}, 8))
      System.out.println(i);
    for (int i : f.searchRange(new int[]{5,7,7,8,8,10}, 6))
      System.out.println(i);
  }
}
