// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of 
// all the integers in the range [1, n] that do not appear in nums.

import java.util.ArrayList;
import java.util.List;

public class FindNumsDisappeared {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    for (int i=0; i<nums.length; i++) {
      if (nums[i] != 0) {
        int index = nums[i] - 1;
        while (nums[index] != 0) {
          int temp = nums[index] - 1;
          nums[index] = 0;
          index = temp;
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    for (int i=0; i<nums.length; i++) {
      if (nums[i] != 0)
        result.add(i+1);
    }
    return result;
  }

  public static void Run() {
    FindNumsDisappeared f = new FindNumsDisappeared();
    List<Integer> result = f.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    result.forEach(i -> System.out.print(i + " "));
    System.out.println();
  }
}
