// Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
// You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

import java.util.LinkedList;
import java.util.List;

public class LexicographicalNumbers {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new LinkedList<>();
    int curr = 1;
    while (result.size() < n) {
      result.add(curr);
      if (curr * 10 <= n)
        curr *= 10;
      else {
        while (curr == n || curr % 10 == 9)
          curr = curr / 10;
        curr += 1;
      }
    }
    return result;
  }

  int upperBound = 0;
  public List<Integer> lexicalOrder1(int n) {
    List<Integer> result = new LinkedList<>();
    upperBound = n;
    for (int i=1; i<=9; i++)
      dfs(i, result);
    return result;      
  }

  private void dfs(int curr, List<Integer> result) {
    if (curr > upperBound)
      return;
    result.add(curr);
    curr *= 10;
    for (int i=0; i<=9; i++)
      dfs(curr + i, result);
  }

  public static void Run() {
    LexicographicalNumbers solution = new LexicographicalNumbers();
    System.out.println(solution.lexicalOrder(34)); 
  }
}
