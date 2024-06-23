class Solution(object):
    def findDiagonalOrder(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[int]
        """
        i = len(mat) - 1
        j = len(mat[0]) - 1
        res = []
        
        for d in range(i + j + 1):
            if d % 2 == 0:
                #even diagonal travel up
                pass
            else:
                #odd diagonal travel down
                pass