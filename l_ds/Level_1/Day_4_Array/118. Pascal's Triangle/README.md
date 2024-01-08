Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30


Solution Article
Approach 1: Dynamic Programming
Intuition

If we have the a row of Pascal's triangle, we can easily compute the next row by each pair of adjacent values.

Algorithm

Although the algorithm is very simple, the iterative approach to constructing Pascal's triangle can be classified as dynamic programming because we construct each row based on the previous row.

First, we generate the overall triangle list, which will store each row as a sublist. Then, we check for the special case of 00, as we would otherwise return [1][1]. Since numRowsnumRows is always greater than 00, we can initialize triangle with [1][1] as its first row, and proceed to fill the rows as follows:

Current
7 / 12

Complexity Analysis

Time complexity: O(numRows^2)O(numRows 
2
 )

Although updating each value of triangle happens in constant time, it is performed O(numRows^2)O(numRows 
2
 ) times. To see why, consider how many overall loop iterations there are. The outer loop obviously runs numRowsnumRows times, but for each iteration of the outer loop, the inner loop runs rowNumrowNum times. Therefore, the overall number of triangle updates that occur is 1 + 2 + 3 + \ldots + numRows1+2+3+…+numRows, which, according to Gauss' formula, is

\begin{aligned} \frac{numRows(numRows+1)}{2} &= \frac{numRows^2 + numRows}{2} \\ &= \frac{numRows^2}{2} + \frac{numRows}{2} \\ &= O(numRows^2) \end{aligned} 
2
numRows(numRows+1)
​
 
​
  
= 
2
numRows 
2
 +numRows
​
 
= 
2
numRows 
2
 
​
 + 
2
numRows
​
 
=O(numRows 
2
 )
​
 

Space complexity: O(1)O(1)

While O(numRows^2)O(numRows 
2
 ) space is used to store the output, the input and output generally do not count towards the space complexity.


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
