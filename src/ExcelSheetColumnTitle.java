// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
// For example:
// A -> 1, B -> 2, C -> 3...
// Z -> 26, AA -> 27, AB -> 28...

public class ExcelSheetColumnTitle {
  public String convertToTitle(int columnNumber) {
    //StringBuilder result = new StringBuilder();
    char[] result = new char[7]; // MAX_VALUE maps to column header of length 7
    int i = 7;
    while (columnNumber > 0) {
      int remainder = columnNumber % 26;
      int quotient = columnNumber / 26;
      i--;
      if (remainder != 0)
        //result.insert(0, (char)(remainder - 1 + 'A'));
        result[i] = (char)(remainder-1 + 'A');
      else {
        //result.insert(0, 'Z');
        result[i] = 'Z';
        quotient -= 1;
      }
      columnNumber = quotient;
    }
    //return result.toString();
    return String.copyValueOf(result, i, 7-i);
  }

  public static void Run() {
    ExcelSheetColumnTitle s = new ExcelSheetColumnTitle();
    System.out.println(s.convertToTitle(1));
    System.out.println(s.convertToTitle(26));
    System.out.println(s.convertToTitle(27));
    System.out.println(s.convertToTitle(28));
    System.out.println(s.convertToTitle(52));
    System.out.println(s.convertToTitle(701));
    System.out.println(s.convertToTitle(Integer.MAX_VALUE));
  }
}
