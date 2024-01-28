using Internal;

public class Solution
{
  private int steps = 0;

  public int NumberOfSteps(int num)
  {
    if (num == 0)
    {
      return steps;
    }

    if (num % 2 == 0)
    {
      steps++;
      return NumberOfSteps(num / 2);
    }
    else
    {
      steps++;
      return NumberOfSteps(num - 1);
    }
  }
}

Solution test = new();
Console.WriteLine(test.NumberOfSteps(123).ToString());