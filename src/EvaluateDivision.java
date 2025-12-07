// You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] 
// represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
// You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
// Return the answers to all queries. If a single answer cannot be determined, return -1.0.
// Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is 
// no contradiction.
// Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

public class EvaluateDivision {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      String dividend = equation.get(0);
      String divisor = equation.get(1);
      double quotient = values[i];

      graph.putIfAbsent(dividend, new HashMap<>());
      graph.putIfAbsent(divisor, new HashMap<>());

      graph.get(dividend).put(divisor, quotient);
      graph.get(divisor).put(dividend, 1.0 / quotient);
    }

    double[] results = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      results[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), graph);
    }
    return results;
  }

  private double bfs(String src, String target, HashMap<String, HashMap<String, Double>> graph) {
    if (!graph.containsKey(src) || !graph.containsKey(target))
      return -1.0;
    Queue<Pair<String, Double>> q = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    q.add(new Pair<String,Double>(src, 1.0));
    visited.add(src);
    while (!q.isEmpty()) {
      Pair<String, Double> vertex = q.poll();
      if (vertex.getKey().equals(target))
        return vertex.getValue();
      HashMap<String, Double> neighbor = graph.get(vertex.getKey());
      for (String n : neighbor.keySet()) {
        if (!visited.contains(n)) {
          q.add(new Pair<String,Double>(n, vertex.getValue() * neighbor.get(n)));
          visited.add(n);
        }
      }
    }
    
    return -1.0;
  }

  public static void Run() {
    EvaluateDivision solution = new EvaluateDivision();
    List<List<String>> equations = new ArrayList<>();
    equations.add(new ArrayList<>(Arrays.asList("a", "b")));
    equations.add(new ArrayList<>(Arrays.asList("b", "c")));
    double[] values = { 2.0, 3.0 };
    List<List<String>> queries = new ArrayList<>();
    queries.add(new ArrayList<>(Arrays.asList("a", "c")));
    queries.add(new ArrayList<>(Arrays.asList("b", "a")));
    queries.add(new ArrayList<>(Arrays.asList("a", "e")));
    queries.add(new ArrayList<>(Arrays.asList("a", "a")));
    queries.add(new ArrayList<>(Arrays.asList("x", "x")));
    double[] results = solution.calcEquation(equations, values, queries);
    for (double result : results) {
      System.out.println(result);
    }
  }
}
