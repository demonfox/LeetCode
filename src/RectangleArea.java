// Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
// The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
// The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

public class RectangleArea {
  public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    if (bx1 < ax2 && bx2 > ax1 && by1 < ay2 && by2 > ay1) {
       return (ax2-ax1) * (ay2-ay1) + (bx2-bx1) * (by2-by1) - (Math.min(ax2, bx2) - Math.max(ax1, bx1)) * (Math.min(ay2, by2) - Math.max(ay1, by1));
    } else {
      return (ax2-ax1) * (ay2-ay1) + (bx2-bx1) * (by2-by1);
    }
  }

  public static void Run() {
    RectangleArea rectangleArea = new RectangleArea();
    System.out.println(rectangleArea.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    System.out.println(rectangleArea.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
  }
}
