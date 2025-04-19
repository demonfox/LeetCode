// Given an array of integers citations where citations[i] is the number of citations a researcher received for 
// their ith paper and citations is sorted in non-descending order, return the researcher's h-index.
// According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such 
// that the given researcher has published at least h papers that have each been cited at least h times.
// You must write an algorithm that runs in logarithmic time.

public class HIndex2II {
  public int hIndex(int[] citations) {
    //int l_papers = citations.length, r_papers = 1;
    if (citations.length <= citations[0])
      return citations.length;
    if (1 >= citations[citations.length-1])
      return citations[citations.length-1];
    
    // if papers > citations[i], then answer is to the right - this is for the left bound
    // if papers <= citations[i], then answer is to the left - this is for the right bound
    int l = 0, r = citations.length-1;
    int m;
    while (true) {
      if (l == (r - 1))
        return Math.max(citations[l], citations.length - r);
      m = l + (r - l) / 2;
      int m_papers = citations.length - m;
      if (m_papers == citations[m])
        return m_papers;
      else if (m_papers < citations[m])
        r = m;
      else
        l = m;
    }
  }

  public static void Run() {
    HIndex2II h = new HIndex2II();
    int[] citations = {0, 0, 4, 4};
    System.out.println(h.hIndex(citations));
    citations = new int[] {0, 1};
    System.out.println(h.hIndex(citations));
    citations = new int[] {0, 1, 2, 5, 6};
    System.out.println(h.hIndex(citations));
    citations = new int[] {1, 2, 10000000};
    System.out.println(h.hIndex(citations));
    citations = new int[] {0, 1, 3, 5, 6};
    System.out.println(h.hIndex(citations));
  }
}
