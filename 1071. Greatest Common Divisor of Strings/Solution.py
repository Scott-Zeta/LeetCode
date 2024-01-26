class Solution:
  
  # Euclidean Algorithm to get Greatest Common Divisor of two numbers
  def gcd(self, a, b):
    if b == 0:
      return a
    return self.gcd(b, a % b)
  
  def gcdOfStrings(self, str1: str, str2: str):
    # If two strings don't share common GCD, then they are different when concatenated
    # This is the key step to exclude the case where str1 and str2 are different
    if str1 + str2 != str2 + str1:
      return ""
    
    # The GCD String must have the length of the GCD of the two strings' length
    g_length = self.gcd(len(str1), len(str2))
    return str1[:g_length]
  
test = Solution()
print(test.gcdOfStrings("ABCABC", "ABC"))
print(test.gcdOfStrings("ABABAB", "ABAB"))
print(test.gcdOfStrings("LEET", "CODE"))
    
      