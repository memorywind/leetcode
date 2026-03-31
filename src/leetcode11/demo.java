package leetcode11;

public class demo {
    public int maxArea(int[] height) {
        int L = 0, R = height.length - 1;
        int ans = 0;
        while (L < R) {
            int len = R - L;
            int high = Math.min(height[L], height[R]);
            int s = len * high;
            ans = Math.max(ans, s);
            if (height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }
        return ans;
    }
}
