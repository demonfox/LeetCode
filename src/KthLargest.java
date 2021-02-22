// Design a class to find the kth largest element in a stream. 
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// Implement KthLargest class:
// KthLargest(int k, int[] nums) 
// - Initializes the object with the integer k and the stream of integers nums.
// int add(int val) 
// - Returns the element representing the kth largest element in the stream.

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> pqueue;
    private int kth;
    
    public KthLargest(int k, int[] nums) {
        pqueue = new PriorityQueue<Integer>();
        kth = k;
        for (int i : nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        if (pqueue.size() < kth) {
            pqueue.add(val);
        } else {
            if (val > pqueue.peek()) {
                pqueue.poll();
                pqueue.add(val);
            }
        }
        return pqueue.peek();
    }

    public static void Run() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}
