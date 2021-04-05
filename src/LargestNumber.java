// Given a list of non-negative integers nums, arrange them such that they form the largest number.
// Note: The result may be very large, so you need to return a string instead of an integer.

import java.util.Arrays;

public class LargestNumber {
  public String largestNumber(int[] nums) {
    String[] strs = new String[nums.length];
    for (int i=0; i<nums.length; i++)
      strs[i] = String.valueOf(nums[i]);

    // The key for this algorithm to be correct is to show the transitivity of this String
    // comparision logic, that is, if s1 > s2 (in the following new sense), and s2 > s3, 
    // then s1 must > s3.
    Arrays.sort(strs, (s1, s2) -> {
      String s1s2 = s1 + s2;
      String s2s1 = s2 + s1;
      return s2s1.compareTo(s1s2);
    });

    String result = String.join("", strs);
    return (result.charAt(0) == '0' ? "0" : result);
  }

  public static void Run() {
    LargestNumber l = new LargestNumber();
    System.out.println(l.largestNumber(new int[] { 3, 30, 34, 5, 9 }));
    System.out.println(l.largestNumber(new int[] { 10, 2 }));
    System.out.println(l.largestNumber(new int[] { 1 }));
    System.out.println(l.largestNumber(new int[] { 10 }));
    System.out.println(l.largestNumber(new int[] { 0, 0 }));
    System.out.println(l.largestNumber(new int[] { 0, 0, 1 }));
    System.out.println(l.largestNumber(new int[] {74,21,33,51,77,51,90,60,5,56}));
  }
}
