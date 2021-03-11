// Given two binary strings a and b, return their sum as a binary string.

public class AddBinary {
  public String addBinary(String a, String b) {
    char[] op1 = a.toCharArray();
    char[] op2 = b.toCharArray();
    StringBuilder result = new StringBuilder();
    int pos1 = op1.length-1;
    int pos2 = op2.length-1;
    boolean hasCarry = false;
    while (pos1 >=0 && pos2 >=0) {
      if (hasCarry)
        result.insert(0, (op1[pos1] != op2[pos2]) ? '0' : '1');
      else
        result.insert(0, (op1[pos1] == op2[pos2]) ? '0' : '1');
      hasCarry = (hasCarry && (op1[pos1] != op2[pos2])) || (op1[pos1] == '1' && op2[pos2] == '1');
      pos1--;
      pos2--;
    }
    if (pos1 < 0) {
      while (pos2 >=0) {
        if (hasCarry)
          result.insert(0, (op2[pos2] == '0' ? '1' : '0'));
        else
          result.insert(0, op2[pos2]);
        hasCarry = hasCarry && (op2[pos2] == '1');
        pos2--;
      }
    } else {
      while (pos1 >=0) {
        if (hasCarry)
          result.insert(0, (op1[pos1] == '0' ? '1' : '0'));
        else
          result.insert(0, op1[pos1]);
        hasCarry = hasCarry && (op1[pos1] == '1');
        pos1--;
      }
    }
    if (hasCarry)
      result.insert(0, '1');

    return result.toString();
  }

  public static void Run() {
    AddBinary a = new AddBinary();
    System.out.println(a.addBinary("11", "1"));
    System.out.println(a.addBinary("1010", "1011"));
  }
}
