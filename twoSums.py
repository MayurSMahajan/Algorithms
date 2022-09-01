from re import I
from pip import List
class Solution:
    def twoSums(nums:List[int],target:int) -> List[int]:
        print(nums)
        print(target)

        #using two pointer approach 
        #Note:- Works when array is sorted and i suppose this is leetcode 
                #problem there they have mentioned that the array is sorted.

        left = 0 #pointing to first index
        right = len(nums)-1 #pointing to last index

        while(left<right):
            if(nums[left]+nums[right] == target):
                print(nums[left] , nums[right])
                return[nums[left] , nums[right]]
            
            if(nums[left]+nums[right] > target):
                right = right-1  #sum is greater so it makes sense to reduce the greater value
            else:
                left = left+1   #sum is less so it makes sense to upgrade the lesser value
        
        return []


    demo = twoSums(nums=[1,2,3,4,5,6,7,7,8,8], target=90)