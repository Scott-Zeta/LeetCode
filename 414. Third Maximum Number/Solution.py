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
    
    def heap_thirdMax(self,nums):
        import heapq
        nums_set = set(nums)
        min_heap = []
        for num in nums_set:
            if len(min_heap) >= 3:
                if num > min_heap[0]:
                    heapq.heappush(min_heap,num)
                    heapq.heappop(min_heap)
            else:
                heapq.heappush(min_heap,num)
        print(min_heap)
        if len(min_heap) < 3:
            return min_heap[-1]
        
        return min_heap[0]

test = Solution()
print(test.thirdMax([1,2,2,5,3,5]))