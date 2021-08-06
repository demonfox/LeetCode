// Given an integer array nums, return true if there exists a triple of indices (i, j, k) 
// such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.


public class IncreasingTripletSubsequence {
  // the idea is to do one pass from left to right and one pass from right to left
  // the first pass is to construct an array L, where L[i] is the smallest value we have seen
  // since starting from the left
  // the second pass is to construct an array H, where H[i] is the largest value we have seen
  // since starting from the right
  // then we iterate through L & H and if we find an element nums[i] such that L[i] < nums[i] < H[i]
  // then we are done
  public boolean increasingTriplet2(int[] nums) {
    int[] L = new int[nums.length];
    int[] H = new int[nums.length];
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] < min)
        min = L[i] = nums[i];
      else
        L[i] = min;
    }
    for (int i=nums.length-1; i>=0; i--) {
      if (nums[i] > max)
        max = H[i] = nums[i];
      else
        H[i] = max;
    }
    for (int i=0; i<nums.length; i++) {
      if (L[i] < nums[i] && nums[i] < H[i])
        return true;
    }
    return false;
  }

  // now that we have the basic idea right, we can actually optimize the above, which may not seem
  // obvious, but should become attainable once we understand the algorithm above
  public boolean increasingTriplet(int[] nums) {
    int[] H = new int[nums.length];
    int max = Integer.MIN_VALUE;
    for (int i=nums.length-1; i>=0; i--) {
      if (nums[i] > max)
        max = H[i] = nums[i];
      else
        H[i] = max;
    }
    int min = Integer.MAX_VALUE;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] < min)
        min = nums[i];
      if (min < nums[i] && nums[i] < H[i])
        return true;
    }
    return false;
  }

  public static void Run() {
    IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
    System.out.println(i.increasingTriplet(new int[]{1,2,3,4,5}));
    System.out.println(i.increasingTriplet(new int[]{5,4,3,2,1}));
    System.out.println(i.increasingTriplet(new int[]{2,1,5,0,4,6}));
  }
}
