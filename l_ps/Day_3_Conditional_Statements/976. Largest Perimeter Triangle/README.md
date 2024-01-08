Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

 

Example 1:

Input: nums = [2,1,2]
Output: 5
Example 2:

Input: nums = [1,2,1]
Output: 0
 

Constraints:

3 <= nums.length <= 104
1 <= nums[i] <= 106

Approach 1: Sort
Intuition

Without loss of generality, say the sidelengths of the triangle are a \leq b \leq ca≤b≤c. The necessary and sufficient condition for these lengths to form a triangle of non-zero area is a + b > ca+b>c.

Say we knew cc already. There is no reason not to choose the largest possible aa and bb from the array. If a + b > ca+b>c, then it forms a triangle, otherwise it doesn't.

Algorithm

This leads to a simple algorithm: Sort the array. For any cc in the array, we choose the largest possible a \leq b \leq ca≤b≤c: these are just the two values adjacent to cc. If this forms a triangle, we return the answer.


Complexity Analysis

Time Complexity: O(N \log N)O(NlogN), where NN is the length of A.

Space Complexity: O(1)O(1).

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
