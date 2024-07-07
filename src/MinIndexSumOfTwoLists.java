// Given two arrays of strings list1 and list2, find the common strings with the least index sum.
// A common string is a string that appeared in both list1 and list2.
// A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] 
// then i + j should be the minimum value among all the other common strings.
// Return all the common strings with the least index sum. Return the answer in any order.

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class MinIndexSumOfTwoLists {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Hashtable<String, Integer> hashtable = new Hashtable<>();
    List<String> result = new LinkedList<>();
    int minSum = Integer.MAX_VALUE;
    for (int i=0; i<list1.length; i++)
      hashtable.put(list1[i], i);
    for (int i=0; i<list2.length; i++) {
      if (hashtable.containsKey(list2[i])) {
        Integer index1 = hashtable.get(list2[i]);
        if (minSum == Integer.MAX_VALUE) {
          minSum = index1 + i;
          result.add(list2[i]);
        } else if ((index1 + i) < minSum) {
          minSum = index1 + i;
          result.clear();
          result.add(list2[i]);
        } else if ((index1 + i) == minSum) {
          result.add(list2[i]);
        }
      }
    }
    return result.toArray(new String[0]);
  }

  public static void Run() {
    // generate a test case for findRestaurant
    String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
    String[] result = new MinIndexSumOfTwoLists().findRestaurant(list1, list2);
    for (String s : result)
      System.out.println(s);

    // generate a test case for findRestaurant where the return result contains multiple strings
    list1 = new String[] {"sad", "happy", "good"};
    list2 = new String[] {"happy", "sad", "good"};
    result = new MinIndexSumOfTwoLists().findRestaurant(list1, list2);
    for (String s : result)
      System.out.println(s);
  }
}
