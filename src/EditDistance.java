// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
// You have the following three operations permitted on a word:
// Insert a character
// Delete a character
// Replace a character

public class EditDistance {
  public int minDistance(String word1, String word2) {
    int m = word1.length()+1;
    int n = word2.length()+1;
    int[][] minSteps = new int[m][n];
    for (int i=0; i<m; i++) 
      minSteps[i][0] = i;
    for (int j=0; j<n; j++)
      minSteps[0][j] = j;

    for (int i=1; i<m; i++) {
      for (int j=1; j<n; j++) {
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
          minSteps[i][j] = minSteps[i-1][j-1];
        } else {
          minSteps[i][j] = 1 + Math.min(Math.min(minSteps[i-1][j], minSteps[i][j-1]), minSteps[i-1][j-1]);
        }
      }
    }

    return minSteps[m-1][n-1];
  }

  public static void Run() {
    EditDistance d = new EditDistance();
    System.out.println(d.minDistance("horse", "ros"));
  }
}
