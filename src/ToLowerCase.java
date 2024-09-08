// Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

public class ToLowerCase {
  public String toLowerCase(String s) {
    StringBuilder result = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c >= 'A' && c <= 'Z')
        c += 32;
      result.append(c);
    }
    return result.toString();
  }

  public static void Run() {
    ToLowerCase tlc = new ToLowerCase();
    System.out.println(tlc.toLowerCase("Hello"));
    System.out.println(tlc.toLowerCase("here"));
    System.out.println(tlc.toLowerCase("LOVELY"));
  }
}
