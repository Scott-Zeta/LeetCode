class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        x = len(matrix[0])
        y = len(matrix)
        
        i = 0
        j = -1
        
        res = []
        while x > 0 and y > 0:
            print(f"x,y:{x},{y}")
            # Move right
            for step in range(x):
                j +=1
                res.append(matrix[i][j])
                print(f"({i},{j}):{matrix[i][j]}")
            y -=1
            print(f"x,y:{x},{y}")
            
            # Move down
            for step in range(y):
                i +=1
                res.append(matrix[i][j])
                print(f"({i},{j}):{matrix[i][j]}")
            x -=1
            print(f"x,y:{x},{y}")

            # Move left
            for step in range(x):
                j -=1
                res.append(matrix[i][j])
                print(f"({i},{j}):{matrix[i][j]}")
            y -=1
            print(f"x,y:{x},{y}")

            # Move up
            for step in range(y):
                i -=1
                res.append(matrix[i][j])
                print(f"({i},{j}):{matrix[i][j]}")
            x -=1

        print(res)
        return res
    
test = Solution()
# Case 1
test.spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]])
# Case 2
# test.spiralOrder([[1,2,3],[4,5,6],[7,8,9]])
# Case 3
test.spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]])