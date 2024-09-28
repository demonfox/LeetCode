// You are given an array of characters letters that is sorted in non-decreasing order, and a character target. 
// There are at least two different characters in letters.
// Return the smallest character in letters that is lexicographically greater than target. If such a character 
// does not exist, return the first character in letters.
public class SmallestLetterThanTarget {
  public char nextGreatestLetter(char[] letters, char target) {
    if (target < letters[0] || target >= letters[letters.length-1])
      return letters[0];

    int l = 0;
    int r = letters.length-1;
    while (l < r) {
      int m = l + (r - l) / 2;
      if (letters[m] <= target)
        l = m + 1;
      else
        r = m - 1;
    }

    // when we got here, l should == r
    if (letters[l] > target)
      return letters[l];
    else
      return letters[l+1];
  }

  public static void Run() {
    SmallestLetterThanTarget s = new SmallestLetterThanTarget();

    var input1 = new char[]{'c', 'f', 'j'};
    System.out.println(s.nextGreatestLetter(input1, 'a'));

    input1 = new char[]{'c', 'f', 'j'};
    System.out.println(s.nextGreatestLetter(input1, 'c'));

    input1 = new char[]{'x', 'x', 'y', 'y'};
    System.out.println(s.nextGreatestLetter(input1, 'z'));

    // generate a test case with 10 characters
    input1 = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
    System.out.println(s.nextGreatestLetter(input1, 'f'));
  }
}
