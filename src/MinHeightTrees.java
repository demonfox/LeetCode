// A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected 
// graph without simple cycles is a tree.
// Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that 
// there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. 
// When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum 
// height (i.e. min(h))  are called minimum height trees (MHTs).
// Return a list of all MHTs' root labels. You can return the answer in any order.
// The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MinHeightTrees {
  List<Integer> result;
  int minDepth;
  
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
      List<Integer> rtrn = new LinkedList<Integer>();
      rtrn.add(0);
      return rtrn;
    } else if (n == 2) {
      List<Integer> rtrn = new LinkedList<Integer>();
      rtrn.add(0);
      rtrn.add(1);
      return rtrn;
    }

    @SuppressWarnings("unchecked")
    Set<Integer>[] edgeMatrix = new HashSet[n];
    for (int i=0; i<n; i++)
      edgeMatrix[i] = new HashSet<>();

    for (int i=0; i<edges.length; i++) {
      edgeMatrix[edges[i][0]].add(edges[i][1]);
      edgeMatrix[edges[i][1]].add(edges[i][0]);
    }

    List<Integer> leafNodes = new LinkedList<>();
    int[] edgeCount = new int[n]; 
    for (int i = 0; i < edgeMatrix.length; i++) {
      if (edgeMatrix[i].size() == 1)
        leafNodes.add(i);
      edgeCount[i] = edgeMatrix[i].size();
    }
    while (true) {
      if (n <= 2)
        return leafNodes;
      else {
        int size = leafNodes.size();
        for (int i=0; i<size; i++) {
          Integer node = leafNodes.remove(0);
          for (Integer neighbor : edgeMatrix[node]) {
            edgeCount[neighbor]--;
            if (edgeCount[neighbor] == 1)
              leafNodes.add(neighbor);
          }
          n--;
        }
      }
    }
  }

  public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
    result = new LinkedList<>();
    minDepth = n;
    if (n == 1) {
      result.add(0);
      return result;
    } 

    @SuppressWarnings("unchecked")
    Set<Integer>[] edgeMatrix = new HashSet[n];
    for (int i=0; i<n; i++)
      edgeMatrix[i] = new HashSet<>();

    boolean[] visited = new boolean[n];
    for (int i=0; i<edges.length; i++) {
      edgeMatrix[edges[i][0]].add(edges[i][1]);
      edgeMatrix[edges[i][1]].add(edges[i][0]);
    }
    for (int i=0; i<n; i++) {
      visited[i] = true;
      int depth = dfs(edgeMatrix, visited, i, 0);
      if (depth < minDepth) {
        minDepth = depth;
        result.clear();
        result.add(i);
      } else if (depth == minDepth) {
        result.add(i);
      }
      visited[i] = false;
    }
    return result;
  }

  private int dfs(Set<Integer>[] edgeMatrix, boolean[] visited, int currNode, int depth) {
    if (depth > minDepth)
      return depth;
    int nodeDepth = depth;
    for (Integer neighbor : edgeMatrix[currNode]) {
      if (!visited[neighbor]) {
        visited[neighbor] = true;
        nodeDepth = Math.max(nodeDepth, dfs(edgeMatrix, visited, neighbor, depth+1));
        visited[neighbor] = false;
        if (nodeDepth > minDepth)
          return nodeDepth;        
      }
    }
    return nodeDepth;
  }

  public static void Run() {
    MinHeightTrees m = new MinHeightTrees();
    int[][] edges1 = {{0,1},{0,2}};
    System.out.println(m.findMinHeightTrees(3, edges1));
    int[][] edges2 = {{1,0},{1,2},{1,3}};
    System.out.println(m.findMinHeightTrees(4, edges2));
    int[][] edges3 = {{3,0},{3,1},{3,2},{3,4},{5,4}};
    System.out.println(m.findMinHeightTrees(6, edges3));
  }
}
