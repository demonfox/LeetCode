// You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] 
// = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
// Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, 
// where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b) {
        // First compare by first dimension
        if (a[0] != b[0]) {
          return Integer.compare(a[0], b[0]);
        }
        // If first dimensions are equal, compare by second dimension
        return Integer.compare(a[1], b[1]);
      }
    });
    int[][] result = new int[people.length][2];
    for (int i=0; i<people.length; i++)
        result[i][0] = -1; // just to indicate this slot is not used

    for (int i=0; i<people.length; i++) {
      int resultIndex = 0;
      int counter = -1;
      while (resultIndex < people.length) {
        if (result[resultIndex][0] == -1 || result[resultIndex][0] == people[i][0])
          counter++;
        if (counter == people[i][1])
          break;
        resultIndex++;
      }
      result[resultIndex][0] = people[i][0];
      result[resultIndex][1] = people[i][1];
    }
    return result;
  }

  public static void Run() {
    QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
    int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
    int[][] result = queueReconstructionByHeight.reconstructQueue(people);
    for (int i=0; i<result.length; i++) {
      System.out.println(result[i][0] + " " + result[i][1]);
    }
  }
}
