// You have a RecentCounter class which counts the number of recent requests within a certain time frame.
// Implement the RecentCounter class:
// RecentCounter() Initializes the counter with zero recent requests.
// int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that 
// has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened 
// in the inclusive range [t - 3000, t].
// It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

import java.util.Deque;
import java.util.LinkedList;

public class RecentCounter {
  Deque<Integer> queue;

  public RecentCounter() {
    queue = new LinkedList<>();
  }

  public int ping(int t) {
    queue.add(t);
    while(true) {
      if (queue.peek() < t - 3000)
        queue.pop();
      else
        break;
    }
    return queue.size();
  }

  public static void Run() {
    RecentCounter rc = new RecentCounter();
    System.out.println(rc.ping(1));
    System.out.println(rc.ping(100));
    System.out.println(rc.ping(3001));
    System.out.println(rc.ping(3002));
  }
}
