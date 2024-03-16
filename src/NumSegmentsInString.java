// Given a string s, return the number of segments in the string.
// A segment is defined to be a contiguous sequence of non-space characters.

public class NumSegmentsInString {
  public int countSegments(String s) {
    if (s.length() == 0)
      return 0;

    int count = 0;
    boolean segmentStart = false;
    for (int i=0; i<s.length(); i++) {
      if (segmentStart == false) {
        // we need to look for the first non-space character
        if (s.charAt(i) == ' ')
          continue;
        else
          segmentStart = true;
      } else {
        if (s.charAt(i) != ' ')
          continue;
        else {
          count++;
          segmentStart = false;
        }
      }
    }
    if (s.charAt(s.length()-1) != ' ')
      count++;
    return count;
  }

  public static void Run() {
    NumSegmentsInString n = new NumSegmentsInString();
    System.out.println(n.countSegments("Hello, my name is John"));
    System.out.println(n.countSegments("   "));
    System.out.println(n.countSegments("    Hello, my name is John"));
    System.out.println(n.countSegments("Hello, my name is John    "));
    System.out.println(n.countSegments("   Hello, my name is John   "));
  }
}
