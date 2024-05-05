// Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of 
// American keyboard like the image below.

// In the American keyboard:
// the first row consists of the characters "qwertyuiop",
// the second row consists of the characters "asdfghjkl", and
// the third row consists of the characters "zxcvbnm".


import java.util.ArrayList;
import java.util.HashSet;

public class KeyboardRow {
  public String[] findWords(String[] words) {
    ArrayList<HashSet<Character>> rows = new ArrayList<HashSet<Character>>();
    rows.add(new HashSet<Character>());
    rows.add(new HashSet<Character>());
    rows.add(new HashSet<Character>());
    
    rows.get(0).add('q'); rows.get(0).add('w'); rows.get(0).add('e'); rows.get(0).add('r'); 
    rows.get(0).add('t'); rows.get(0).add('y'); rows.get(0).add('u'); rows.get(0).add('i'); 
    rows.get(0).add('o'); rows.get(0).add('p');

    rows.get(1).add('a'); rows.get(1).add('s'); rows.get(1).add('d'); rows.get(1).add('f'); 
    rows.get(1).add('g'); rows.get(1).add('h'); rows.get(1).add('j'); rows.get(1).add('k'); 
    rows.get(1).add('l');

    rows.get(2).add('z'); rows.get(2).add('x'); rows.get(2).add('c'); rows.get(2).add('v'); 
    rows.get(2).add('b'); rows.get(2).add('n'); rows.get(2).add('m');

    ArrayList<String> result = new ArrayList<>();

    for (String word : words) {
      HashSet<Character> currRow = null;
      int i = 0;
      String lowerCaseWord = word.toLowerCase();

      for (i=0; i<3; i++) {
        if (rows.get(i).contains(lowerCaseWord.charAt(0))) {
          currRow = rows.get(i);
          break;
        }
      }

      for (i=1; i<lowerCaseWord.length(); i++) {
        if (!currRow.contains(lowerCaseWord.charAt(i)))
          break;
      }
      if (i == lowerCaseWord.length())
        result.add(word);
    }

    return result.toArray(String[]::new);
  }

  public static void Run() {
    String[] words = {"Hello", "Alaska", "Dad", "Peace"};
    String[] expected = {"Alaska", "Dad"};

    String[] result = new KeyboardRow().findWords(words);
    if (result.length != expected.length) {
      System.out.println("Test case failed: expected " + expected.length + " elements, but got " + result.length);
      return;
    }
  }
}
