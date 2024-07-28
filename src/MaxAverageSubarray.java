// You are given an integer array nums consisting of n elements, and an integer k.
// Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. 
// Any answer with a calculation error less than 10-5 will be accepted.
public class MaxAverageSubarray {
  public double findMaxAverage(int[] nums, int k) {
    double sum = 0;
    for (int i=0; i<k; i++) {
      sum += nums[i];
    }
    double maxAverage = sum / k;
    for (int i=k; i<nums.length; i++) {
      sum += nums[i] - nums[i-k];
      maxAverage = Math.max(maxAverage, sum / k);
    }
    return maxAverage;
  }

  public static void Run() {
    MaxAverageSubarray maxAverageSubarray = new MaxAverageSubarray();
    int[] nums = {1,12,-5,-6,50,3};
    int k = 4;
    System.out.println(maxAverageSubarray.findMaxAverage(nums, k));

    nums = new int[] {5};
    k = 1;
    System.out.println(maxAverageSubarray.findMaxAverage(nums, k));
  }
}
