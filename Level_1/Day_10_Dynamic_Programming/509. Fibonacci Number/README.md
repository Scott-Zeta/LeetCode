The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

 

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Constraints:

0 <= n <= 30



Approach 5: Matrix Exponentiation
Intuition

Use Matrix Exponentiation to get the Fibonacci number from the element at (0, 0) in the resultant matrix.

In order to do this we can rely on the matrix equation for the Fibonacci sequence, to find the Nth Fibonacci number: \begin{pmatrix} 1\,\,1 \\ 1\,\,0 \end{pmatrix}^{n}=\begin{pmatrix} \: F_{(n+1)}\;\;\:F_{(n)}\\ \: F_{(n)}\;\;\:F_{(n-1)} \end{pmatrix}( 
11
10
​
 ) 
n
 =( 
F 
(n+1)
​
 F 
(n)
​
 
F 
(n)
​
 F 
(n−1)
​
 
​
 )

Algorithm

Check if N is less than or equal to 1. If it is, return N.
Use a recursive function, matrixPower, to calculate the power of a given matrix A. The power will be N-1, where N is the Nth Fibonacci number.
The matrixPower function will be performed for N/2 of the Fibonacci numbers.
Within matrixPower, call the multiply function to multiply 2 matrices.
Once we finish doing the calculations, return A[0][0] to get the Nth Fibonacci number.
Implementation


Complexity Analysis

Time complexity: O(\log N)O(logN). By halving the N value in every matrixPower's call to itself, we are halving the work needed to be done.

Space complexity: O(\log N)O(logN). The size of the stack in memory is proportional to the function calls to matrixPower plus the memory used to account for the matrices which use constant space.


Approach 6: Math
Intuition

Let's use the golden ratio, a.k.a Binet's forumula: \varphi = \frac{1 + \sqrt{5}}{2} \approx 1.6180339887....φ= 
2
1+ 
5
​
 
​
 ≈1.6180339887....

Here's a link to find out more about how the Fibonacci sequence and the golden ratio work.

We can derive the most efficient solution to this problem using only constant space!

Algorithm

Use the golden ratio formula to calculate the Nth Fibonacci number.
Implementation


Complexity Analysis

Time complexity: O(\log N)O(logN). We do not use loops or recursion, so the time required equals the time spent performing the calculation using Binet's formula. However, raising the golden_ratio to the power of NN requires O(\log N)O(logN) time.

Space complexity: O(1)O(1). The space used is the space needed to create the variable to store the golden ratio.

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
