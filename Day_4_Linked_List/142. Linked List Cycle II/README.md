Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.

Approach 1: Hash Table
Intuition

If we keep track of the nodes that we've seen already in a Set, we can traverse the list and return the first duplicate node.

Algorithm

First, we allocate a Set to store ListNode references. Then, we traverse the list, checking visited for containment of the current node. If the node has already been seen, then it is necessarily the entrance to the cycle. If any other node were the entrance to the cycle, then we would have already returned that node instead. Otherwise, the if condition will never be satisfied, and our function will return null.

The algorithm necessarily terminates for any list with a finite number of nodes, as the domain of input lists can be divided into two categories: cyclic and acyclic lists. An acyclic list resembles a null-terminated chain of nodes, while a cyclic list can be thought of as an acyclic list with the final null replaced by a reference to some previous node. If the while loop terminates, we return null, as we have traversed the entire list without encountering a duplicate reference. In this case, the list is acyclic. For a cyclic list, the while loop will never terminate, but at some point the if condition will be satisfied and cause the function to return.


Complexity Analysis

Time complexity : O(n)O(n)

For both cyclic and acyclic inputs, the algorithm must visit each node exactly once. This is transparently obvious for acyclic lists because the nnth node points to null, causing the loop to terminate. For cyclic lists, the if condition will cause the function to return after visiting the nnth node, as it points to some node that is already in visited. In both cases, the number of nodes visited is exactly nn, so the runtime is linear in the number of nodes.

Space complexity : O(n)O(n)

For both cyclic and acyclic inputs, we will need to insert each node into the Set once. The only difference between the two cases is whether we discover that the "last" node points to null or a previously-visited node. Therefore, because the Set will contain nn distinct nodes, the memory footprint is linear in the number of nodes.

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
