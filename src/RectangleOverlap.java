// An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, 
// and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and 
// right edges are parallel to the Y-axis.
// Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or 
// edges do not overlap.
// Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.

public class RectangleOverlap {
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    return ((rec1[0] <= rec2[0] && rec2[0] < rec1[2]) || (rec1[0] < rec2[2] && rec2[2] <= rec1[2])
            || (rec2[0] <= rec1[0] && rec1[0] < rec2[2]) || (rec2[0] < rec1[2] && rec1[2] <= rec2[2]))
            && ((rec1[1] <= rec2[1] && rec2[1] < rec1[3]) || (rec1[1] < rec2[3] && rec2[3] <= rec1[3])
                || (rec2[1] <= rec1[1] && rec1[1] < rec2[3]) || (rec2[1] < rec1[3] && rec1[3] <= rec2[3]));
  }

  public static void Run() {
    RectangleOverlap r = new RectangleOverlap();
    int[] rec1 = {0,0,2,2};
    int[] rec2 = {1,1,3,3};
    System.out.println(r.isRectangleOverlap(rec1, rec2));
    int[] rec3 = {0,0,1,1};
    int[] rec4 = {1,0,2,1};
    System.out.println(r.isRectangleOverlap(rec3, rec4));
    int[] rec5 = {0,0,1,1};
    int[] rec6 = {1,1,2,2};
    System.out.println(r.isRectangleOverlap(rec5, rec6));
    int[] rec7 = {0,0,1,1};
    int[] rec8 = {2,2,3,3};
    System.out.println(r.isRectangleOverlap(rec7, rec8));
    int[] rec9 = {4,4,14,7};
    int[] rec10 = {4,3,8,8};
    System.out.println(r.isRectangleOverlap(rec9, rec10));
  }
}
