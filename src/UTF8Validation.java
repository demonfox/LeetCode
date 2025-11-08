// Given an integer array data representing the data, return whether it is a valid UTF-8 encoding (i.e. it translates to a sequence 
// of valid UTF-8 encoded characters).
// A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
// For a 1-byte character, the first bit is a 0, followed by its Unicode code.
// For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0, followed by n - 1 bytes with the most significant 
// 2 bits being 10.
// This is how the UTF-8 encoding would work:
//      Number of Bytes   |        UTF-8 Octet Sequence
//                        |              (binary)
//    --------------------+-----------------------------------------
//             1          |   0xxxxxxx
//             2          |   110xxxxx 10xxxxxx
//             3          |   1110xxxx 10xxxxxx 10xxxxxx
//             4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
// x denotes a bit in the binary form of a byte that may be either 0 or 1.
// Note: The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This 
// means each integer represents only 1 byte of data.

public class UTF8Validation {
  public boolean validUtf8(int[] data) {
    int mask_1byte_1 = 0x00000080;
    int mask_1byte_2 = 0x00000000;
    int mask_2bytes_1 = 0x000000E0;
    int mask_2bytes_2 = 0x000000C0;
    int mask_3bytes_1 = 0x000000F0;
    int mask_3bytes_2 = 0x000000E0;
    int mask_4bytes_1 = 0x000000F8;
    int mask_4bytes_2 = 0x000000F0;

    int mask_10xxxxxx_1 = 0x000000C0;
    int mask_10xxxxxx_2 = 0x00000080;

    int currNByteCounter = 0;

    for (int i=0; i<data.length; i++) {
      if (currNByteCounter != 0) {
        if ((data[i] & mask_10xxxxxx_1) == mask_10xxxxxx_2)
          currNByteCounter--;
        else
          return false;
      } else {
        if ((data[i] & mask_1byte_1) == mask_1byte_2) {
          continue;
        } else if ((data[i] & mask_2bytes_1) == mask_2bytes_2) {
          currNByteCounter = 1;
          continue;
        } else if ((data[i] & mask_3bytes_1) == mask_3bytes_2) {
          currNByteCounter = 2;
          continue;
        } else if ((data[i] & mask_4bytes_1) == mask_4bytes_2) {
          currNByteCounter = 3;
          continue;
        }
        return false;
      }
    }
    return (currNByteCounter == 0);
  }

  public static void Run() {
    UTF8Validation utf8Validation = new UTF8Validation();
    int[] data = new int[] {197, 130, 1};
    System.out.println(utf8Validation.validUtf8(data));

    int[] data2 = new int[] {235, 140, 4};
    System.out.println(utf8Validation.validUtf8(data2));
  }
}
