There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

Constraints:

1 <= m, n <= 100


Solution
Overview
Since robot can move either down or right, there is only one path to reach the cells in the first row: right->right->...->right.

traversal

The same is valid for the first column, though the path here is down->down-> ...->down.

traversal

What about the "inner" cells (m, n)? To such cell one could move either from the cell on the left (m, n - 1), or from the cell above (m - 1, n). That means that the total number of paths to move into (m, n) cell is uniquePaths(m - 1, n) + uniquePaths(m, n - 1).

traversal

Now, one could transform these ideas into 3-liner recursive solution:


This solution is not fast enough to pass all the testcases, though it could be used as a starting point for the DP solution.


Approach 1: Dynamic Programming
One could rewrite recursive approach into dynamic programming one.

Algorithm

Initiate 2D array d[m][n] = number of paths. To start, put number of paths equal to 1 for the first row and the first column. For the simplicity, one could initiate the whole 2D array by ones.

Iterate over all "inner" cells: d[col][row] = d[col - 1][row] + d[col][row - 1].

Return d[m - 1][n - 1].

Implementation

Current
12 / 13

Complexity Analysis

Time complexity: \mathcal{O}(N \times M)O(N×M).

Space complexity: \mathcal{O}(N \times M)O(N×M).


Approach 2: Math (Python3 only)
Could one do better than \mathcal{O}(N \times M)O(N×M)? The answer is yes.

The problem is a classical combinatorial problem: there are h + vh+v moves to do from start to finish, h = m - 1h=m−1 horizontal moves, and v = n - 1v=n−1 vertical ones. One could choose when to move to the right, i.e. to define hh horizontal moves, and that will fix vertical ones. Or, one could choose when to move down, i.e. to define vv vertical moves, and that will fix horizontal ones.

traversal

In other words, we're asked to compute in how many ways one could choose pp elements from p + kp+k elements. In mathematics, that's called binomial coefficients

C_{h + v}^{h} = C_{h + v}^{v} = \frac{(h + v)!}{h! v!}C 
h+v
h
​
 =C 
h+v
v
​
 = 
h!v!
(h+v)!
​
 

The number of horizontal moves to do is h = m - 1h=m−1, the number of vertical moves is v = n - 1v=n−1. That results in a simple formula

C_{h + v}^{h} = \frac{(m + n - 2)!}{(m - 1)! (n - 1)!}C 
h+v
h
​
 = 
(m−1)!(n−1)!
(m+n−2)!
​
 

The job is done. Now time complexity will depend on the algorithm to compute factorial function (m + n - 2)!(m+n−2)!. In short, standard computation for k!k! using the definition requires \mathcal{O}(k^2 \log k)O(k 
2
 logk) time, and that will be not as good as DP algorithm.

The best known algorithm to compute factorial function is done by Peter Borwein. The idea is to express the factorial as a product of prime powers, so that k!k! can be computed in \mathcal{O}(k (\log k \log \log k)^2)O(k(logkloglogk) 
2
 ) time. That's better than \mathcal{O}(k^2)O(k 
2
 ) and hence beats DP algorithm.

The authors prefer not to discuss here various factorial function implementations, and hence provide Python3 solution only, with built-in divide and conquer factorial algorithm. If you're interested in factorial algorithms, please check out good review on this page.

Implementation


Complexity Analysis

Time complexity: \mathcal{O}((M + N) (\log (M + N) \log \log (M + N))^2)O((M+N)(log(M+N)loglog(M+N)) 
2
 ).

Space complexity: \mathcal{O}(1)O(1).



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
