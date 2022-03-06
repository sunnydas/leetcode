import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSums = new ArrayList<>();
        Map<Integer, Set<Integer>> elements = new HashMap<>();
        Set<List<Integer>> duplicateRemover = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (elements.containsKey(cur)) {
                elements.put(cur, elements.get(cur)).add(i);
            } else {
                Set<Integer> indexes = new HashSet<>();
                indexes.add(i);
                elements.put(cur, indexes);
            }
        }
        if(elements.size() == 1 && elements.containsKey(0) && elements.get(0).size() >= 3){
            List<Integer> possibleSet = Arrays.asList(0, 0, 0);
            threeSums.add(possibleSet);
            return threeSums;
        }
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                int k = a + b;
                int key;
                if (k <= 0) {
                    key = Math.abs(k);
                } else {
                    key = -k;
                }
                List<Integer> possibleSet = Arrays.asList(a, b, key);
                Collections.sort(possibleSet);
                if (elements.containsKey(key)
                        && ((!elements.get(key).contains(i) && !elements.get(key).contains(j))
                        || (elements.get(key).contains(i) && !elements.get(key).contains(j) && elements.get(key).size() > 1)
                        || (elements.get(key).contains(j) && !elements.get(key).contains(i) && elements.get(key).size() > 1)
                        || (elements.get(key).contains(i) && elements.get(key).contains(j) && elements.get(key).size() > 2))
                        && !duplicateRemover.contains(possibleSet)) {
                    threeSums.add(possibleSet);
                    duplicateRemover.add(possibleSet);
                }
            }
        }
        return threeSums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        nums = new int[]{};
        System.out.println(threeSum(nums));
        nums = new int[]{0};
        System.out.println(threeSum(nums));
        nums = new int[]{0, 0, 0};
        System.out.println(threeSum(nums));
    }

}
