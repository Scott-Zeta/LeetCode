class Solution:
    def addBinary(self, a: str, b: str) -> str:
        # Bit Manipulation method
        x, y = int(a,2), int(b,2)
        while y:
            # XOR for x + y
            res = x ^ y
            # AND for carry
            # << for move bit to left
            carry = (x & y) << 1
            x, y = res, carry
            # Keep iterate until all carries go zero
        # print(bin(x))
        return bin(x)[2:]
        
test = Solution()
print(test.addBinary("11","1"))
print(test.addBinary("1010","1011"))