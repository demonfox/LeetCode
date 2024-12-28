// Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest 
// triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be 
// accepted.

public class LargestTriangleArea {
  public double largestTriangleArea(int[][] points) {
    double result = 0;
    for (int i=0; i<points.length - 2; i++) {
      for (int j=i+1; j<points.length - 1; j++) {
        for (int k=j+1; k<points.length; k++) {
          // Heron's formula:
          // double a = Math.sqrt(Math.pow((points[i][0] - points[j][0]), 2) + Math.pow((points[i][1] - points[j][1]), 2));
          // double b = Math.sqrt(Math.pow((points[j][0] - points[k][0]), 2) + Math.pow((points[j][1] - points[k][1]), 2));
          // double c = Math.sqrt(Math.pow((points[k][0] - points[i][0]), 2) + Math.pow((points[k][1] - points[i][1]), 2));
          // double s = (a + b + c) / 2.0;
          // double area = Math.sqrt(Math.abs(s * (s - a) * (s - b) * (s - c)));
          // System.out.println(String.format("%d, %d, %d, %f", i, j, k, area));

          // Gauss's formula:
          double area = 0.5 * Math.abs(points[i][0] * (points[j][1] - points[k][1]) + points[j][0] * (points[k][1] - points[i][1]) + points[k][0] * (points[i][1] - points[j][1]));
          result = Math.max(result, area);
          
        }
      }
    }
    return result;
  }

  public static void Run() {
    LargestTriangleArea lta = new LargestTriangleArea();
    int[][] points = new int[][] {{0, 0},{0, 1},{1, 0}, {0, 2},{2, 0}};
    //System.out.println(lta.largestTriangleArea(points));

    points = new int[][] {{0, 0},{0, 1},{1, 0}};
    System.out.println(lta.largestTriangleArea(points));


    points = new int[][] {{-35,19},{40,19},{27,-20},{35,-3},{44,20},{22,-21},{35,33},{-19,42},{11,47},{11,37}};
    System.out.println(lta.largestTriangleArea(points));
  }
}
