// Given an unsorted integer array nums, find the smallest missing positive integer.

public class FirstMissingPositive {
  public int firstMissingPositive(int[] nums) {
    // First observe that the answer must be in the range of [1...n]
    // This is because there are n numbers in the array. If the array happen to be
    // all n numbers from 1 to n, then our answer is n+1. Otherwise, the smallest 
    // number within the range [1...n] will be our answer.
    // nums: A[0], A[1], A[2], ... A[n-1]
    //    i:  0  ,  1  ,  2  , ...  n-1
    // A[i]:  1  ,  2  ,  3  , ...   n
    int i=0;
    while (i < nums.length) {
      if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == i+1)
        // if the num is non-positive or greater than n or it's already at the right position
        // then we just move on since this number will not be the answer anyway
        i++;
      else if(nums[nums[i]-1] != nums[i]) {
        // now that we know nums[i] is not at the right position, so let's move it to the right position
        // What is its right position? Well, it should be at nums[nums[i]-1] because at position
        // "nums[i]-1", the right value is "nums[i]-1+1 = nums[i]".
        // Notice that we are not advancing i here since after the swap, we need to re-examine the new
        // value for nums[i] (at position i). nums[i] just got a new value, namely, the value originally
        // at position "nums[i]-1": nums[nums[i]-1]
        // However, be careful about one thing: that is, what if the value at "nums[i]-1" is already
        // nums[i]? Well, we should not do the swap then because it is basically not doing anything,
        // and we will be stuck here doing swaps endlessly.
        int t  = nums[nums[i]-1];
        nums[nums[i]-1] = nums[i];
        nums[i] = t;
      } else
        // Position "nums[i]-1" has already got the right value. We are missing the value "i+1"
        // for now. We will leave it as this is a potential candidate for the answer.
        i++;
    }

    // find the smallest candidate where nums[i] != i+1
    for (i=0; i<nums.length; i++)
      if (nums[i] != i+1)
        break;
    return i+1;
  }

  public int firstMissingPositive2(int[] nums) {
    // the previous solution can be a little hard to understand, so let's use a simpler logic:
    // the basic observation is the same, but instead of doing swapping, we will go through the 
    // array, then mark the value at position "nums[i]-1" to be negative, indicating that for
    // that position, the corresponding value "nums[i]" exists.
    // Let's see an example: suppose we are at position i=3, and nums[3] = 19. We can now mark
    // the value at positon 19-1=18 to be -19 to indicate that 19 exists (and cannot possibly be
    // the answer).
    // Of course, we need to check for some boundary to ensure nums[i] is within the range of
    // [1...n]. If not, we will set nums[i] to be n+1, that is, the best answer outisde the range [1...n]
    for (int i=0; i<nums.length; i++) {
      if (nums[i] <= 0 || nums[i] > nums.length)
        nums[i] = nums.length+1;
    }
    for (int i=0; i<nums.length; i++) {
      int pos = Math.abs(nums[i])-1;
      if (pos < nums.length) {
        nums[pos] = (nums[pos] > 0) ? -nums[pos] : nums[pos];
      }
    }

    for (int i=0; i<nums.length; i++) {
      if (nums[i] > 0)
        return i+1;
    }

    return nums.length+1;
  }

  public static void Run() {
    FirstMissingPositive f = new FirstMissingPositive();
    System.out.println(f.firstMissingPositive2(new int[]{1,2,0}));
    System.out.println(f.firstMissingPositive2(new int[]{3,4,-1,1}));
  }
}
