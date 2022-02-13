public class SearchInsertPosition35 {

    public int searchInsert(int[] input, int target) {
        int found = binarySearch(input, 0, input.length - 1, target);
        return found;
    }

    private int binarySearch(int[] input, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (input[mid] == target) {
                return mid;
            } else if (input[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 5, 6};
        SearchInsertPosition35 searchInsertPosition = new SearchInsertPosition35();
        System.out.println(searchInsertPosition.searchInsert(input, 5));
        System.out.println(searchInsertPosition.searchInsert(input, 2));
        System.out.println(searchInsertPosition.searchInsert(input, 7));
        System.out.println(searchInsertPosition.searchInsert(input, 0));
        System.out.println(searchInsertPosition.searchInsert(input, 2));
        input = new int[]{1};
        System.out.println(searchInsertPosition.searchInsert(input, 1));
        input = new int[]{-1,3,5,6};
        System.out.println(searchInsertPosition.searchInsert(input, 0));
    }
}
