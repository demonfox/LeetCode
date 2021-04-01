// Given a string columnTitle that represents the column title as appear in an Excel sheet, 
// return its corresponding column number.
// For example:
// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28 
// ...

public class ExcelSheetColumnNumber {
  public int titleToNumber(String columnTitle) {
    int result = 0;
    int base = 1;
    for (int i=columnTitle.length()-1; i>=0; i--) {
      result += base * ((int)(columnTitle.charAt(i) - 'A') +1);
      base *= 26;
    }
    return result;
  }

  public static void Run() {
    ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
    System.out.println(e.titleToNumber("A"));
    System.out.println(e.titleToNumber("B"));
    System.out.println(e.titleToNumber("Z"));
    System.out.println(e.titleToNumber("AA"));
    System.out.println(e.titleToNumber("AB"));
    System.out.println(e.titleToNumber("ZY"));
    System.out.println(e.titleToNumber("FXSHRXW"));
  }
}
