// -----------  Problem Synopsis  ----------- //
// There are two sorted arrays A and B of size m and n respectively. 
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
// ------------------------------------------ //

public class MedianOfTwoSortedArrays {
    
    public double findMedianSortedArrays(int A[], int B[]) {
        int newArrayLen = A.length + B.length;
        int result[] = new int[newArrayLen];
        int i = 0;
        int j = 0;
        int k = 0;
        for (; i < A.length && j < B.length;) {
            if (A[i] < B[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = B[j++];
            }
        }
        if (i == A.length) {
            for (; j < B.length;) {
                result[k++] = B[j++];
            }
        } else {
            for (; i < A.length;) {
                result[k++] = A[i++];
            }
        }
        if (newArrayLen % 2 == 0) {
            return (result[(newArrayLen + 1) / 2] + result[(newArrayLen - 1) / 2]) / 2.0;
        } else {
            return result [newArrayLen / 2 ];
        }
    }
    
    public static void Run() {
        MedianOfTwoSortedArrays s = new MedianOfTwoSortedArrays();
        System.out.println(s.findMedianSortedArrays(new int[] {}, new int[] {2, 3}));
        //System.out.println(s.findMedianSortedArrays(new int[] {}, new int[] {}));
        System.out.println(s.findMedianSortedArrays(new int[] {1000}, new int[] {-100, -1, 3, 5, 999}));
        System.out.println(s.findMedianSortedArrays(new int[] {1, 3, 5, 7}, new int[] {-7, -5, -3, -1}));
        System.out.println(s.findMedianSortedArrays(new int[] {2, 3}, new int[] {}));
        System.out.println(s.findMedianSortedArrays(new int[] {22, 53, 74, 288}, new int[] {5, 6, 99, 231, 3000}));
        System.out.println(s.findMedianSortedArrays(new int[] {1, 1, 1, 1}, new int[] {1, 1}));
        System.out.println(s.findMedianSortedArrays(new int[] {2, 2, 2, 2}, new int[] {6, 6, 6, 6, 6}));
    }
}
