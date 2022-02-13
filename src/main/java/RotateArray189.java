public class RotateArray189 {


    public void rotate(int[] nums, int k) {
        int[] rotated = rotateNow(nums, k);
        for(int i = 0 ; i< nums.length ; i++){
            nums[i] = rotated[i];
        }
    }

    private int[] rotateNow(int[] nums, int k) {
        int[] rotated = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newPosition = Math.floorMod(i+ k, nums.length);
            //System.out.println(newPosition);
            rotated[newPosition] = nums[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        RotateArray189 rotateArray189 = new RotateArray189();
        rotateArray189.rotate(nums, 3);
        SquaresOfSortedArray977.print(nums);
    }
}
