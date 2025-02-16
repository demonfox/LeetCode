// Design a data structure that supports adding new words and finding if a string matches any previously added string.
// Implement the WordDictionary class:
// WordDictionary() Initializes the object.
// void addWord(word) Adds word to the data structure, it can be matched later.
// bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. 
// word may contain dots '.' where dots can be matched with any letter.

public class WordDictionary {
  class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    TrieNode() {
      isEndOfWord = false;
      children = new TrieNode[26];
    }
  }

  private TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }
  
  public void addWord(String word) {
    TrieNode curr = root;
    for (int i=0; i<word.length(); i++) {
      if (curr.children[word.charAt(i) - 'a'] == null)
        curr.children[word.charAt(i) - 'a'] = new TrieNode();
      curr = curr.children[word.charAt(i) - 'a'];
    }
    curr.isEndOfWord = true;
  }
  
  public boolean search(String word) {
    return helper(root, word, 0);
  }

  private boolean helper(TrieNode curr, String word, int index) {
    if (index == word.length())
      return curr.isEndOfWord;

    char c = word.charAt(index);
    if (c == '.') {
      for (TrieNode node : curr.children) {
        if (node != null) {
          boolean res = helper(node, word, index+1);
          if (res == true)
            return true;
        }
      }
      return false;
    } else {
      curr = curr.children[c - 'a'];
      if (curr == null)
        return false;
      return helper(curr, word, index+1);
    }
  }

  public static void Run() {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    System.out.println(wordDictionary.search("pad")); // return False
    System.out.println(wordDictionary.search("bad")); // return True
    System.out.println(wordDictionary.search(".ad")); // return True
    System.out.println(wordDictionary.search("b..")); // return True
  }
}
