package leetcode11;

public class main {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 4};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        int j = height.length - 1;
        int maxArea = Math.min(height[0], height[j]) * j;
        for (int i = 0; i < height.length; ) {
            if (height[i] < height[j]) {
                maxArea = Math.max(maxArea, height[i] * (j - i));
                i++;
            } else {
                maxArea = Math.max(maxArea, height[j] * (j - i));
                j--;
            }
            if (i == j) {
                return maxArea;
            }
        }
        return maxArea;
    }
}
