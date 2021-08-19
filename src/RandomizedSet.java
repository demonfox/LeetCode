// Implement the RandomizedSet class:
// RandomizedSet() Initializes the RandomizedSet object.
// bool insert(int val) Inserts an item val into the set if not present. 
// Returns true if the item was not present, false otherwise.
// bool remove(int val) Removes an item val from the set if present. 
// Returns true if the item was present, false otherwise.
// int getRandom() Returns a random element from the current set of elements (it's guaranteed 
// that at least one element exists when this method is called). Each element must have the 
// same probability of being returned.
// You must implement the functions of the class such that each function works in average O(1) time complexity.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
  Map<Integer, Integer> map;
  ArrayList<Integer> array;
  Random random;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    map = new HashMap<Integer, Integer>();
    array = new ArrayList<Integer>();
    random = new Random();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain
   * the specified element.
   */
  public boolean insert(int val) {
    if (map.containsKey(val))
      return false;

    map.put(val, array.size());
    array.add(val);
    return true;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified
   * element.
   */
  public boolean remove(int val) {
    if (!map.containsKey(val))
      return false;

    int index = map.get(val);
    int lastVal = array.get(array.size() - 1);
    array.set(index, lastVal);
    array.remove(array.size() - 1);
    map.put(lastVal, index);
    map.remove(val);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return array.get(random.nextInt(array.size()));
  }

  public static void Run() {
    RandomizedSet randomizedSet = new RandomizedSet();
    System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
    System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
    System.out.println(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
    System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
    System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
    System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
    System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
    System.out.println(randomizedSet.insert(1));
    System.out.println(randomizedSet.insert(3));
    for (int i = 0; i < 10; i++) {
      System.out.print(randomizedSet.getRandom() + " ");
    }
    System.out.println();
  }
}
