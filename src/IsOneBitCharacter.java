// We have two special characters:
// The first character can be represented by one bit 0.
// The second character can be represented by two bits (10 or 11).
// Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.

public class IsOneBitCharacter {
  public boolean isOneBitCharacter(int[] bits) {
    if (bits[bits.length-1] == 1)
      return false;

    int i = 0;
    while(true) {
      if (bits[i] == 0) {
        i++;
        if (i == bits.length) return true;
      }
      else {
        i+= 2;
      if (i == bits.length) return false;
      }
    }
  }

  public static void Run() {
    IsOneBitCharacter test = new IsOneBitCharacter();
    int[] bits = {1,0,0};
    System.out.println(test.isOneBitCharacter(bits));
    bits = new int[]{1,1,1,0};
    System.out.println(test.isOneBitCharacter(bits));
  }
}
