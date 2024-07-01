class Solution:
    def arrayPairSum(self, nums: list[int]) -> int:
        constraint = 10000
        count_arrary = [0] * (constraint * 2 + 1)
        for num in nums:
            count_arrary[num + constraint] += 1
        # print(count_arrary)
        
        res = 0
        last_is_odd = False
        for index in range(len(count_arrary)):
            count = count_arrary[index]
            if count > 0:
                if last_is_odd == True:
                    count -= 1
                if count % 2 == 0:
                    res += count // 2 * (index - constraint)
                    last_is_odd = False
                else:
                    res += (count // 2 + 1) * (index - constraint)
                    last_is_odd = True
        return res
    
test = Solution()        
print(test.arrayPairSum([6,2,6,5,1,2]))
print(test.arrayPairSum([1,4,3,2]))