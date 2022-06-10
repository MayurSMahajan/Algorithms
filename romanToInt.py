
class Solution:
    def romanToInt(s: str) -> int:
        romanToIntDict = {
            'I' : 1,
            'V' : 5,
            'X' : 10,
            'L' : 50,
            'C' : 100,
            'D' : 500,
            'M' : 1000   
        }
        arr = []
        for c in s:
            arr.append(romanToIntDict[c])
        arr.append(0)

        sum = 0
        i = 0
        while i < len(arr):
            if arr[i] == 1 and (arr[i+1] == 10 or arr[i+1] == 5):
                sum = sum + arr[i+1] - arr[i]
                i = i + 2
            elif arr[i] == 10 and (arr[i+1] == 100 or arr[i+1] == 50):
                sum = sum + arr[i+1] - arr[i]
                i = i + 2
            elif arr[i] == 100 and (arr[i+1] == 1000 or arr[i+1] == 500):
                sum = sum + arr[i+1] - arr[i]
                i = i + 2
            else:
                sum = sum + arr[i]
                i = i + 1
            
        print(sum)   

    romanToInt(s="MCMXCIV")