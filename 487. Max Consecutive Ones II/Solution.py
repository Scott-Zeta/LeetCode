class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return 1
        count = 0
        sum_arrays = []
        sub_sum_array = []
        for i in range(len(nums)):
            if nums[i] == 1:
                count += 1
            else:
                sub_sum_array.append(count)
                count = 0
                if i == len(nums) - 1 or nums[i + 1] == 0:
                    sub_sum_array.append(count)  # Append zero if next is zero or end of array
                    sum_arrays.append(sub_sum_array)
                    sub_sum_array = []
        if count > 0:  # Add last segment if ended with 1's
            sub_sum_array.append(count)
            sum_arrays.append(sub_sum_array)
        print(sum_arrays)
        
        max_consecutive = 0
        for array in sum_arrays:
            if len(array) == 1:
                return array[0]
            for i in range(len(array) - 1):
                consecutive = array[i] + array[i+1] + 1
                if consecutive > max_consecutive:
                    max_consecutive = consecutive
        return max_consecutive
        
        
test = Solution()
print(test.findMaxConsecutiveOnes([1,0,1,1,0]))
print(test.findMaxConsecutiveOnes([1,0,1,1,0,1,1]))
print(test.findMaxConsecutiveOnes([0,0,1,0,1,1,0,1,0,0,0,1,0]))
print(test.findMaxConsecutiveOnes([1,1,1]))
print(test.findMaxConsecutiveOnes([0,0,0]))
print(test.findMaxConsecutiveOnes([1,0,1,1,0,1]))            