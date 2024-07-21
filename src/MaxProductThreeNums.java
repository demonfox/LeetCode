// Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxProductThreeNums {
  
  public int maximumProduct(int[] nums) {
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
  // this method using heap in incomplete; it's a bit messy, not as clean as the first one, but it should be faster when completed
  public int maximumProduct1(int[] nums) {
    if (nums.length == 3) return nums[0] * nums[1] * nums[2];
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i=0; i<nums.length; i++) {
      if (nums[i] >= 0) {
        if (minHeap.size() < 3) {
          minHeap.add(nums[i]);
        } else {
          if (nums[i] > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(nums[i]);
          }
        }
      } else {
        if (maxHeap.size() < 3) {
          maxHeap.add(nums[i]);
        } else {
          if (nums[i] < maxHeap.peek()) {
            maxHeap.poll();
            maxHeap.add(nums[i]);
          }
        }
      }
    }
    int result = Integer.MIN_VALUE;
    int productOfTwo = Integer.MIN_VALUE;
    if (minHeap.size() == 3) {
      int temp1 = minHeap.poll();
      int temp2 = minHeap.poll();
      int temp3 = minHeap.poll();
      if (temp2 > temp3) {
        result = temp2;
        productOfTwo = temp1 * temp3;
      } else {
        result = temp3;
        productOfTwo = temp1 * temp2;
      }
    } else if(minHeap.size() == 2) {
      minHeap.poll();
      result = minHeap.poll();
    } else if (minHeap.size() == 1) {
      result = minHeap.poll();
    }

    if (maxHeap.size() >= 2) {
      int temp1 = maxHeap.poll();
      int temp2 = maxHeap.poll();
      int temp3 = maxHeap.poll();
      if (result == Integer.MIN_VALUE) {
        return temp1 * temp2 * temp3;
      }
    }
    return result * productOfTwo;
  }

  public static void Run() {
    MaxProductThreeNums m = new MaxProductThreeNums();
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
