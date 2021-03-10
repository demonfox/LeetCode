import java.util.HashMap;
import java.util.Map;

public class Trie {
  static class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    TrieNode() {
      isEndOfWord = false;
      children = new HashMap<Character, TrieNode>();
    }
  }

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }
  
  public void insert(String word) {
    TrieNode curr = root;
    for (int i=0; i<word.length(); i++) {
      curr.children.putIfAbsent(word.charAt(i), new TrieNode());
      curr = curr.children.get(word.charAt(i));
    }
    curr.isEndOfWord = true;
  }
  
  public boolean search(String word) {
    TrieNode curr = root;
    for (int i=0; i<word.length(); i++) {
      curr = curr.children.get(word.charAt(i));
      if (curr == null)
        return false;
    }
    return curr.isEndOfWord;
  }
  
  public boolean startsWith(String prefix) {
    TrieNode curr = root;
    for (int i=0; i<prefix.length(); i++) {
      curr = curr.children.get(prefix.charAt(i));
      if (curr == null)
        return false;
    }

    return true;
  }

  public static void Run() {
    Trie trie = new Trie();
    trie.insert("app");
    trie.insert("apple");
    trie.insert("beer");
    trie.insert("add");
    trie.insert("jam");
    trie.insert("rental");
    System.out.println(trie.search("apps"));
    System.out.println(trie.search("app"));
    System.out.println(trie.startsWith("app"));
    trie.insert("app");
    System.out.println(trie.search("app"));
  }
}
