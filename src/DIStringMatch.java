// A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:
// s[i] == 'I' if perm[i] < perm[i + 1], and
// s[i] == 'D' if perm[i] > perm[i + 1].
// Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.

public class DIStringMatch {
  public int[] diStringMatch(String s) {
    int[] array = new int[s.length()+1];
    int i;
    for (i=0; i<array.length; i++)
      array[i] = i;
    
    int j=0, k=array.length-1;
    int[] result = new int[array.length];
    for (i=0; i<s.length(); i++) {
      if (s.charAt(i) == 'I') {
        result[i] = array[j++];
      } else {
        result[i] = array[k--];
      }
    }
    result[i] = array[j];
    return result;
  }

  public static void Run() {
    DIStringMatch obj = new DIStringMatch();
    String s = "IDID";
    int[] result = obj.diStringMatch(s);
    for (int i=0; i<result.length; i++)
      System.out.print(result[i] + " ");
    System.out.println();
    s = "III";
    result = obj.diStringMatch(s);
    for (int i=0; i<result.length; i++)
      System.out.print(result[i] + " ");
    System.out.println();
    s = "DDI";
    result = obj.diStringMatch(s);
    for (int i=0; i<result.length; i++)
      System.out.print(result[i] + " ");
  }
}
