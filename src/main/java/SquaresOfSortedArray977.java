public class SquaresOfSortedArray977 {

    /*public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }*/

    public int[] sortedSquares(int[] nums) {
        int pivotPoint = finPivotPoint(nums);
        System.out.println(pivotPoint);
        if (pivotPoint >= 0) {
            reversePartOfArray(nums, pivotPoint);
            //print(nums);
            merge(nums, 0, pivotPoint, pivotPoint + 1, nums.length - 1);
            //print(nums);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }

    private void reversePartOfArray(int[] nums, int end) {
        int i = 0;
        int j = end;
        while (i <= j) {
            int temp = nums[i];
            nums[i] = -nums[j];
            nums[j] = -temp;
            i++;
            j--;
        }
    }

    private int finPivotPoint(int[] nums) {
        int pivotPoint = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i - 1] < 0) {
                return i - 1;
            } else if (nums[i] < 0 && i == nums.length - 1) {
                return i;
            }
        }
        return pivotPoint;
    }

    private void merge(int[] input, int s1, int e1, int s2, int e2) {
        int[] helper = new int[(e1 - s1) + (e2 - s2) + 2];
        //System.out.println(helper.length);
        int i = s1;
        int j = s2;
        int k = 0;
        while (i <= e1 && j <= e2) {
            if (input[i] > input[j]) {
                helper[k] = input[j];
                j++;
                k++;
            } else {
                helper[k] = input[i];
                i++;
                k++;
            }
        }
        while (i <= e1) {
            helper[k] = input[i];
            k++;
            i++;
        }
        while (j <= e2) {
            helper[k] = input[j];
            k++;
            j++;
        }
        //print(helper);
        k = 0;
        for (i = s1; i <= e1; i++) {
            input[i] = helper[k];
            k++;
        }
        for (i = s2; i <= e2; i++) {
            input[i] = helper[k];
            k++;
        }
    }

    public static void main(String[] args) {
        SquaresOfSortedArray977 squaresOfSortedArray977 = new SquaresOfSortedArray977();
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        nums = squaresOfSortedArray977.sortedSquares(nums);
        //squaresOfSortedArray977.merge(nums, 0, 1, 2, 4);
        print(nums);
        nums = new int[]{-7, -3, 2, 3, 11};
        nums = squaresOfSortedArray977.sortedSquares(nums);
        print(nums);
        nums = new int[]{-2, 0};
        nums = squaresOfSortedArray977.sortedSquares(nums);
        print(nums);
    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
