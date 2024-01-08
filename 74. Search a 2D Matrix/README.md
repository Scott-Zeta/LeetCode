The key of this part is to simplify complex array index into easier one

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

Approach 1: Binary Search
Intuition

One could notice that the input matrix m x n could be considered as a sorted array of length m x n.

bla

Sorted array is a perfect candidate for the binary search because the element index in this virtual array (for sure we're not going to construct it for real) could be easily transformed into the row and column in the initial matrix

row = idx // n and col = idx % n.

Algorithm

The algorithm is a standard binary search :

Initialise left and right indexes left = 0 and right = m x n - 1.

While left <= right :

Pick up the index in the middle of the virtual array as a pivot index : pivot_idx = (left + right) / 2.

The index corresponds to row = pivot_idx // n and col = pivot_idx % n in the initial matrix, and hence one could get the pivot_element. This element splits the virtual array in two parts.

Compare pivot_element and target to identify in which part one has to look for target.

Implementation

Current
1 / 7

Complexity Analysis

Time complexity : \mathcal{O}(\log(m n))O(log(mn)) since it's a standard binary search.

Space complexity : \mathcal{O}(1)O(1).

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
