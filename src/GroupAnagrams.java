// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically 
// using all the original letters exactly once.

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new LinkedList<List<String>>();
    Map<String, List<String>> signatures = new HashMap<String, List<String>>();
    for (String str : strs) {
      String signature = calcSignature(str);
      if (signatures.containsKey(signature)) {
        signatures.get(signature).add(str);
      } else {
        List<String> group = new LinkedList<>();
        group.add(str);
        signatures.put(signature, group);
      }
    }
    result.addAll(signatures.values());
    return result;
  }

  private String calcSignature(String str) {
    int[] count = new int[26];
    for (int i=0; i<str.length(); i++) {
      count[str.charAt(i) - 'a'] += 1;
    }
    StringBuilder sb = new StringBuilder();
    for (int i : count) {
      sb.append("#" + i);
    }
    return sb.toString();
  }

  public static void Run() {
    GroupAnagrams g = new GroupAnagrams();
    List<List<String>> groups = g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    for (List<String> group : groups) {
      group.forEach(s -> System.out.print(s + " "));
      System.out.println();
    }
    groups = g.groupAnagrams(new String[]{""});
    for (List<String> group : groups) {
      group.forEach(s -> System.out.print(s + " "));
      System.out.println();
    }
    groups = g.groupAnagrams(new String[]{"hhhhu","tttti","tttit","hhhuh","hhuhh","tittt"});
    for (List<String> group : groups) {
      group.forEach(s -> System.out.print(s + " "));
      System.out.println();
    }
  }
}
