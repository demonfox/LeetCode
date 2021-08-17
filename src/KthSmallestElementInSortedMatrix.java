// Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the 
// kth smallest element in the matrix.
// Note that it is the kth smallest element in the sorted order, not the kth distinct element.

import java.util.PriorityQueue;

class Item implements Comparable<Item> {
  public int row;
  public int col;
  public int val;

  public Item(int r, int c, int v) {
    row = r;
    col = c;
    val = v;
  }

  @Override
  public int compareTo(Item o) {
    return this.val - o.val;
  }
}

public class KthSmallestElementInSortedMatrix {
  public int kthSmallest3(int[][] matrix, int k) {
    PriorityQueue<Item> pqueue = new PriorityQueue<Item>();
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      Item item = new Item(0, i, matrix[0][i]);
      pqueue.add(item);
    }

    while (k-- > 1) {
      Item item = pqueue.poll();
      if (item.row < n - 1) {
        int newR = item.row + 1;
        int newC = item.col;
        pqueue.add(new Item(newR, newC, matrix[newR][newC]));
      }
    }
    return pqueue.peek().val;
  }

  public int kthSmallest2(int[][] matrix, int k) {
    PriorityQueue<Item> pqueue = new PriorityQueue<Item>();
    int n = matrix.length;
    boolean[][] visited = new boolean[n][n];
    pqueue.add(new Item(0, 0, matrix[0][0]));
    visited[0][0] = true;
    for (int i=0; i<k-1; i++) {
      Item item = pqueue.poll();
      if ((item.row < n - 1) && !visited[item.row+1][item.col]) {
        pqueue.add(new Item(item.row+1, item.col, matrix[item.row+1][item.col]));
        visited[item.row+1][item.col] = true;
      }
      if ((item.col < n - 1) && !visited[item.row][item.col+1]) {
        pqueue.add(new Item(item.row, item.col+1, matrix[item.row][item.col+1]));
        visited[item.row][item.col+1] = true;
      }
    }
    return pqueue.peek().val;
  }

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int left = matrix[0][0];
    int right = matrix[n-1][n-1];
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (countLessThanOrEqualTo(mid, matrix) < k)
        left = mid + 1;
      else
        right = mid;
    }
    return right;
  }

  private int countLessThanOrEqualTo(int val, int[][] matrix) {
    int n = matrix.length;
    int row = 0;
    int col = n - 1;
    int count = 0;
    while (row <= n - 1 && col >= 0) {
      if (matrix[row][col] <= val) {
        count += col + 1;
        row++;
      } else {
        col--;
      }
    }
    return count;
  }

  public static void Run() {
    KthSmallestElementInSortedMatrix k = new KthSmallestElementInSortedMatrix();
    int[][] matrix = new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
    //System.out.println(k.kthSmallest(matrix, 8));
    System.out.println(k.kthSmallest(matrix, 1));
    System.out.println(k.kthSmallest(matrix, 2));
    System.out.println(k.kthSmallest(matrix, 9));
  }
}
