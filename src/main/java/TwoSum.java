import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tracker = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            tracker.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int dest = target - nums[i];
            if (tracker.containsKey(dest) && i != tracker.get(dest)) {
                return new int[]{i,tracker.get(dest)};
            }
        }
        return null;
    }

    public static int[] twoSumBruteForce(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(target == (nums[i] + nums[j])){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] sums = twoSum(nums,9);
        for(int i : sums){
            //System.out.println(nums[i]);
        }
        nums = new int[]{3,2,4};
        sums = twoSumBruteForce(nums,6);
        for(int i : sums){
           System.out.println(nums[i]);
        }
    }
}
