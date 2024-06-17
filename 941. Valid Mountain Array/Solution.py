class Solution(object):
    def validMountainArray(self, arr):
        """
        :type arr: List[int]
        :rtype: bool
        """
        i = 0
        # climb up if there is upward slope
        while i + 1 < len(arr) and arr[i] < arr[i+1]:
            i +=1
        
        # It is not mountain if peak at the begining or end
        if i == 0 or i == len(arr) - 1:
            return False
        
        # go down if there is down ward slope
        while i + 1 < len(arr) and arr[i] > arr[i+1]:
            i +=1
        
        # when finish traversal, if it is at the last indedx, then valid mountain
        return i == len(arr) - 1
        
        