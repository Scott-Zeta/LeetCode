You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

 

Example 1:


Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:


Input: root = [4,2,7,1,3], val = 5
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107


Approach 1: Recursion
Algorithm

The recursion implementation is very straightforward:

If the tree is empty root == null or the value to find is here val == root.val - return root.

If val < root.val - go to search into the left subtree searchBST(root.left, val).

If val > root.val - go to search into the right subtree searchBST(root.right, val).

Return root.

bla

Implementation


Complexity Analysis

Time complexity : \mathcal{O}(H)O(H), where HH is a tree height. That results in \mathcal{O}(\log N)O(logN) in the average case, and \mathcal{O}(N)O(N) in the worst case.

Let's compute time complexity with the help of master theorem T(N) = aT\left(\frac{N}{b}\right) + \Theta(N^d)T(N)=aT( 
b
N
​
 )+Θ(N 
d
 ). The equation represents dividing the problem up into aa subproblems of size \frac{N}{b} 
b
N
​
  in \Theta(N^d)Θ(N 
d
 ) time. Here at step there is only one subproblem a = 1, its size is a half of the initial problem b = 2, and all this happens in a constant time d = 0, as for the binary search. That means that \log_b{a} = dlog 
b
​
 a=d and hence we're dealing with case 2 that results in \mathcal{O}(n^{\log_b{a}} \log^{d + 1} N)O(n 
log 
b
​
 a
 log 
d+1
 N) = \mathcal{O}(\log N)O(logN) time complexity.

Space complexity : \mathcal{O}(H)O(H) to keep the recursion stack, i.e. \mathcal{O}(\log N)O(logN) in the average case, and \mathcal{O}(N)O(N) in the worst case.


Approach 2: Iteration
To reduce the space complexity, one could convert recursive approach into the iterative one:

While the tree is not empty root != null and the value to find is not here val != root.val:

If val < root.val - go to search into the left subtree root = root.left.

If val > root.val - go to search into the right subtree root = root.right.

Return root.

bla

Implementation


Complexity Analysis

Time complexity : \mathcal{O}(H)O(H), where HH is a tree height. That results in \mathcal{O}(\log N)O(logN) in the average case, and \mathcal{O}(N)O(N) in the worst case.

Let's compute time complexity with the help of master theorem T(N) = aT\left(\frac{N}{b}\right) + \Theta(N^d)T(N)=aT( 
b
N
​
 )+Θ(N 
d
 ). The equation represents dividing the problem up into aa subproblems of size \frac{N}{b} 
b
N
​
  in \Theta(N^d)Θ(N 
d
 ) time. Here at step there is only one subproblem a = 1, its size is a half of the initial problem b = 2, and all this happens in a constant time d = 0, as for the binary search. That means that \log_b{a} = dlog 
b
​
 a=d and hence we're dealing with case 2 that results in \mathcal{O}(n^{\log_b{a}} \log^{d + 1} N)O(n 
log 
b
​
 a
 log 
d+1
 N) = \mathcal{O}(\log N)O(logN) time complexity.

Space complexity : \mathcal{O}(1)O(1) since it's a constant space solution.

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
