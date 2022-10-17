You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.

 

Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
Example 2:

Input: stones = [1]
Output: 1
 

Constraints:

1 <= stones.length <= 30
1 <= stones[i] <= 1000


Approach 3: Heap-Based Simulation
Intuition

Approach 1 found and removed the maximum stones in O(N)O(N) time, and added the new stone in O(1)O(1) time. Approach 2 inverted this, as finding and removing the maximum stones took O(1)O(1) time, but adding the new stone took O(N)O(N) time. In both cases, we're left with an overall time complexity of O(N)O(N) per stone-smash turn.

We want to find a solution that makes both removing the maximums, and adding a new stone, less than O(N)O(N).

For this kind of maximum-maintenance, we use a Max-Heap, also known as a Max-Priority Queue. A Max-Heap is a data structure that can take items, and can remove and return the maximum, with both operations taking O(\log \, N)O(logN) time. It does this by maintaining the items in a special order (within the array), or as a balanced binary tree. We don't need to know these details though, almost all programming languages have a Heap data structure!

Here is the pseudocode using a Heap.

define function last_stone_weight(stones):
    heap = a new Max-Heap
    add all stones to heap
    while heap contains more than 1 stone:
        heavy_stone_1 = remove max from heap
        heavy_stone_2 = remove max from heap
        if heavy_stone_1 is heavier than heavy_stone_2:
            new_stone = heavy_stone_1 - heavy_stone_2
            add new_stone to heap
    if heap is empty:
        return 0
    return last stone on heap
Algorithm

While most programming languages have a Heap/ Priority Queue data structure, some, such as Python and Java, only have Min-Heap. Just as the name suggests, this is a Heap that instead of always returning the maximum item, it returns the minimum. There are two solutions to this problem:

Multiply all numbers going into the heap by -1, and then multiply them by -1 to restore them when they come out.
Pass a comparator in (language-dependent).
In Python, we'll use the first solution, and in Java we'll use the second.


Complexity Analysis

Let NN be the length of stones.

Time complexity : O(N \, \log \, N)O(NlogN).

Converting an array into a Heap takes O(N)O(N) time (it isn't actually sorting; it's putting them into an order that allows us to get the maximums, each in O(\log \, N)O(logN) time).

Like before, the main loop iterates up to N - 1N−1 times. This time however, it's doing up to three O(\log \, N)O(logN) operation each time; two removes, and an optional add. Like always, the three is an ignored constant. This means that we're doing N \cdot O(\log \, N) = O(N \, \log \, N)N⋅O(logN)=O(NlogN) operations.

Space complexity : O(N)O(N) or O(\log \, N)O(logN).

In Python, converting a list to a heap is done in-place, requiring O(1)O(1) auxillary space, giving a total space complexity of O(1)O(1). Modifying the input has its pros and cons; it saves space, but it means that other functions can't use the same array.

In Java though, it's O(N)O(N) to create the PriorityQueue.

We could reduce the space complexity to O(1)O(1) by implementing our own iterative heapfiy, if needed.




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
