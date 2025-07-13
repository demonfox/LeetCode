// In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
// If the town judge exists, then:
// The town judge trusts nobody.
// Everybody (except for the town judge) trusts the town judge.
// There is exactly one person that satisfies properties 1 and 2.
// You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. 
// If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
// Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

public class FindTownJudge {
  public int findJudge(int n, int[][] trust) {
    int[] trustCount = new int[n];
    int[] trustedCount = new int[n];
    for (int i=0; i<trust.length; i++) {
      trustCount[trust[i][0]-1]++;
      trustedCount[trust[i][1]-1]++;
    }
    for (int i=0; i<n; i++) {
      if (trustCount[i] == 0 && trustedCount[i] == n-1)
        return i+1;
    }
    return -1;
  }

  public static void Run() {
    int[][] trust = {{1,3},{2,3}};
    int n = 3;
    FindTownJudge fj = new FindTownJudge();
    System.out.println(fj.findJudge(n, trust));
  }
}
