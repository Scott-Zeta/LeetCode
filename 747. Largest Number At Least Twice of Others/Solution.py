class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # single pass
        max_num = float('-inf')
        second_max_num = float('-inf')
        max_index = float('-inf')
        for i in range(len(nums)):
            if nums[i] > max_num:
                second_max_num = max_num
                max_num = nums[i]
                max_index = i
            elif nums[i] > second_max_num:
                second_max_num = nums[i]
        
        if max_num >= 2 * second_max_num:
            return max_index
        else:
            return -1