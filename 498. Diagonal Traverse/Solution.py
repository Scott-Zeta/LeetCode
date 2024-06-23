class Solution(object):
    def findDiagonalOrder(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[int]
        """
        res = []
        
        for d in range(len(mat) + len(mat[0]) - 1):
            if d % 2 == 0:
                #even diagonal travel up
                i = min(d,len(mat) - 1)
                j = d - i
                while j < len(mat[0]) and i >= 0:
                    # print(f"({i},{j}):{mat[i][j]}")
                    res.append(mat[i][j])
                    i -=1
                    j = d - i
            else:
                #odd diagonal travel down
                j = min(d,len(mat[0]) - 1)
                i = d - j
                while i < len(mat) and j >= 0:
                    # print(f"({i},{j}):{mat[i][j]}")
                    res.append(mat[i][j])
                    j -= 1
                    i = d - j
        # print(res)
        return res
    
test = Solution()
test.findDiagonalOrder([[1,2,3],[4,5,6],[7,8,9]])
test.findDiagonalOrder([[1,2],[3,4]])
test.findDiagonalOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]])