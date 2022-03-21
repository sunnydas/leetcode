public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] == nums[i - 1]) {
                shift(nums, i-1);
                //print(nums);
            }
            i--;
        }
        int k = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == Integer.MIN_VALUE) {
                break;
            }
            k++;
        }
        //print(nums);
        return k;
    }

    private static void print(int[] nums){
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] shift(int[] nums, int i) {
        int j = i;
        while (j < nums.length - 1) {
            nums[j] = nums[j + 1];
            nums[j + 1] = Integer.MIN_VALUE;
            j++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{1,1};
        System.out.println(removeDuplicates(nums));
    }

}
