// An n-bit gray code sequence is a sequence of 2n integers where:
// Every integer is in the inclusive range [0, 2n - 1],
// The first integer is 0,
// An integer appears no more than once in the sequence,
// The binary representation of every pair of adjacent integers differs by exactly one bit, and
// The binary representation of the first and last integers differs by exactly one bit.
// Given an integer n, return any valid n-bit gray code sequence.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graycode {
  private boolean permute(ArrayList<Integer> nums, int start) {
    if (start == nums.size()) {
      return checkValid(nums.get(0), nums.get(nums.size()-1));
    }
    
    for (int i=start; i<nums.size(); i++) {
      if (checkValid(nums.get(start-1), nums.get(i))) {
        Integer temp = nums.get(start);
        nums.set(start, nums.get(i));
        nums.set(i, temp);
      
        if(permute(nums, start+1))
          return true;
        
        // backtrace
        temp = nums.get(start);
        nums.set(start, nums.get(i));
        nums.set(i, temp);
      }
    }
    return false;
  }

  @SuppressWarnings("unused")
  private List<Integer> generateAllValidNeighbor(int n) {
    int mask = 0x1;
    List<Integer> result = new LinkedList<>();
    for (int i=0; i<16; i++) {
      result.add(n ^ mask);
      mask <<= 1;
    }
    return result;
  }

  private boolean checkValid(Integer n1, Integer n2) {
    int xor = n1 ^ n2;
    xor = xor & (xor - 1); // clear up the lowest bit of 1
    return xor == 0;
  }

  public List<Integer> grayCode_works_but_slow(int n) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i=0; i < Math.pow(2, n); i++)
      result.add(i);
    
    for (int i=0; i<result.size(); i++) {
      Integer temp = result.get(0);
      result.set(0, result.get(i));
      result.set(i, temp);

      if (permute(result, 1))
        break;
    }

    return result;
  }

  // n = 1, {0,1}
  // n = 2, {0,1,1,0} -> {00,01,11,10}
  // n = 3, {00,01,11,10,10,11,01,00} -> {000,001,011,010,110,111,101,100}
  public List<Integer> grayCode(int n) {
    // notice that using ArrayList here and pre-allocating space is faster than using LinkedList
    // and it's also faster than using ArrayList and add() method.
    // https://stackoverflow.com/questions/10270328/difference-between-arraylist-and-linkedlist-in-java
    // A lot faster actually: 838 ms vs 7 ms per Leetcode OJ
    List<Integer> result = new ArrayList<>(1 << n);
    result.add(0);
    result.add(1);
    for (int i=1; i<n; i++) {
      int s = result.size();
      int padding = 1 << i;
      for (int j=s-1; j>=0; j--)
        result.add(result.get(j) + padding);
    }
    return result;
  }

  public static void Run() {
    Graycode g = new Graycode();
    //System.out.println(g.generateAllValidNeighbor(1));
    System.out.println(g.grayCode(1));
    System.out.println(g.grayCode(2));
    System.out.println(g.grayCode(3));
  }
}
