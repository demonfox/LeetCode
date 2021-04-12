// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the 
// range that is missing from the array.
// Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

public class MissingNumber {
  public int missingNumber(int[] nums) {
    for (int i = 0; i < nums.length;) {
      if (nums[i] == nums.length || nums[i] == i)
        i++;
      else {
        // move nums[i] to location nums[nums[i]] to indicate that nums[i] is at the
        // right place (and therefore cannot possibly be the answer)
        int temp = nums[nums[i]];
        nums[nums[i]] = nums[i];
        nums[i] = temp;
        // notice here we are not incrementing i since we just swapped a new value into
        // position i
        // so we need to examine it again
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i)
        return i;
    }
    return nums.length;
  }

  public int missingNumber2(int[] nums) {
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
        missing ^= i ^ nums[i];
    }
    return missing;
  }

  public int missingNumber3(int[] nums) {
    int sum1 = 0, sum2 = 0;
    for (int i = 0; i < nums.length; i++) {
      sum1 += nums[i];
      sum2 += i+1;
    }
    return sum2 - sum1;
  }

  public static void Run() {
    MissingNumber m = new MissingNumber();
    System.out.println(m.missingNumber(new int[] { 3, 0, 1 }));
    System.out.println(m.missingNumber2(new int[] { 3, 0, 1 }));
    System.out.println(m.missingNumber3(new int[] { 3, 0, 1 }));
    System.out.println(m.missingNumber(new int[] { 0, 1 }));
    System.out.println(m.missingNumber2(new int[] { 0, 1 }));
    System.out.println(m.missingNumber3(new int[] { 0, 1 }));
    System.out.println(m.missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
    System.out.println(m.missingNumber2(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
    System.out.println(m.missingNumber3(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
    System.out.println(m.missingNumber(new int[] { 0 }));
    System.out.println(m.missingNumber2(new int[] { 0 }));
    System.out.println(m.missingNumber3(new int[] { 0 }));
  }
}
