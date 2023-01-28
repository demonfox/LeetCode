// Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

public class AddDigits {
  public int addDigits(int num) {
    int result = 0;
    while (true) {
      while (num > 0) {
        result += (num % 10);
        num /= 10;
      }
      if (result < 10)
        break;
      else {
        num = result;
        result = 0;
      }
    }
    return result;
  }
  
  public static void Run() {
    AddDigits a = new AddDigits();
    System.out.println(a.addDigits(38));
    System.out.println(a.addDigits(0));
  }
}
