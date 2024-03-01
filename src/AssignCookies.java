// Assume you are an awesome parent and want to give your children some cookies. But, you should give each 
// child at most one cookie.

// Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; 
// and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will 
// be content. Your goal is to maximize the number of your content children and output the maximum number.

import java.util.Arrays;

public class AssignCookies {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i, j;
    i = j = 0;
    int result = 0;
    while (i < g.length && j < s.length) {
      if (s[j] >= g[i]) {
        result++;
        i++;
      }
      j++;
    }
    return result;
  }

  public static void Run() {
    AssignCookies a = new AssignCookies();
    System.out.println(a.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
    System.out.println(a.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
  }
}
