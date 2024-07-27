// Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxProductThreeNums {
  
  public int maximumProduct1(int[] nums) {
    if (nums.length == 3) return nums[0] * nums[1] * nums[2];
    Arrays.sort(nums);
    int result = Integer.MIN_VALUE;
    if (nums[nums.length-3] >= 0) {
      result = nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
    }
    if (nums[0] < 0 && nums[1] < 0) {
      result = Math.max(result, nums[0] * nums[1] * nums[nums.length-1]);
    }
    if(nums[nums.length-1] <= 0) {
      result = Math.max(result, nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3]);
    }
    return result;
  }

  public int maximumProduct(int[] nums) {
    if (nums.length == 3) return nums[0] * nums[1] * nums[2];
    PriorityQueue<Integer> findMaxPositive = new PriorityQueue<Integer>();
    PriorityQueue<Integer> findMaxNegative = new PriorityQueue<>();
    PriorityQueue<Integer> findMinNegative = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i=0; i<nums.length; i++) {
      if (nums[i] >= 0) {
        if (findMaxPositive.size() < 3) {
          findMaxPositive.add(nums[i]);
        } else {
          if (nums[i] > findMaxPositive.peek()) {
            findMaxPositive.poll();
            findMaxPositive.add(nums[i]);
          }
        }
      } else {
        if (findMaxNegative.size() < 3) {
          findMaxNegative.add(nums[i]);
        } else {
          if (nums[i] > findMaxNegative.peek()) {
            findMaxNegative.poll();
            findMaxNegative.add(nums[i]);
          }
        }

        if (findMinNegative.size() < 2) {
          findMinNegative.add(nums[i]);
        } else {
          if (nums[i] < findMinNegative.peek()) {
            findMinNegative.poll();
            findMinNegative.add(nums[i]);
          }
        }
      }
    }
    int result = Integer.MIN_VALUE;
    int maxPositive = Integer.MIN_VALUE;
    if (findMaxPositive.size() == 3) {
      int temp1 = findMaxPositive.poll();
      int temp2 = findMaxPositive.poll();
      int temp3 = findMaxPositive.poll();
      maxPositive = Math.max(temp2, temp3);
      result = temp1 * temp2 * temp3;
    } else if(findMaxPositive.size() == 2) {
      findMaxPositive.poll();
      maxPositive = findMaxPositive.poll();
    } else if (findMaxPositive.size() == 1) {
      maxPositive = findMaxPositive.poll();
    }

    if (maxPositive >= 0) { // means there is at least one positive number
      if (findMinNegative.size() == 3) {
        findMinNegative.poll();
        int temp2 = findMinNegative.poll();
        int temp3 = findMinNegative.poll();
        result = Math.max(maxPositive * temp2 * temp3, result);
      } else if (findMinNegative.size() == 2) {
        int temp2 = findMinNegative.poll();
        int temp3 = findMinNegative.poll();
        result = Math.max(maxPositive * temp2 * temp3, result);
      }
    } else { // means there is no positive number
      int temp1 = findMaxNegative.poll();
      int temp2 = findMaxNegative.poll();
      int temp3 = findMaxNegative.poll();
      result = temp1 * temp2 * temp3;
    }

    return result;
  }

  public static void Run() {
    MaxProductThreeNums m = new MaxProductThreeNums();
    System.out.println(m.maximumProduct(new int[]{-3, -2, -1, 0, 0, 0, 0}));
    System.out.println(m.maximumProduct(new int[]{-1, -2, -3}));
    System.out.println(m.maximumProduct(new int[]{1, 2, 3}));
    System.out.println(m.maximumProduct(new int[]{1, 2, 3, 4}));
    System.out.println(m.maximumProduct(new int[]{-11, 2, 3, 4}));
    System.out.println(m.maximumProduct(new int[]{-11, -5, 2, 3, 4}));
    System.out.println(m.maximumProduct(new int[]{-11, -5, -1, 0, 2, 3, 4}));
    System.out.println(m.maximumProduct(new int[]{-100, -2, -3, 1}));
    System.out.println(m.maximumProduct(new int[]{-1, -2, -3, -4}));
    System.out.println(m.maximumProduct(new int[]{0, -1, 3, 4}));
  }
}
