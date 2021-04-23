// You are given an integer array nums and you have to return a new counts array. The counts array 
// has the property where counts[i] is the number of smaller elements to the right of nums[i].

import java.net.CookieHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class CountOfSmallerNumAfter {
  // The naive O(n^2) solution is easy to implement. We want to speed that up a bit.
  public List<Integer> countSmaller(int[] nums) {
    List<Integer> result = new LinkedList<>();
    SortedSet<Integer> s = new TreeSet<>();
    for (int i : nums)
      s.add(i);

    Map<Integer, Integer> ranks = new HashMap<Integer, Integer>();
    int rank = 0;
    for (Integer i : s)
      ranks.put(i, ++rank);

    FenwickTree ftree = new FenwickTree(ranks.size());
    for (int i = nums.length - 1; i >= 0; i--) {
      result.add(0, ftree.query(ranks.get(nums[i])-1));
      ftree.update(ranks.get(nums[i]), 1);
    }

    return result;
  }

  class Item {
    int val;
    int index;
    public Item(int v, int i) {
      val = v;
      index = i;
    }
  }
  public List<Integer> countSmaller2(int[] nums) {
    Item[] items = new Item[nums.length];
    for (int i=0; i<nums.length; i++)
      items[i] = new Item(nums[i], i);
    int[] counts = new int[nums.length];

    mergeSort(items, 0, nums.length-1, counts);
    
    List<Integer> result = new LinkedList<>();
    for (int c : counts)
      result.add(c);
    return result;
  }

  private void mergeSort(Item[] items, int l, int h, int[] counts) {
    if (l >= h)
      return;
    int m = l + (h - l) / 2;
    mergeSort(items, l, m, counts);
    mergeSort(items, m+1, h, counts);
    merge(items, l, m, m+1, h, counts);
  }

  private void merge(Item[] items, int l, int le, int h, int he, int[] counts) {
    Item[] mergedItems = new Item[he - l + 1];
    int lPtr = l, hPtr = h;
    int largerThanCounter = 0;
    int i = 0;
    while (lPtr <= le && hPtr <= he) {
      if (items[hPtr].val < items[lPtr].val) {
        largerThanCounter++;
        mergedItems[i++] = items[hPtr++];
      } else {
        counts[items[lPtr].index] += largerThanCounter;
        mergedItems[i++] = items[lPtr++];
      } 
    }
    while (lPtr <= le) {
      counts[items[lPtr].index] += largerThanCounter;
      mergedItems[i++] = items[lPtr++];
    }
    while (hPtr <= he) {
      mergedItems[i++] = items[hPtr++];
    }
    System.arraycopy(mergedItems, 0, items, l, he - l + 1);
  }

  public static void Run() {
    CountOfSmallerNumAfter c = new CountOfSmallerNumAfter();
    List<Integer> result = c.countSmaller(new int[] { 5, 2, 6, 1 });
    result.forEach(i -> System.out.print(i + " "));
    System.out.println();
    result = c.countSmaller2(new int[] { 5, 2, 6, 1 });
    result.forEach(i -> System.out.print(i + " "));
    System.out.println();
    result = c.countSmaller(new int[] { -1 });
    result.forEach(i -> System.out.print(i + " "));
    System.out.println();
    result = c.countSmaller2(new int[] { -1 });
    result.forEach(i -> System.out.print(i + " "));
    System.out.println();
    result = c.countSmaller(new int[] { -1, -1 });
    result.forEach(i -> System.out.print(i + " "));
    System.out.println();
    result = c.countSmaller2(new int[] { -1, -1});
    result.forEach(i -> System.out.print(i + " "));
    System.out.println();
  }
}
