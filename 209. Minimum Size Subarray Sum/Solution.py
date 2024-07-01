class Solution:
    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        head = 0
        tail = 0
        shortest_length = float("inf")
        sum = 0
        while tail < len(nums):
            sum += nums[tail]
            if sum >= target:
                # If it is possible pop out head number, shrink the subarray
                while sum - nums[head] >= target:
                    sum -= nums[head]
                    head += 1 
                distance = tail - head + 1
                shortest_length = min(distance,shortest_length)
                # Optimal result, no need to check anymore
                if shortest_length == 1:
                    return 1
            # if sum not enough for target, stretch the tail and subarray length
            tail += 1
        
        # After tail going through entire array, if sum still not engough, no such subarray
        if shortest_length == float("inf"):
            return 0
        return shortest_length
    
test = Solution()
print(test.minSubArrayLen(7,[2,3,1,2,4,3]))
print(test.minSubArrayLen(4,[1,4,4]))
print(test.minSubArrayLen(11,[1,1,1,1,1,1,1,1]))
