// 42. Trapping Rain Water
// https://leetcode.com/problems/trapping-rain-water/
// faster than 98% and uses 89% less memory

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int[] height2 = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWaterSolution t = new TrappingRainWaterSolution();
        System.out.println(t.trap(height));
        System.out.println(t.trap(height2));
    }
}

class TrappingRainWaterSolution {
    public int trap(int[] height) {
        int ans = 0;
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];

        maxL[0] = 0;
        for (int i = 0; i < height.length-1; i++) {
            maxL[i+1] = Math.max(maxL[i], height[i]);
        }

        maxR[height.length - 1] = 0;
        for (int i = height.length-1; i > 0; i--) {
            maxR[i-1] = Math.max(maxR[i], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            int diff = Math.min(maxL[i],maxR[i]) - height[i];
            if(diff > 0){
                ans += diff;
            }
        }

        return ans;
    }
}