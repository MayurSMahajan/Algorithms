// https://leetcode.com/problems/product-of-array-except-self
// Solution is 50% faster and uses 52% less memory.

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] nums2 = {1,2,3,4};

        ProductOfArrayExceptSelfSolution ps = new ProductOfArrayExceptSelfSolution();
        for(int e : ps.productExceptSelf(nums)){
            System.out.println(e);
        }
        for(int e : ps.productExceptSelf(nums2)){
            System.out.println(e);
        }
    }
}

class ProductOfArrayExceptSelfSolution {
    int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] productsFromLeft = new int[nums.length];
        int[] productsFromRight = new int[nums.length];

        //at the first position since there are no left elements, we assign 1 as product
        productsFromLeft[0] =  1;
        for (int i = 1; i < nums.length; i++) {
            productsFromLeft[i] =  productsFromLeft[i-1] * nums[i-1];
        }

        //first fill dummy values in the productsFromRight array.
        for (int i = 0; i < nums.length; i++) {
            productsFromRight[i] = 1;
        }

        for (int i = nums.length - 2; i > -1; i--) {
            productsFromRight[i] =  productsFromRight[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = productsFromRight[i] * productsFromLeft[i];
        }

        return result;
    }
}