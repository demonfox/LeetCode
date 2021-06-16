// There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station 
// to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
// Given two integer arrays gas and cost, return the starting gas station's index if you can travel around 
// the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is 
// guaranteed to be unique

public class GasStation {
  // For convenience, let g[i] = gas[i], c[i] = cost[i]
  // The key to this problem is 2 important observations:
  // 1) If Sigma(g[i] - c[i]) >= 0 (the sum of all n data points) then there must be a valid solution to this problem
  // 2) If the car starts from station 0 and can travel to station i-1, but then fail to make the next hop
  //    from i-1 to i, then we claim that station i will be our next candidate to evaluate. In another words,
  //    there is no need to check the case where the car starting from station 1, 2, ... or i-1. 
  //    The reason for this is that because the car can go all the way from 0 to i-1, which means for each
  //    hop along the way, it will have some kind of surplus in fuel or at least break even for each hop, or 
  //    otherwise, the car would have already failed to make the trip somewhere between 0 and i-1. 
  //    So when we look at the car at station i-1, if it starts from 1, 2, ..., or i-1, these are actually  
  //    worse starting point than station 0. With this observation, we can see that: if the car fails to
  //    make the trip from i-1 to i, then it is safe to conclude that all the starting points before i-1
  //    (i.e. 0, 1, ..., i-1) will not be good enough for us to complete the loop, so we should begin to 
  //    look at starting from station i. And if condition 1) is true, then we are guaranteed to find a 
  //    solution eventually.
  // Now we are going to prove 1) is true:
  // Let's assume that the minimum value for Sigma(g[i]-c[i]) is at station k, that is:
  // g[0] - c[0] + g[1] - c[1] + ... + g[i] - c[i] is at its minimum when i = k
  // We claim that in this case, i = k + 1 will be one valid answer for this problem.
  // To prove the above statement, we need to show 2 things:
  // First, g[k+1] - c[k+1] >= 0
  //        g[k+1] - c[k+1] + g[k+2] - c[k+2] >= 0
  //        ...
  //        g[k+1] - c[k+1] + ... + g[n-1] - c[n-1] >= 0 (this means the car can start from k+1 and travel to n-1)
  // Second, g[k+1] - c[k+1] + ... + g[n-1] - c[n-1] + g[0] - c[0] + ... g[j] - c[j] >= 0 for any j <= k
  // Well, for the first point, since g[0] - c[0] + g[1] - c[1] + ... + g[i] - c[i] is at its minimum
  // when i = k, then g[0] - c[0] + g[1] - c[1] + ... + g[k+1] - c[k+1] must be greater than or equal to
  // g[0] - c[0] + g[1] - c[1] + ... + g[k] - c[k]
  // or g[k+1] - c[k+1] must be >= 0
  // Similarly, we can show that 
  // g[k+1] - c[k+1] + g[k+2] - c[k+2] >= 0 
  // ...
  // g[k+1] - c[k+1] + ... + g[n-1] - c[n-1] >= 0
  // For the second point, since:
  // g[0] - c[0] + ... g[j] - c[j] >= g[0] - c[0] + ... g[k] - c[k] (for any j <= k)
  // then g[0] - c[0] + ... g[j] - c[j] + g[k+1] - c[k+1] + ... + g[n-1] - c[n-1]
  //      >= g[0] - c[0] + ... g[k] - c[k] + g[k+1] - c[k+1] + ... + g[n-1] - c[n-1]
  //       = Sigma(g[i] - c[i])
  //      >= 0 (This is the condition in 1))
  // Thus, we have proven 1).

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int start = 0;
    int fuel = 0;
    for (int i=0; i<gas.length; i++)
      fuel += (gas[i]-cost[i]);
    if (fuel < 0)
      return -1;
    fuel = 0;
    for (int i=0; i<gas.length; i++) {
      fuel += (gas[i]-cost[i]);
      if (fuel < 0) {
        fuel = 0;
        start = i+1;
      }
    }
    return start;
  }

  public static void Run() {
    GasStation g = new GasStation();
    System.out.println(g.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    System.out.println(g.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
  }
}
