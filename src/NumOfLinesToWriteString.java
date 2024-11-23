// You are given a string s of lowercase English letters and an array widths denoting how many pixels wide each 
// lowercase English letter is. Specifically, widths[0] is the width of 'a', widths[1] is the width of 'b', and so on.
// You are trying to write s across several lines, where each line is no longer than 100 pixels. Starting at the beginning 
// of s, write as many letters on the first line such that the total width does not exceed 100 pixels. Then, from where 
// you stopped in s, continue writing as many letters as you can on the second line. Continue this process until you have 
// written all of s.
// Return an array result of length 2 where:
// result[0] is the total number of lines.
// result[1] is the width of the last line in pixels.

public class NumOfLinesToWriteString {
  public int[] numberOfLines(int[] widths, String s) {
    int lines = 1;
    int width = 0;
    for (int i=0; i<s.length(); i++) {
      int w = widths[s.charAt(i) - 'a'];
      if (width + w <= 100) {
        width += w;
      } else {
        lines++;
        width = w;
      }
    }
    return new int[]{lines, width};
  }

  public static void Run() {
    // generate test cases
    int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    String s = "abcdefghijklmnopqrstuvwxyz";
    int[] result = new NumOfLinesToWriteString().numberOfLines(widths, s);
    System.out.println(result[0] + "," + result[1]);

    widths = new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    s = "bbbcccdddaaa";
    result = new NumOfLinesToWriteString().numberOfLines(widths, s);
    System.out.println(result[0] + "," + result[1]);
  }
}
