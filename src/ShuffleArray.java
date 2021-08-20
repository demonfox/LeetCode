// Given an integer array nums, design an algorithm to randomly shuffle the array. 
// All permutations of the array should be equally likely as a result of the shuffling.
// Implement the Solution class:
// Solution(int[] nums) Initializes the object with the integer array nums.
// int[] reset() Resets the array to its original configuration and returns it.
//int[] shuffle() Returns a random shuffling of the array.

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
  private int[] array;
  Random random = new Random();

  public ShuffleArray(int[] nums) {
    array = nums;
  }
  
  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return array;  
  }
  
  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int[] result = array.clone();
    for (int i=0; i<array.length; i++) {
      swapAt(result, i, i + random.nextInt(array.length - i));
    }
    return result;
  }

  private void swapAt(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp; 
  }

  public static void Run() {
    ShuffleArray s = new ShuffleArray(new int[]{1,2,3,4,5});
    System.out.println(Arrays.toString(s.shuffle()));
    System.out.println(Arrays.toString(s.shuffle()));
    System.out.println(Arrays.toString(s.shuffle()));
    System.out.println(Arrays.toString(s.shuffle()));
    System.out.println(Arrays.toString(s.shuffle()));
    System.out.println(Arrays.toString(s.reset()));
  }
}
