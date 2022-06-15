from re import I
from pip import List
class Solution:
    def twoSums(nums:List[int],target:int) -> List[int]:
        print(nums)
        print(target)

        numsDict = {}
        index = 0
        while index < len(nums):
            numsDict[index] = nums[index]
            index = index + 1
        
        i = 0
        while i < len(nums):
            value = target - nums[i]
            if(value in numsDict):
                return [i,]

    demo = twoSums(nums=[1,2,3,4], target=6)
