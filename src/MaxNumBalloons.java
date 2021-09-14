// Given a string text, you want to use the characters of text to form as many instances 
// of the word "balloon" as possible.
// You can use each character in text at most once. Return the maximum number of instances 
// that can be formed.

public class MaxNumBalloons {
  public int maxNumberOfBalloons(String text) {
    int[] count = new int[5];
    for (int i=0; i<text.length(); i++) {
      switch(text.charAt(i)) {
        case 'b':
          count[0]++;
          break;
        case 'a':
          count[1]++;
          break;
        case 'l':
          count[2]++;
          break;
        case 'o':
          count[3]++;
          break;
        case 'n':
          count[4]++;
          break;
        default:
          break;
      }
    }
    return Math.min(Math.min(Math.min(Math.min(count[0], count[1]), count[2]/2), count[3]/2), count[4]);
  }

  public static void Run() {
    MaxNumBalloons m = new MaxNumBalloons();
    System.out.println(m.maxNumberOfBalloons("nlaebolko"));
    System.out.println(m.maxNumberOfBalloons("loonbalxballpoon"));
    System.out.println(m.maxNumberOfBalloons("leetcode"));
  }
}
