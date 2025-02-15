// You are given an integer array nums and an integer k.
// In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x where x is an 
// integer from the range [-k, k]. You can apply this operation at most once for each index i.
// The score of nums is the difference between the maximum and minimum elements in nums.
// Return the minimum score of nums after applying the mentioned operation at most once for each index in it.

public class SmallestRangeI {
  public int smallestRangeI(int[] nums, int k) {
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for (int n : nums) {
      if (n > max)
        max = n;
      if (n < min)
        min = n;
    }
    if ((max - min) <= 2*k)
      return 0;
    else
      return max - min - 2*k;
  }

  public static void Run() {
    SmallestRangeI s = new SmallestRangeI();
    System.out.println(s.smallestRangeI(new int[]{0, 10}, 2));
    System.out.println(s.smallestRangeI(new int[]{1, 3, 6}, 0));
    System.out.println(s.smallestRangeI(new int[]{1, 3, 6}, 1));
    System.out.println(s.smallestRangeI(new int[]{1, 3, 6}, 2));
    System.out.println(s.smallestRangeI(new int[]{1, 3, 6}, 3));
    System.out.println(s.smallestRangeI(new int[]{1, 3, 6}, 4));
    System.out.println(s.smallestRangeI(new int[]{1}, 0));
  }
}
