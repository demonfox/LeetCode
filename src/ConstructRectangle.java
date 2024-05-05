// A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, 
// your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:
// The area of the rectangular web page you designed must equal to the given target area.
// The width W should not be larger than the length L, which means L >= W.
// The difference between length L and width W should be as small as possible.
// Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.

public class ConstructRectangle {
  public int[] constructRectangle(int area) {
    int squareRoot = (int)Math.sqrt(area);
    if (area == squareRoot * squareRoot)
      return new int[]{squareRoot, squareRoot};
    for (int i = squareRoot; i>=1; i--) {
      if (area % i == 0)
        return new int[]{area / i, i};
    }
    return new int[]{area, 1};
  }

  public static void Run() {
    int[] testCases = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 37, 122122};
    for (int i = 0; i < testCases.length; i++) {
      int area = testCases[i];
      int[] result = new ConstructRectangle().constructRectangle(area);
      System.out.println("Area: " + area + " L: " + result[0] + " W: " + result[1]);
    }
  }
}
