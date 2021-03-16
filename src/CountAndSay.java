// The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
// countAndSay(1) = "1"
// countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is 
// then converted into a different digit string.
// To determine how you "say" a digit string, split it into the minimal number of groups so that 
// each group is a contiguous section all of the same character. Then for each group, say the number 
// of characters, then say the character. To convert the saying into a digit string, replace the 
// counts with a number and concatenate every saying.
// For example, the saying and conversion for digit string "3322251":

public class CountAndSay {
  public String countAndSay(int n) {
    StringBuilder currNum = new StringBuilder("1");
    for (int i=1; i<n; i++) {
      currNum = convert(currNum);
    }
    return currNum.toString();
  }

  private StringBuilder convert(StringBuilder n) {
    char t = '\0';
    char lt = '\0';
    int currCount = 0;
    StringBuilder s = new StringBuilder();
    while (n.length() > 0) {
      t = n.charAt(n.length()-1);
      if (lt == '\0' || t == lt) {
        currCount++;
      } else {
        s.insert(0, lt);
        s.insert(0, currCount);
        currCount = 1;
      }
      lt = t;
      n.deleteCharAt(n.length()-1);
    }
    s.insert(0, lt);
    s.insert(0, currCount);
    return s;
  }

  public static void Run() {
    CountAndSay c = new CountAndSay();
    System.out.println(c.countAndSay(1));
    System.out.println(c.countAndSay(2));
    System.out.println(c.countAndSay(3));
    System.out.println(c.countAndSay(4));
  }
}
