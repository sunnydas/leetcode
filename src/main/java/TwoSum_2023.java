import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_2023 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

https://leetcode.com/problems/two-sum/?envType=featured-list&envId=top-interview-questions
     */

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> trackingMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            trackingMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            final int potentialVal = target - nums[i];
            final Integer index = trackingMap.get(potentialVal);
            if (trackingMap.containsKey(potentialVal) && index != i) {
                return new int[]{i, index};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        int target = -8;
        Arrays.stream(twoSum(nums, target)).forEach(value -> System.out.println(value));
    }

}
