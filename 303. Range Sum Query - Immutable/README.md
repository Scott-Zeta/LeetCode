Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= left <= right < nums.length
At most 104 calls will be made to sumRange.


Approach 3: Caching [Accepted]
The above approach takes a lot of space, could we optimize it?

Imagine that we pre-compute the cummulative sum from index 00 to kk. Could we use this information to derive Sum(i, j)Sum(i,j)?

Let us define sum[k]sum[k] as the cumulative sum for nums[0 \cdots k-1]nums[0⋯k−1] (inclusive):

sum[k] = \left\{ \begin{array}{rl} \sum_{i=0}^{k-1}nums[i] & , k > 0 \\ 0 &, k = 0 \end{array} \right.sum[k]={ 
∑ 
i=0
k−1
​
 nums[i]
0
​
  
,k>0
,k=0
​
 

Now, we can calculate sumRange as following:

sumRange(i, j) = sum[j + 1] - sum[i]sumRange(i,j)=sum[j+1]−sum[i]

Implementation


Notice in the code above we inserted a dummy 0 as the first element in the sum array. This trick saves us from an extra conditional check in sumRange function.

Complexity Analysis

Time complexity: O(1)O(1) time per query, O(n)O(n) time pre-computation. Since the cumulative sum is cached, each sumRange query can be calculated in O(1)O(1) time.

Space complexity: O(n)O(n).


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
