// You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and 
// uppercase letters only.

// We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat 
// Latin are as follows:

// If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
// For example, the word "apple" becomes "applema".
// If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
// For example, the word "goat" becomes "oatgma".
// Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
// For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
// Return the final sentence representing the conversion from sentence to Goat Latin.

public class GoatLatin {
  public String toGoatLatin(String sentence) {
    StringBuilder sb = new StringBuilder();
    String[] words = sentence.split(" ");
    StringBuilder tail = new StringBuilder("a");
    for (String word : words) {
      char firstLetter = word.charAt(0);
      if (firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o' || firstLetter == 'u'
          || firstLetter == 'A' || firstLetter == 'E' || firstLetter == 'I' || firstLetter == 'O' || firstLetter == 'U') {
        sb.append(word);
        sb.append("ma");
        sb.append(tail);
      } else {
        sb.append(word.substring(1)); // if words[i] length == 1, words[i].substring(1) is an empty string
        sb.append(word.charAt(0));
        sb.append("ma");
        sb.append(tail);
      }
      sb.append(" ");
      tail.append("a");
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }

  public static void Run() {
    // generate a test case 
    String sentence = "I speak Goat Latin";
    GoatLatin gol = new GoatLatin();
    System.out.println(gol.toGoatLatin(sentence));

    sentence = "The quick brown fox jumped over the lazy dog";
    System.out.println(gol.toGoatLatin(sentence));
  }
}
