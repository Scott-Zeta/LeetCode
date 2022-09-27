Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1


Intuition
On the first sight, the problem is trivial. Let's traverse the tree and check at each step if node.right.val > node.val and node.left.val < node.val. This approach would even work for some trees compute

The problem is this approach will not work for all cases. Not only the right child should be larger than the node but all the elements in the right subtree. Here is an example :

compute

That means one should keep both upper and lower limits for each node while traversing the tree, and compare the node value not with children values but with these limits.


Approach 1: Recursive Traversal with Valid Range
The idea above could be implemented as a recursion. One compares the node value with its upper and lower limits if they are available. Then one repeats the same step recursively for left and right subtrees.

Current
2 / 4

Complexity Analysis

Time complexity : \mathcal{O}(N)O(N) since we visit each node exactly once.
Space complexity : \mathcal{O}(N)O(N) since we keep up to the entire tree.


Approach 2: Iterative Traversal with Valid Range
The above recursion could be converted into iteration, with the help of an explicit stack. DFS would be better than BFS since it works faster here.


Complexity Analysis

Time complexity : \mathcal{O}(N)O(N) since we visit each node exactly once.
Space complexity : \mathcal{O}(N)O(N) since we keep up to the entire tree.


Approach 3: Recursive Inorder Traversal
Algorithm

Let's use the order of nodes in the inorder traversal Left -> Node -> Right.

postorder

Here the nodes are enumerated in the order you visit them, and you could follow 1-2-3-4-5 to compare different strategies.

Left -> Node -> Right order of inorder traversal means for BST that each element should be smaller than the next one.

Hence the algorithm with \mathcal{O}(N)O(N) time complexity and \mathcal{O}(N)O(N) space complexity could be simple:

Compute inorder traversal list inorder.

Check if each element in inorder is smaller than the next one.

postorder

Do we need to keep the whole inorder traversal list?

Actually, no. The last added inorder element is enough to ensure at each step that the tree is BST (or not). Hence one could merge both steps into one and reduce the used space.

Code

We can implement the algorithm recursively.


Complexity Analysis

Time complexity : \mathcal{O}(N)O(N) in the worst case when the tree is a BST or the "bad" element is a rightmost leaf.

Space complexity : \mathcal{O}(N)O(N) for the space on the run-time stack.



Approach 4: Iterative Inorder Traversal
Alternatively, we could implement the above algorithm iteratively.


Complexity Analysis

Time complexity : \mathcal{O}(N)O(N) in the worst case when the tree is BST or the "bad" element is a rightmost leaf.

Space complexity : \mathcal{O}(N)O(N) to keep stack.

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
