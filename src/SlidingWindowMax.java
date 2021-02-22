// You are given an array of integers nums, there is a sliding window of 
// size k which is moving from the very left of the array to the very right. 
// You can only see the k numbers in the window. Each time the sliding window 
// moves right by one position.
// Return the max sliding window.

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int rIndex = 0;
        Deque<Integer> window = new LinkedList<Integer>();
        for (int i=0; i<nums.length; i++) {
            if (i >= k && window.peekFirst() <= i - k) {
                window.pollFirst();
            }
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }
            window.addLast(i);
            // when i is at index (k-1), we have got our first sliding window
            // filled up and we are ready to add to the result set
            if (i >= k-1)
                result[rIndex++] = nums[window.peekFirst()];
        }
        return result;
    }

    public static void Run() {
        SlidingWindowMax s = new SlidingWindowMax();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, 3)));
        nums = new int[]{1};
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, 1)));
        nums = new int[]{1,-1};
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, 1)));
        nums = new int[]{9,11};
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, 2)));
        nums = new int[]{7,2,4};
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, 2)));
    }
}
