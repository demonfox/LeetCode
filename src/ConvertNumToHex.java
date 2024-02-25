public class ConvertNumToHex {
  char helper(int num) {
    switch (num & 0xF0000000) {
      case 0:
        return '0';
      case 0x10000000:
        return '1';
      case 0x20000000:
        return '2';
      case 0x30000000:
        return '3';
      case 0x40000000:
        return '4';
      case 0x50000000:
        return '5';
      case 0x60000000:
        return '6';
      case 0x70000000:
        return '7';
      case 0x80000000:
        return '8';
      case 0x90000000:
        return '9';
      case 0xA0000000:
        return 'a';
      case 0xB0000000:
        return 'b';
      case 0xC0000000:
        return 'c';
      case 0xD0000000:
        return 'd';
      case 0xE0000000:
        return 'e';
      case 0xF0000000:
        return 'f';
      default:
        return '\0';
    }
  }

  public String toHex(int num) {
    if (num == 0) return "0";

    boolean isLeadingZero = true;
    StringBuilder result = new StringBuilder();
    for (int i=0; i<8; i++) {
      char ch = helper(num);
      num <<= 4;
      if (ch == '0') {
        if (isLeadingZero)
          continue;
      } else
        isLeadingZero = false;
      result.append(ch);
    }
    return result.toString();
  }

  public static void Run() {
    ConvertNumToHex c = new ConvertNumToHex();
    System.out.println(c.toHex(0));
    System.out.println(c.toHex(26));
    System.out.println(c.toHex(-1));
  }
}
