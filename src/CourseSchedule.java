// There are a total of numCourses courses you have to take, labeled from 0 to 
// numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] 
// indicates that you must take course bi first if you want to take course ai.
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class GraphNode {
  public int val;
  public LinkedList<GraphNode> children;
  public GraphNode(int val) {
    this.val = val;
    this.children = new LinkedList<GraphNode>();
  }
}

public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, GraphNode> map = new HashMap<Integer, GraphNode>();
    // build the prerequisite graph
    for (int i=0; i<prerequisites.length; i++) {

      GraphNode g1;
      GraphNode g2;
      if (map.containsKey(prerequisites[i][0]))
        g1 = map.get(prerequisites[i][0]);
      else {
        g1 = new GraphNode(prerequisites[i][0]);
        map.put(g1.val, g1);
      }
      if (map.containsKey(prerequisites[i][1]))
        g2 = map.get(prerequisites[i][1]);
      else {
        g2 = new GraphNode(prerequisites[i][1]);
        map.put(g2.val, g2);
      }
      g2.children.add(g1);
    }

    Set<Integer> visited = new HashSet<Integer>();
    Set<Integer> stack = new HashSet<Integer>();
    // 1) enumerate through all graph nodes
    for (GraphNode g : map.values()) {
      if (isCyclic(g, visited, stack))
        return false;
    }
    
    return true;
  }

  private boolean isCyclic(GraphNode g, Set<Integer> visited, Set<Integer> stack) {
    // 2) check if the current node is visited AND is in the calling stack
    if (stack.contains(g.val))
      return true;

    // 3) if it's not on the calling stack but has been visited, we know there is no cycle and can return
    if (visited.contains(g.val))
      return false;
    
    visited.add(g.val);
    stack.add(g.val);

    for (GraphNode c : g.children) {
      if (isCyclic(c, visited, stack))
        return true;
    }

    stack.remove(g.val);
    return false;
  }

  public static void Run() {
    CourseSchedule s = new CourseSchedule();
    int numCourses = 2;
    int[][] prerequisites = new int[1][];
    prerequisites[0] = new int[]{1,0};
    System.out.println(s.canFinish(numCourses, prerequisites));
    prerequisites = new int[2][];
    prerequisites[0] = new int[]{1,0};
    prerequisites[1] = new int[]{0,1};
    System.out.println(s.canFinish(numCourses, prerequisites));
  }
}
