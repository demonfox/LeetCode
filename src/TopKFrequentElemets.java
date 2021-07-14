// Given an integer array nums and an integer k, return the k most frequent elements. You may 
// return the answer in any order.

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElemets {
  public int[] topKFrequent(int[] nums, int k) {
    if (k == nums.length) return nums;

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    // define a Min heap
    PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(
                                      new Comparator<Integer>(){
                                        public int compare(Integer a, Integer b) {
                                          return (map.get(a) == map.get(b)) ? 0 : ((map.get(a) > map.get(b)) ? 1 : -1);
                                        }
                                      });
    // In fact, a better way of wrting this is:
    // PriorityQueue<Integer> pqueue = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
    // But we will leave it like that since the Comparator way seems a bit easier to understand at first glance

    for (Integer n : map.keySet()) {
      pqueue.add(n);
      if (pqueue.size() > k)
        pqueue.poll();
    }

    int[] result = new int[k];
    for (int i=k-1; i>=0; i--)
      result[i] = pqueue.poll();

    return result;
  }

  public static void Run() {
    TopKFrequentElemets t = new TopKFrequentElemets();
    int[] result = t.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    System.out.println(Arrays.toString(result));
    result = t.topKFrequent(new int[]{1}, 1);
    System.out.println(Arrays.toString(result));
    result = t.topKFrequent(new int[]{1,1,1,2,2,3,3,3,3}, 2);
    System.out.println(Arrays.toString(result));
  }
}
