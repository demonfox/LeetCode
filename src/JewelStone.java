// You're given strings jewels representing the types of stones that are jewels, and stones representing the stones 
// you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have 
// are also jewels.
// Letters are case sensitive, so "a" is considered a different type of stone from "A".

public class JewelStone {
  public int numJewelsInStones(String jewels, String stones) {
    boolean[] marker = new boolean[52];
    for (int i=0; i<jewels.length(); i++) {
      char c = jewels.charAt(i);
      if (c >= 'A' && c <= 'Z')
        marker[c - 'A'] = true;
      else
        marker[c - 'a' + 26] = true;
    }

    int result = 0;
    for (int i=0; i<stones.length(); i++) {
      char c = stones.charAt(i);
      if (c >= 'A' && c <= 'Z') {
        if (marker[c - 'A']) result++;
      }
      else if (marker[c - 'a' + 26])
        result++;
    }
    return result;
  }

  public static void Run() {
    JewelStone solution = new JewelStone();
    System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
    System.out.println(solution.numJewelsInStones("z", "ZZ"));
    System.out.println(solution.numJewelsInStones("", ""));
    System.out.println(solution.numJewelsInStones("zyxcba", "ZadZadZadZad"));
    System.out.println(solution.numJewelsInStones("Iut", "HTF"));
  }
}
