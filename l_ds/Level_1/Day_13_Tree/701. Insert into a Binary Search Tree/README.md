You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 

Example 1:


Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:

Example 2:

Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]
Example 3:

Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]
 

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-108 <= Node.val <= 108
All the values Node.val are unique.
-108 <= val <= 108
It's guaranteed that val does not exist in the original BST.


Solution
Intuition
One of the huge BST advantages is a search for arbitrary element in \mathcal{O}(\log N)O(logN) time. Here we'll see that the insert time is \mathcal{O}(\log N)O(logN), too, in the average case.

The problem solution is very simple - one could always insert new node as a child of the leaf. To define which leaf to use, one could follow the standard BST logic :

If val > node.val - go to insert into the right subtree.

If val < node.val - go to insert into the left subtree.

bla



Approach 1: Recursion
The recursion implementation is very straightforward :

If root is null - return TreeNode(val).

If val > root.val - go to insert into the right subtree.

If val < root.val - go to insert into the left subtree.

Return root.

Current
1 / 7

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
The recursion above could be converted into the iteration


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
