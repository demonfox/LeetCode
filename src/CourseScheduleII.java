// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you 
// must take course bi first if you want to take course ai.
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return the ordering of courses you should take to finish all courses. If there are many valid answers, 
// return any of them. If it is impossible to finish all courses, return an empty array.

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// class GraphNode {
//   public int val;
//   public LinkedList<GraphNode> children;
//   public GraphNode(int val) {
//     this.val = val;
//     children = new LinkedList<GraphNode>();
//   }
// }

public class CourseScheduleII {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, GraphNode> map = new HashMap<Integer, GraphNode>();
    for (int i=0; i<numCourses; i++) {
      GraphNode g = new GraphNode(i);
      map.put(i, g);
    }
    for (int i=0; i<prerequisites.length; i++) {
      GraphNode g1, g2;
      g1 = map.get(prerequisites[i][0]);
      g2 = map.get(prerequisites[i][1]);
      g2.children.add(g1);
    }

    Set<Integer> stack = new HashSet<Integer>();
    Set<Integer> visited = new HashSet<Integer>();
    List<Integer> order = new LinkedList<Integer>();

    for (GraphNode g : map.values()) {
      if (isCyclic(g, visited, stack, order))
        return new int[]{};
    }

    int[] result = new int[numCourses];
    int i = 0;
    for (Integer course : order)
      result[i++] = course;
    
    return result;
  }

  private boolean isCyclic(GraphNode g, Set<Integer> visited, Set<Integer> stack, List<Integer> order) {
    // 2) check if the current node is visited AND is in the calling stack
    if (stack.contains(g.val))
      return true;

    // 3) if it's not on the calling stack but has been visited, we know there is no cycle and can return
    if (visited.contains(g.val))
      return false;
    
    visited.add(g.val);
    stack.add(g.val);

    for (GraphNode c : g.children) {
      if (isCyclic(c, visited, stack, order))
        return true;
    }

    stack.remove(g.val);
    order.add(0, g.val);
    return false;
  }

  public static void Run() {
    CourseScheduleII s = new CourseScheduleII();
    int numCourses = 2;
    int[][] prerequisites = new int[1][];
    prerequisites[0] = new int[]{1,0};
    int[] result = s.findOrder(numCourses, prerequisites);
    System.out.println(Arrays.toString(result));
    prerequisites = new int[2][];
    prerequisites[0] = new int[]{1,0};
    prerequisites[1] = new int[]{0,1};
    result = s.findOrder(numCourses, prerequisites);
    System.out.println(Arrays.toString(result));
    prerequisites = new int[][]{};
    result = s.findOrder(2, prerequisites);
    System.out.println(Arrays.toString(result));
  }
}
