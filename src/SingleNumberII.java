// Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the 
// single element and return it.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

public class SingleNumberII {
  public int singleNumber(int[] nums) {
    int ones = 0, twos = 0;
    for (int i=0; i<nums.length; i++) {
      // key to understand the solution is:
      // A^B = B^A
      // A^B^C = A^(B^C) = (A^B)^C
      // this means you can re-arrange the numbers so that the same number will be grouped
      // together and what you want to do is to for a sequenece of 3, say A A A, after you apply your
      // XOR operation, you will get 0, whereas for the one number that appears once, you will get it as the final result
      ones = (ones ^ nums[i]) & ~twos;
      twos = (twos ^ nums[i]) & ~ones;
      // let's see how the above two lines work
      // the idea is: 
      // for the 1st iteration, ones = 1, twos = 0
      // for the 2nd iteration, ones = 0, twos = 1
      // for the 3rd iteration, ones = 0, twos = 0
      // Example: 1 1 1 2
      // first iteration:
      // ones = 0001
      // twos = 0000
      // second iteration:
      // ones = 0000
      // twos = 0001
      // third iteration:
      // ones = 0000
      // twos = 0000
    }

    return ones;
  }

  public static void Run() {
    int[] nums = {2,2,3,2};
    SingleNumberII sn = new SingleNumberII();
    System.out.println(sn.singleNumber(nums));
    nums = new int[] {0,1,0,1,0,1,99};
    System.out.println(sn.singleNumber(nums));
  }
}
