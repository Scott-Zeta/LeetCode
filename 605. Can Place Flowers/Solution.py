class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        count, slot = 0, 0
        for i in range(len(flowerbed)):
          if flowerbed[i] == 0:
            count += 1
            if i == 0:
              count += 1
            if i == len(flowerbed) - 1:
              count += 1
            if count >= 3:
              slot += 1
              count = 1
          else:
            count = 0
        return slot >= n

test = Solution()
print(test.canPlaceFlowers([1,0,0,0,1], 1)) # True
print(test.canPlaceFlowers([1,0,0,0,1], 2)) # False
print(test.canPlaceFlowers([1,0,0,0], 1)) # True
print(test.canPlaceFlowers([0,0,1,0,0], 2)) # True
print(test.canPlaceFlowers([0], 1)) # True