class Solution(object):
    def replaceElements(self, arr):
        """
        :type arr: List[int]
        :rtype: List[int]
        """
        max = -1
        for i in range(len(arr) - 1, -1, -1):
            num = arr[i]
            arr[i] = max
            if num > max:
                max = num
        return arr