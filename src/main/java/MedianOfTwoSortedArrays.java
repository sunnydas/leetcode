import java.math.BigDecimal;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);
        //print(merged);
        return findMedian(merged);
    }

    private void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private double findMedian(int[] merged) {
        int mid = merged.length / 2;
        Double val;
        if (merged.length % 2 == 0) {
            val = (merged[mid] + merged[mid - 1]) / 2.00000d;
        } else {
            val = merged[mid] / 1.00000;
        }
       return val;
    }

    private int[] merge(int[] num1, int[] num2) {
        /*
        Input: nums1 = [1,3], nums2 = [2]
         */
        /*
        Input: nums1 = [1,2], nums2 = [3,4]
         */
        int aux[] = new int[num1.length + num2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] > num2[j]) {
                aux[k] = num2[j];
                j++;
            } else {
                aux[k] = num1[i];
                i++;
            }
            k++;
        }
        while (i < num1.length) {
            aux[k] = num1[i];
            k++;
            i++;
        }
        while (j < num2.length) {
            aux[k] = num2[j];
            k++;
            j++;
        }
        return aux;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2};
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(num1, num2));
    }

}
