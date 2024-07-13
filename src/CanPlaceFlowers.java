//  You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted 
// in adjacent plots.
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, 
// return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false 
// otherwise.

public class CanPlaceFlowers {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int zeroSeen = 1;
    for (int i=0; i<flowerbed.length; i++) {
      if (flowerbed[i] == 1) {
        n -= (zeroSeen-1)/2;
        if (n <= 0) return true;
        zeroSeen = 0;
      } else {
        zeroSeen++;
      }
    }
    if (zeroSeen != 0) {
      n -= zeroSeen/2;
      if (n <= 0) return true;
    }
    return false;
  }

  public static void Run() {
    int[] flowerbed = {0,0,0,0,1,0,0,0,0,1,0,0,0,1};
    CanPlaceFlowers test = new CanPlaceFlowers();
    System.out.println(test.canPlaceFlowers(flowerbed, 2));
    System.out.println(test.canPlaceFlowers(flowerbed, 3));
    System.out.println(test.canPlaceFlowers(flowerbed, 4));
    System.out.println(test.canPlaceFlowers(flowerbed, 5));

    flowerbed = new int[] {1,0,0,0,1};
    System.out.println(test.canPlaceFlowers(flowerbed, 1));
    System.out.println(test.canPlaceFlowers(flowerbed, 2));

    flowerbed = new int[] {1,0,0,0,1,0,0};
    System.out.println(test.canPlaceFlowers(flowerbed, 1));
    System.out.println(test.canPlaceFlowers(flowerbed, 2));
  }
}
