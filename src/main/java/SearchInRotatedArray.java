public class SearchInRotatedArray {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int findPivotPoint(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (mid > start && nums[mid - 1] > nums[mid]) {
            return mid - 1;
        } else if (mid < end && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (nums[start] >= nums[mid]) {
            return findPivotPoint(nums, start, mid - 1);
        } else {
            return findPivotPoint(nums, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));
    }

}
