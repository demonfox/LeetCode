// International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, 
// as follows:
// 'a' maps to ".-",
// 'b' maps to "-...",
// 'c' maps to "-.-.", and so on.
// For convenience, the full table for the 26 letters of the English alphabet is given below:
// [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
// Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
// For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will 
// call such a concatenation the transformation of a word.
// Return the number of different transformations among all words we have.

import java.util.HashSet;

public class UniqueMorseCodeWords {
  private static String[] map = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
  public int uniqueMorseRepresentations(String[] words) {
    HashSet<String> hashSet = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    for (String s : words) {
      for (int i=0; i<s.length(); i++) {
        sb.append(map[s.charAt(i) - 'a']);
      }
      hashSet.add(sb.toString());
      sb.setLength(0);
    }
    return hashSet.size();
  }

  public static void Run() {
    String[] words = new String[]{"gin", "zen", "gig", "msg"};
    UniqueMorseCodeWords solution = new UniqueMorseCodeWords();
    System.out.println(solution.uniqueMorseRepresentations(words));
    words = new String[]{"a"};
    System.out.println(solution.uniqueMorseRepresentations(words));
  }
}
