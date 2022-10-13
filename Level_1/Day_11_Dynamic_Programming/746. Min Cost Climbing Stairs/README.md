You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999


Approach 3: Bottom-Up, Constant Space
Intuition

You may have noticed that our recurrence relation from the previous two approaches only cares about 2 steps below the current step. For example, if we are calculating the minimum cost to reach step 12, we only care about data from step 10 and step 11. While we would have needed to calculate the minimum cost for steps 2-9 as well, at the time of the actual calculation for step 12, we no longer care about any of those steps.

Therefore, instead of using O(n)O(n) space to keep an array, we can improve to O(1)O(1) space using only two variables.

Algorithm

Initialize two variables, downOne and downTwo, that represent the minimum cost to reach one step and two steps below the current step, respectively. We will start iteration from step 2, which means these variables will initially represent the minimum cost to reach steps 0 and 1, so we will initialize each of them to 0.

Iterate over the array, again with 1 extra iteration at the end to treat the top floor as the final "step". At each iteration, simulate moving 1 step up. This means downOne will now refer to the current step, so apply our recurrence relation to update downOne. downTwo will be whatever downOne was prior to the update, so let's use a temporary variable to help with the update.

In the end, since we treated the top floor as a step, downOne will refer to the minimum cost to reach the top floor. Return downOne.

Implementation


Complexity Analysis

Given NN as the length of cost,

Time complexity: O(N)O(N).

We only iterate N - 1 times, and at each iteration we apply an equation that uses O(1)O(1) time.

Space complexity: O(1)O(1)

The only extra space we use is 2 variables, which are independent of input size.


## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
