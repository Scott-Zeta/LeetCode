class Solution(object):
    def findNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        even_digits = 0
        for num in nums:
            if len(str(num)) % 2 == 0:
                even_digits += 1
        
        return even_digits