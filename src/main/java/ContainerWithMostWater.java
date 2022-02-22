public class ContainerWithMostWater {

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
        input = new int[]{1,1};
        System.out.println(maxArea(input));
    }

}
