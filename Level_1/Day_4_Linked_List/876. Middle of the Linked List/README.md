Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100

Approach 1: Output to Array
Intuition and Algorithm

Put every node into an array A in order. Then the middle node is just A[A.length // 2], since we can retrieve each node by index.

We can initialize the array to be of length 100, as we're told in the problem description that the input contains between 1 and 100 nodes.


Complexity Analysis

Time Complexity: O(N)O(N), where NN is the number of nodes in the given list.

Space Complexity: O(N)O(N), the space used by A.


Approach 2: Fast and Slow Pointer
Intuition and Algorithm

When traversing the list with a pointer slow, make another pointer fast that traverses twice as fast. When fast reaches the end of the list, slow must be in the middle.


Complexity Analysis

Time Complexity: O(N)O(N), where NN is the number of nodes in the given list.

Space Complexity: O(1)O(1), the space used by slow and fast.

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
