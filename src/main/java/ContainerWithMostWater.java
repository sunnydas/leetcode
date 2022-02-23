public class ContainerWithMostWater {

    public static int maxAreaAlt(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        /*
        Two pointer editorial approach
         */
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(heights[i], heights[j]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static int maxArea(int[] heights) {
        /*
        From every point go left and right and find farthest point with
        same heights or more heights
         */
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int left = findFurthestPointOfContainer(true, heights, i);
            int right = findFurthestPointOfContainer(false, heights, i);
            int length = 0;
            int area;
            if (left >= 0) {
                length += (i - left);
            }
            if (right >= 0) {
                length += (right - i);
            }
            area = length * heights[i];
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    private static int findFurthestPointOfContainer(boolean left, int[] heights, int start) {
        int farthestPoint = -1;
        int baseLevel = heights[start];
        if (left) {
            int i = start - 1;
            while (i >= 0) {
                int current = heights[i];
                if (current >= baseLevel) {
                    farthestPoint = i;
                }
                i--;
            }
        } else {
            int i = start + 1;
            while (i < heights.length) {
                int current = heights[i];
                if (current >= baseLevel) {
                    farthestPoint = i;
                }
                i++;
            }
        }
        return farthestPoint;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(input));
        System.out.println(maxAreaAlt(input));
        input = new int[]{1, 1};
        System.out.println(maxArea(input));
        System.out.println(maxAreaAlt(input));
        input = new int[]{2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxArea(input));
        System.out.println(maxAreaAlt(input));
    }

}
