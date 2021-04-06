// Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.

import java.util.PriorityQueue;

public class KthLargestElement {
  // using PriorityQueue
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for (int i = 0; i < nums.length; i++) {
      if (q.size() < k) {
        q.add(nums[i]);
      } else if (nums[i] > q.peek()) {
        q.poll();
        q.add(nums[i]);
      }
    }
    return q.peek();
  }

  // using Quick Select
  public int findKthLargest2(int[] nums, int k) {
    return findKthLargest2(nums, k, 0, nums.length-1);
  }

  private int findKthLargest2(int[] nums, int k, int start, int end) {
    int pivot = nums[end];
    int left = start-1;
    for (int i=start; i<end; i++) {
      if (nums[i] < pivot) {
        left++;
        int temp = nums[left];
        nums[left] = nums[i];
        nums[i] = temp;
      }
    }
    left++;
    int temp = nums[left];
    nums[left] = nums[end];
    nums[end] = temp;

    if (nums.length - left == k)
      return nums[left];
    
    if (nums.length - left > k)
      return findKthLargest2(nums, k, left+1, end);
    else
      return findKthLargest2(nums, k, start, left-1);
  }

  public static void Run() {
    KthLargestElement k = new KthLargestElement();
    System.out.println(k.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
    System.out.println(k.findKthLargest2(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
    System.out.println(k.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
    System.out.println(k.findKthLargest2(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
  }
}
