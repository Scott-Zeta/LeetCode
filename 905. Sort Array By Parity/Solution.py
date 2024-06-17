class Solution(object):
    def sortArrayByParity(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        i = 0
        j = len(nums) - 1
        while i < j:
            # if i is odd, j is even, swap
            if nums[i] % 2 > nums [j] % 2:
                nums[i], nums[j] = nums[j], nums[i]
            # if i is even, move pointer to i + 1
            if nums[i] % 2 == 0:
                i += 1
            # if j is odd, move pointer to j - 1    
            if nums[j] % 2 == 1:
                j -= 1
        return nums
    
# As the question didn't require change the arrya in place, it is accpectable to generate a new array