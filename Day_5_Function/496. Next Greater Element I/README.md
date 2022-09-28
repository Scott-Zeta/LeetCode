The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 

Constraints:

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 104
All integers in nums1 and nums2 are unique.
All the integers of nums1 also appear in nums2.

Approach 3: Using Stack
Algorithm

In this approach, we make use of pre-processing first so as to make the results easily available later on. We make use of a stack (stackstack) and a hashmap (mapmap). mapmap is used to store the result for every posssible number in nums2nums2 in the form of (element, next\_greater\_element)(element,next_greater_element). Now, we will look at how to make entries in mapmap.

We iterate over the nums2nums2 array from the left to right. We push every element nums2[i]nums2[i] on the stack if it is less than the previous element on the top of the stack (stack[top]stack[top]). No entry is made in mapmap for such nums2[i]nums2[i]'s right now. This happens because the nums2[i]nums2[i]'s encountered so far are coming in a descending order.

If we encounter an element nums2[i]nums2[i] such that nums2[i]nums2[i] > stack[top]stack[top], we keep on popping all the elements from stack[top]stack[top] until we encounter stack[k]stack[k] such that stack[k]stack[k] ≥ nums2[i]nums2[i]. For every element popped out of the stack stack[j]stack[j], we put the popped element along with its next greater number (result) into the hashmap mapmap, in the form (stack[j], nums2[i])(stack[j],nums2[i]). Now, the next greater element for all elements stack[j]stack[j], such that kk < jj ≤ toptop is nums2[i]nums2[i] (since this larger element caused all the stack[j]stack[j]'s to be popped out). We stop popping the elements at stack[k]stack[k] because this nums2[i]nums2[i] can't act as the next greater element for the next elements on the stack.

Thus, an element is popped out of the stack whenever a next greater element is found for it. Therefore, the elements remaining in the stack are the ones for which no next greater element exists in the nums2nums2 array. Thus, at the end of the iteration over nums2nums2, we pop the remaining elements from the stackstack and put their entries in hashhash with a \text{-1}-1 as their corresponding results.

Then, we can simply iterate over the nums1nums1 array to find the corresponding results from mapmap directly.

The following animation makes the method clear:

Current
1 / 22
Implementation


Complexity Analysis

Let nn and mm represent the length of the nums2nums2 and nums1nums1 array respectively.

Time complexity: O(n)O(n). The entire nums2nums2 array (of size nn) is scanned only once. Each of the stack's nn elements are pushed and popped exactly once. The nums1nums1 array is also scanned only once. All together this requires O(n + n + m)O(n+n+m) time. Since nums1nums1 must be a subset of nums2nums2, we know mm must be less than or equal to nn. Therefore, the time complexity can be simplified to O(n)O(n).

Space complexity: O(n)O(n). mapmap will store nn key-value pairs while stackstack will contain at most nn elements at any given time.

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
    
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
    
        while (!stack.empty())
            map.put(stack.pop(), -1);
    
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
                                            
        return res;
    }
}

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
