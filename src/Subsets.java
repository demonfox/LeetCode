// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Subsets {

  private List<List<Integer>> result = new LinkedList<List<Integer>>();
  public List<List<Integer>> subsets(int[] nums) {
    Queue<Integer> set = new LinkedList<Integer>();
    for (int i=0; i<nums.length; i++)
      set.add(nums[i]);
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    recursion(set, list);
    return result;
  }

  private void recursion(Queue<Integer> queue, List<Integer> list) {
    if (queue.size() == 0) {
      result.add(list);
      return;
    } else {
      Integer i = queue.poll();
      List<Integer> l = new LinkedList<Integer>(list);
      l.add(i);
      Queue<Integer> q1 = new LinkedList<Integer>(queue);
      Queue<Integer> q2 = new LinkedList<Integer>(queue);
      recursion(q1, list);
      recursion(q2, l);
    }
  }

  public List<List<Integer>> subsets2(int[] nums) {
    int n = nums.length;
    for (int i=(int)Math.pow(2, n); i<(int)Math.pow(2, n+1); i++) {
      int temp = i;
      List<Integer> subset = new LinkedList<Integer>();
      temp &= ((1<<n) - 1);
      int j = 0;
      while(temp != 0) {
        if ((temp & 1) == 1)
          subset.add(nums[j]);
        temp >>= 1;
        j++;
      }
      result.add(subset);
    }
    return result;
  }

  public static void Run() {
    Subsets s = new Subsets();
    List<List<Integer>> result = s.subsets2(new int[]{1,2,3});
    for (List<Integer> l : result) {
      for (Integer i : l) {
        System.out.print(i);
      }
      System.out.println();
    }
  }
}
