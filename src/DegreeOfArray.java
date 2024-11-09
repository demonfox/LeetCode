// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of 
// its elements.
// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

import java.util.HashMap;

public class DegreeOfArray {
  class Element {
    public int count;
    public int firstIndex;
    public int lastIndex;
  }
  public int findShortestSubArray(int[] nums) {
    HashMap<Integer, Element> hm = new HashMap<>();
    int degree = 0;
    int maxFreqVal = -1;
    Element ele;
    for (int i = 0; i < nums.length; i++) {
      int curr = nums[i];
      if (hm.containsKey(curr)) {
        ele = hm.get(curr);
        ele.count++;
        ele.lastIndex = i;
      } else {
        ele = new Element();
        ele.count = 1;
        ele.firstIndex = i;
        ele.lastIndex = i;
        hm.put(curr, ele);
      }
      if (ele.count > degree) {
        degree = ele.count;
        maxFreqVal = curr;
      } else if (ele.count == degree) {
        if (ele.lastIndex - ele.firstIndex < hm.get(maxFreqVal).lastIndex - hm.get(maxFreqVal).firstIndex) {
          maxFreqVal = curr;
        }
      }
    }
    return hm.get(maxFreqVal).lastIndex - hm.get(maxFreqVal).firstIndex + 1;
  }

  public static void Run() {
    DegreeOfArray obj = new DegreeOfArray();
    int[] nums = {1,2,2,3,1,4,2};
    System.out.println(obj.findShortestSubArray(nums));
    nums = new int[] {1,2,2,3,1,4,2,3,3,4,2};
    System.out.println(obj.findShortestSubArray(nums));
    nums = new int[] {2,1,1,2,1,3,3,3,1,3,1,3,2};
    System.out.println(obj.findShortestSubArray(nums));
  }
}
