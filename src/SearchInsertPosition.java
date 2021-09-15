// Given a sorted array of distinct integers and a target value, return the index if the 
// target is found. If not, return the index where it would be if it were inserted in order.
// You must write an algorithm with O(log n) runtime complexity.

public class SearchInsertPosition {
  public int searchInsert(int[] nums, int target) {
    int l = 0, r = nums.length-1, m = -1;
    boolean lastMoveIsL = true;
    while (l <= r) {
      m = l + (r - l) / 2;
      if (nums[m] == target)
        return m;
      if (nums[m] < target) {
        lastMoveIsL = true;
        l = m + 1;
      } else {
        lastMoveIsL = false;
        r = m - 1;
      }
    }

    if (lastMoveIsL)
      return m + 1;
    else
      return m;
  }

  public static void Run() {
    SearchInsertPosition s = new SearchInsertPosition();
    System.out.println(s.searchInsert(new int[]{1,3}, 0));
    System.out.println(s.searchInsert(new int[]{1,3,5,6}, 5));
    System.out.println(s.searchInsert(new int[]{1,3,5,6}, 2));
    System.out.println(s.searchInsert(new int[]{1,3,5,6}, 7));
    System.out.println(s.searchInsert(new int[]{1,3,5,6}, 0));
    System.out.println(s.searchInsert(new int[]{1}, 0));
  }
}
