// Design a HashSet without using any built-in hash table libraries.
// Implement MyHashSet class:
// void add(key) Inserts the value key into the HashSet.
// bool contains(key) Returns whether the value key exists in the HashSet or not.
// void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

import java.util.LinkedList;

public class MyHashSet {
  LinkedList<Integer>[] bucketArray;
  public MyHashSet() {
    bucketArray = new LinkedList[1000];
    for (int i = 0; i < bucketArray.length; i++) {
      bucketArray[i] = new LinkedList<Integer>();
    }
  }
  
  public void add(int key) {
    int index = key % bucketArray.length;
    if (bucketArray[index].contains(key))
      return;
    bucketArray[index].add(key);
  }
  
  public void remove(int key) {
    int index = key % bucketArray.length;
    if (!bucketArray[index].contains(key))
      return;
    bucketArray[index].remove(Integer.valueOf(key));
  }
  
  public boolean contains(int key) {
    int index = key % bucketArray.length;
    return bucketArray[index].contains(key);
  }

  public static void Run() {
    MyHashSet hs = new MyHashSet();
    hs.add(1);
    hs.add(2);
    System.out.println(hs.contains(1));
    System.out.println(hs.contains(3));
    hs.add(2);
    System.out.println(hs.contains(2));
    hs.remove(2);
    System.out.println(hs.contains(2));
  }
}
