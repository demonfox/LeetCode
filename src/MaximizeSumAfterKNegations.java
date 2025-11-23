// Given an integer array nums and an integer k, modify the array in the following way:
// choose an index i and replace nums[i] with -nums[i].
// You should apply this process exactly k times. You may choose the same index i multiple times.
// Return the largest possible sum of the array after modifying it in this way.

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximizeSumAfterKNegations {
  public int largestSumAfterKNegations(int[] nums, int k) {
    // As we traverse through the array we keep track of 2 things:
    // 1. # of negative numbers or the number of times we have applied negations
    // 2. the smallest non-negative number as if we have any negations left (odd number of times of course), we will apply to this number
    int result = 0;
    int smallestNonNegative = Integer.MAX_VALUE;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int i=0; i<nums.length; i++) {
      if (nums[i] >= 0) {
        smallestNonNegative = Math.min(smallestNonNegative, nums[i]);
        result += nums[i];
      } else {
        if (k > 0) {
          k--;
          result -= nums[i];
          pq.add(nums[i]);
          smallestNonNegative = Math.min(smallestNonNegative, -nums[i]);
        } else {
          // we have run out of negations, so we are going to save the precious negations for the "more negative" numbers
          if (nums[i] < pq.peek()) {
            Integer temp = pq.poll();
            result += (2 * temp);
            result -= nums[i];
            pq.add(nums[i]);
          } else {
            result += nums[i];
          }
        }
      }
    }
    if (k > 0) {
      // if we still have negations left, we will apply it to the smallest non-negative number if it's odd number of times left
      if (k % 2 == 1) {
        result -= (2 * smallestNonNegative);
      }
    }

    return result;
  }

  public static void Run() {
    MaximizeSumAfterKNegations solution = new MaximizeSumAfterKNegations();
    int[] nums = {4,2,3};
    int k = 1;
    System.out.println(solution.largestSumAfterKNegations(nums, k));
    nums = new int[] {3,-1,0,2};
    k = 3;
    System.out.println(solution.largestSumAfterKNegations(nums, k));
    nums = new int[] {2,-3,-1,5,-4};
    k = 2;
    System.out.println(solution.largestSumAfterKNegations(nums, k));
    nums = new int[] {-100, -100, -100};
    k = 4;
    System.out.println(solution.largestSumAfterKNegations(nums, k));
    nums = new int[] {-8, 3, -5, -3, -5, -2};
    k = 6;
    System.out.println(solution.largestSumAfterKNegations(nums, k));
    nums = new int[] {5, 8, -9, 9, -7, 3, -2, 5};
    k = 2;
    System.out.println(solution.largestSumAfterKNegations(nums, k));
  }
}
