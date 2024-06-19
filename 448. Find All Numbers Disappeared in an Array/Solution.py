class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums) + 1
        
        table = [0] * n
        
        for num in nums:
            table[num] = 1
        
        result = []
        for i in range(1,n):
            if table[i] == 0:
                result.append(i)
        return result