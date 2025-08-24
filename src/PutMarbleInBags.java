import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class PutMarbleInBags {
  public long putMarbles(int[] weights, int k) {
    int[] splits = new int[weights.length-1];
    for (int i=0; i<weights.length-1; i++) {
      splits[i] = weights[i] + weights[i+1];
    }
    Arrays.sort(splits);
    // this works if we want to calcuate maxScore and minScore, but we will do the minimun to get the answer
    // maxScore = minScore = weights[0] + weights[weights.length-1];
    // for (int i=0; i<k-1; i++) {
    //   maxScore += splits[splits.length-1-i];
    //   minScore += splits[i];
    // }
    long result = 0;
    for (int i=0; i<k-1; i++) {
      result += splits[splits.length-1-i] - splits[i];
    }
    return result;
  }

  public long putMarbles1(int[] weights, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for (int i=0; i<weights.length-1; i++) {
      minHeap.offer(weights[i] + weights[i+1]);
      maxHeap.offer(weights[i] + weights[i+1]);
    }
    long result = 0;
    for (int i=0; i<k-1; i++) {
      result += maxHeap.poll() - minHeap.poll();
    }
    return result;
  }
  public static void Run() {
    PutMarbleInBags solution = new PutMarbleInBags();
    int[] weights = {1, 4, 2, 5, 2};
    int k = 3;
    System.out.println("Max score difference: " + solution.putMarbles1(weights, k));
    weights = new int[]{1, 3, 5, 1};
    k = 2;
    System.out.println("Max score difference: " + solution.putMarbles1(weights, k));
    weights = new int[] {1, 3};
    k = 2;
    System.out.println("Max score difference: " + solution.putMarbles1(weights, k));
  }
}

