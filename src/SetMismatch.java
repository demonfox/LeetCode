// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, 
// one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss 
// of another number.
// You are given an integer array nums representing the data status of this set after the error.
// Find the number that occurs twice and the number that is missing and return them in the form of an array.

import java.util.Arrays;

public class SetMismatch {
  // public int[] findErrorNums(int[] nums) {
  //   int[] result = new int[2];
  //   HashSet<Integer> set = new HashSet<Integer>();
  //   for (int i = 0; i < nums.length; i++)
  //     set.add(i+1);
  //   for (int j = 0; j < nums.length; j++) {
  //     if (set.contains(nums[j])) {
  //       set.remove(nums[j]);
  //     } else {
  //       result[0] = nums[j];
  //     }
  //   }
  //   result[1] = set.iterator().next();
  //   return result;
  // }

  public int[] findErrorNums(int[] nums) {
    int[] result = new int[2];
    int[] count = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]-1]++;
    }
    for (int i=0; i < count.length; i++) {
      if (count[i] == 2) {
        result[0] = i+1;
      } else if (count[i] == 0) {
        result[1] = i+1;
      }
    }
    return result;
  }
      

  public static void Run() {
    SetMismatch sm = new SetMismatch();
    int[] nums = new int[]{1,2,2,4};
    int[] result = sm.findErrorNums(nums);
    System.out.println(Arrays.toString(result));
    nums = new int[]{1,1};
    result = sm.findErrorNums(nums);
    System.out.println(Arrays.toString(result));
    nums = new int[]{2,2};
    result = sm.findErrorNums(nums);
    System.out.println(Arrays.toString(result));
    nums = new int[]{3,2,2};
    result = sm.findErrorNums(nums);
    System.out.println(Arrays.toString(result));
    nums = new int[]{3,2,3,4,6,5};
    result = sm.findErrorNums(nums);
    System.out.println(Arrays.toString(result));
  }
}
