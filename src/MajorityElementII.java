// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

import java.util.LinkedList;
import java.util.List;

public class MajorityElementII {
  public List<Integer> majorityElement(int[] nums) {
    int index = 0;
    int[] candidate = new int[2];
    int[] count = new int[2];
    for (int i=0; i<nums.length; i++) {
      if (index == 0) {
        candidate[0] = nums[i];
        count[0] = 1;
        index++;
      } else if (index == 1) {
        if (candidate[0] == nums[i]) {
          count[0]++;
        } else {
          candidate[1] = nums[i];
          count[1] = 1;
          index++;
        }
      } else { // index == 2
        if (candidate[0] == nums[i]) {
          count[0]++;
          continue;
        }
        if (candidate[1] == nums[i]) {
          count[1]++;
          continue;
        }
        if (count[1] == 1)
          index--;
        else
          count[1]--;
        if (count[0] == 1) {
          if (index == 1)
            index--;
          else {
            candidate[0] = candidate[1];
            count[0] = count[1];
            index--;
          }
        } else
          count[0]--;
      }
    }

    List<Integer> result = new LinkedList<>();
    for (int i=0; i<index; i++) {
      int temp = 0;
      for (int j=0; j<nums.length; j++) {
        if (nums[j] == candidate[i])
          temp++;
      }
      if (temp > nums.length / 3)
        result.add(candidate[i]);
    }
    return result;
  }

  public static void Run() {
    MajorityElementII m = new MajorityElementII();
    System.out.println(m.majorityElement(new int[] {3,2,3}));
    System.out.println(m.majorityElement(new int[] {1,1,1,3,3,2,2,2}));
    System.out.println(m.majorityElement(new int[] {5,1,1,1,1,1,1,5,2,3,4}));
    System.out.println(m.majorityElement(new int[] {5,1,1,1,1,1,1,5,2,3,4,5,5,5,5,5}));
  }
}
