class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums_set = set()
        for num in nums:
            nums_set.add(num)
        if len(nums_set) < 3:
            return max(nums_set)
        
        for i in range(2):
            max_num = max(nums_set)
            nums_set.remove(max_num)
        
        return max(nums_set)