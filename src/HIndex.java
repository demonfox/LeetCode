// Given an array of integers citations where citations[i] is the number of citations a researcher received for 
// their ith paper, return the researcher's h-index.
// According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that 
// the given researcher has published at least h papers that have each been cited at least h times.

import java.util.Arrays;

public class HIndex {
  // time complexity is nlogn, space complexity is n
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    for (int i=0; i<citations.length; i++) {
      int papers = citations.length - i;
      if (papers <= citations[i]) {
        return papers;
      }
    }
    return Math.min(1, citations[citations.length-1]);
  }

  public int hIndex2(int[] citations) {
    int[] count = new int[citations.length+1];
    for (int i=0; i<citations.length; i++)
      count[Math.min(citations[i], citations.length)]++;
    int i = citations.length;
    int papers = count[i];
    while (papers < i) {
      i--;
      papers += count[i];
    }
    return i;
  }

  public static void Run() {
    HIndex h = new HIndex();
    int[] citations = {1, 3, 1};
    System.out.println(h.hIndex(citations));
    citations = new int[] {100};
    System.out.println(h.hIndex(citations));
    citations = new int[] {3,0,6,1,5};
    System.out.println(h.hIndex(citations));
    citations = new int[] {1,2,100};
    System.out.println(h.hIndex(citations));
    citations = new int[] {0};
    System.out.println(h.hIndex(citations));
    citations = new int[] {11,15};
    System.out.println(h.hIndex(citations));
  }
}
