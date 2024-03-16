public class HammingDistance {
  public int hammingDistance(int x, int y) {
    int diff = x ^ y;
    int dist = 0;
    while (diff != 0) {
      if((diff & 1) == 1)
        dist++;

      diff >>= 1;
    }
    return dist;
  }

  public static void Run() {
    HammingDistance h = new HammingDistance();
    System.out.println(h.hammingDistance(1, 4));
    System.out.println(h.hammingDistance(1, 3));
  }
}
