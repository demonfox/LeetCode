// Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, 
// and the character will be typed 1 or more times.
// You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with 
// some characters (possibly none) being long pressed.

public class LongPressedName {
  public boolean isLongPressedName(String name, String typed) {
    int i = 0, j = 0;
    while (i < name.length() && j < typed.length()) {
      char nameChar = name.charAt(i);
      int nameCharLen = 0;
      char typedChar = typed.charAt(j);
      int typedCharLen = 0;

      if (nameChar != typedChar)
        return false;

      while (i < name.length()) {
        if (name.charAt(i++) == nameChar)
          nameCharLen++;
        else {
          i--;
          break;
        }
      }

      while (j < typed.length()) {
        if (typed.charAt(j++) == typedChar)
          typedCharLen++;
        else {
          j--;
          break;
        }
      }

      if (nameCharLen > typedCharLen)
        return false;
    }
    return i == name.length() && j == typed.length();
  }

  public static void Run() {
    LongPressedName lpn = new LongPressedName();
    System.out.println(lpn.isLongPressedName("a", "b"));
    System.out.println(lpn.isLongPressedName("vtkgn", "vttkgnn"));
    System.out.println(lpn.isLongPressedName("alex", "aaleex"));
    System.out.println(lpn.isLongPressedName("saeed", "ssaaedd"));
    System.out.println(lpn.isLongPressedName("leelee", "lleeelee"));
    System.out.println(lpn.isLongPressedName("laiden", "laiden"));
  }
}
