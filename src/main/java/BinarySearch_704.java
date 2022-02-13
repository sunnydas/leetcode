public class BinarySearch_704 {

    /*
    https://leetcode.com/problems/binary-search/
     */

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] input, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (input[mid] == target) {
            return mid;
        }
        if (input[mid] < target) {
            return binarySearch(input, mid + 1, end, target);
        }
        return binarySearch(input, start, mid - 1, target);
    }

    public static void main(String[] args) {
        BinarySearch_704 binarySearch = new BinarySearch_704();
        int[] input = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch.search(input, 12));
        input = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch.search(input, 2));
    }

}
