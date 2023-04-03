// 11. Container With Most Water
// https://leetcode.com/problems/container-with-most-water/description/
// 93% faster and 56% efficient

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {6,3,5,4,8,10,7,6,4};
        ContainerMostWaterSolution c = new ContainerMostWaterSolution();
        System.out.println(c.maxArea(height));
        System.out.println(c.maxArea(height2));
    }
}

class ContainerMostWaterSolution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;

        while(start < end){
            if(height[end] > height[start]){
                maxArea = Math.max( maxArea, height[start] * (end - start));
                start++;
            }else{
                maxArea = Math.max( maxArea, height[end] * (end - start));
                end--;
            }
        }
        return maxArea;
    }
}