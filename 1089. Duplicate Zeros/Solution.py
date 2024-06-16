class Solution(object):
    def duplicateZeros(self, arr):
        """
        :type arr: List[int]
        :rtype: None Do not return anything, modify arr in-place instead.
        """
        n = len(arr)
        dup_arr= []
        
        for num in arr:
            if len(dup_arr) == n:
                break
            if num == 0:
                dup_arr.append(0)
            dup_arr.append(num)

        for i in range(n):
            arr[i] = dup_arr[i]
            