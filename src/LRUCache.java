// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
// Implement the lruCache class:
// lruCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. 
// Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity 
// from this operation, evict the least recently used key.

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
  LinkedHashMap<Integer, Integer> map;
  int maxSize;

  public LRUCache(int capacity) {
    maxSize = capacity;
    map = new LinkedHashMap<Integer, Integer>(capacity, .75F, true){
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > maxSize;
      }
    };
  }

  public int get(int key) {
    return map.containsKey(key) ? map.get(key) : -1;
  }

  public void put(int key, int value) {
    map.put(key, value);
  }

  public static void Run() {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 1); // cache is {1=1}
    lruCache.put(2, 2); // cache is {1=1, 2=2}
    System.out.println(lruCache.get(1)); // return 1
    lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    System.out.println(lruCache.get(2)); // returns -1 (not found)
    lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    System.out.println(lruCache.get(1)); // return -1 (not found)
    System.out.println(lruCache.get(3)); // return 3
    System.out.println(lruCache.get(4)); // return 4
  }
}
