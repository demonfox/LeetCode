// Given an integer array nums with possible duplicates, randomly output the index of a given target number. You can assume that the given target 
// number must exist in the array.
// Implement the Solution class:
// Solution(int[] nums) Initializes the object with the array nums.
// int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's, then each index should have an 
// equal probability of returning.

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomPickIndex {
  private HashMap<Integer, List<Integer>> map = new HashMap<>();
  private int[] nums;
  // public RandomPickIndex(int[] nums) {
  //   for (int i=0; i<nums.length; i++) {
  //     if (map.containsKey(nums[i])) {
  //       map.get(nums[i]).add(i);
  //     } else {
  //       List<Integer> indices = new LinkedList<Integer>();
  //       indices.add(i);
  //       map.put(nums[i], indices);
  //     }
  //   }
  // }

  // naive solution
  public int pick1(int target) {
    List<Integer> indices = map.get(target);
    Random random = new Random();
    return indices.get(random.nextInt(indices.size()));
  }

  public RandomPickIndex(int[] nums) {
    this.nums = nums;
  }
  
  // reservoir sampling
  public int pick(int target) {
    int count = 0;
    int result = 0;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] == target) {
        count++;
        if (new Random().nextInt(count) == 0) {
          result = i;
        }
      }
    }
    return result;
  }

  public static void Run() {
    RandomPickIndex r = new RandomPickIndex(new int[] {1,2,3,3,3});
    System.out.println(r.pick(3));
    System.out.println(r.pick(3));
    System.out.println(r.pick(3));
    System.out.println(r.pick(1));
    System.out.println(r.pick(2));
  }
}
