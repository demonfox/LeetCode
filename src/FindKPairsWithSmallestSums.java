import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    if (nums1.length > nums2.length) {
      int[] temp = nums2;
      nums2 = nums1;
      nums1 = temp;
    }
    // For min heap: smaller sums come first
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
    // the element of pq is an array of 3 values:
    // 0 - the (row) value of nums1
    // 1 - the (column) value of nums2
    // 2 - the current column index of row i  
    for (int i=0; i<nums1.length; i++) {
      pq.offer(new int[]{nums1[i], nums2[0], 0});
    }
    List<List<Integer>> result = new ArrayList<>();
    while (k-- > 0) {
      int[] curr = pq.poll();
      result.add(Arrays.asList(curr[0], curr[1]));
      if (curr[2] == nums2.length - 1) continue;
      pq.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
    }
    return result;
  }

  public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
    PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> pair1, List<Integer> pair2) {
        int sum1 = pair1.get(0) + pair1.get(1);
        int sum2 = pair2.get(0) + pair2.get(1);
        // For max heap: greater sums come first
        return sum2 - sum1;
      }
    });

    for (int i=0; i<nums1.length; i++) {
      for (int j=0; j<nums2.length; j++) {
        if (maxHeap.size() < k) {
          List<Integer> newItem = new ArrayList<>();
          newItem.add(nums1[i]);
          newItem.add(nums2[j]);
          maxHeap.offer(newItem);
          continue;
        }
        List<Integer> maxVal = maxHeap.peek();
        if ((nums1[i] + nums2[j]) < maxVal.get(0) + maxVal.get(1)) {
          maxHeap.poll();
          List<Integer> newItem = new ArrayList<>();
          newItem.add(nums1[i]);
          newItem.add(nums2[j]);
          maxHeap.offer(newItem);
        } else {
          if (j == 0) {
            List<List<Integer>> result = new ArrayList<>();
            while (!maxHeap.isEmpty()) {
              result.add(0, maxHeap.poll());
            }
            return result;
          } else {
            break;
          }
        }
      }
    }

    return new ArrayList<>(maxHeap); // you should not get here
  }

  public static void Run() {
    FindKPairsWithSmallestSums solution = new FindKPairsWithSmallestSums();
    int[] nums1 = {1, 7, 11};
    int[] nums2 = {2, 4, 6};
    int k = 3;
    List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
    System.out.println(result);

    int[] nums3 = {1, 1, 2};
    int[] nums4 = {1, 2, 3};
    k = 2;
    result = solution.kSmallestPairs(nums3, nums4, k);
    System.out.println(result);
  }
}
