// You are given a binary array nums (0-indexed).
// We define xi as the number whose binary representation is the subarray nums[0..i] (from most-significant-bit 
// to least-significant-bit).
// For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.
// Return an array of booleans answer where answer[i] is true if xi is divisible by 5.

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
  public List<Boolean> prefixesDivBy5(int[] nums) {
    List<Boolean> ans = new ArrayList<>();
    int lastDigit = 0;
    for (int i=0; i<nums.length; i++) {
      lastDigit = ((lastDigit << 1) + nums[i]) % 10;
      if (lastDigit == 0 || lastDigit == 5)
        ans.add(true);
      else
        ans.add(false);
      // Well, this overflows obviously
      // curr = (curr << 1) + nums[i];
      // if (curr % 5 == 0)
      //   ans.add(true);
      // else
      //   ans.add(false);
    }
    return ans;
  }

  public static void Run() {
    BinaryPrefixDivisibleBy5 b = new BinaryPrefixDivisibleBy5();
    System.out.println(b.prefixesDivBy5(new int[] {0,1,1}));
    System.out.println(b.prefixesDivBy5(new int[] {1,1,1}));
    System.out.println(b.prefixesDivBy5(new int[] {1,0,1}));
    System.out.println(b.prefixesDivBy5(new int[] {0,1,1,1,1,1}));
  }
}
