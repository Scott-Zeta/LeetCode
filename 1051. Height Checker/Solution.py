class Solution(object):
    def heightChecker(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        count = 0
        sorted_list = sorted(heights)
        for i in range(len(heights)):
            if sorted_list[i] != heights[i]:
                count += 1
        return count