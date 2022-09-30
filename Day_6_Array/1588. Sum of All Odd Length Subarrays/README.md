Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
Example 2:

Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
Example 3:

Input: arr = [10,11,12]
Output: 66
 

Constraints:

1 <= arr.length <= 100
1 <= arr[i] <= 1000

My example:
what if arr = [8,1,4,2,5,3,9] length= 7?
[8] = 8
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[9] = 9
[8,1,4]
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[5,3,9]
[8,1,4,2,5]
[1,4,2,5,3] = 15
[4,2,5,3,9]
[8,1,4,2,5,3,9]

what if arr = [6,8,1,4,2,5,3,9,7] length= 9?
[6]
[8] = 8
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[9] = 9
[7]
[6,8,1]
[8,1,4]
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[5,3,9]
[3,9,7]
[6,8,1,4,2]
[8,1,4,2,5]
[1,4,2,5,3] = 15
[4,2,5,3,9]
[2,5,3,9,7]
[6,8,1,4,2,5,3]
[8,1,4,2,5,3,9]
[1,4,2,5,3,9,7]
[6,8,1,4,2,5,3,9,7]

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
