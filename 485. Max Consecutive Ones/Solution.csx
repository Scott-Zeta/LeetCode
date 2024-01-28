public class Solution
{
  public int FindMaxConsecutiveOnes(int[] nums)
  {
    int max = 0;
    int count = 0;
    foreach (int n in nums)
    {
      if (n == 1)
      {
        count++;
      }
      else
      {
        if (count > max)
          max = count;
        count = 0;
      }
    }
    if (count > max)
      max = count;
    return max;
  }
}

Solution test = new Solution();
Console.WriteLine(test.FindMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));