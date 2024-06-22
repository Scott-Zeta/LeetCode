class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        base = 10
        carry = 0
        digits.reverse()
        digits[0] += 1
        for i in range(len(digits)):
            if carry:
                digits[i] += carry
            carry = digits[i] // base
            digits[i] = digits[i] % base
            
        if carry:
            digits.append(carry)
        digits.reverse()
        return digits
    
test = Solution()
print(test.plusOne([9,9,9,9]))
            