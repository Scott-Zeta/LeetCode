Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
Example 2:

Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
Example 3:

Input: arr = [10,11,12]
Output: 66
 

Constraints:

1 <= arr.length <= 100
1 <= arr[i] <= 1000

My example:
what if arr = [8,1,4,2,5,3,9] length= 7?
[8] = 8
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[9] = 9
[8,1,4]
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[5,3,9]
[8,1,4,2,5]
[1,4,2,5,3] = 15
[4,2,5,3,9]
[8,1,4,2,5,3,9]

what if arr = [6,8,1,4,2,5,3,9,7] length= 9?
[6]
[8] = 8
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[9] = 9
[7]
[6,8,1]
[8,1,4]
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[5,3,9]
[3,9,7]
[6,8,1,4,2]
[8,1,4,2,5]
[1,4,2,5,3] = 15
[4,2,5,3,9]
[2,5,3,9,7]
[6,8,1,4,2,5,3]
[8,1,4,2,5,3,9]
[1,4,2,5,3,9,7]
[6,8,1,4,2,5,3,9,7]

Solution 1: Brute Force
Enumerate all possible odd length of subarray.
Time O(n^3)
Space O(1)

Solution 2: Consider the contribution of A[i]
Also suggested by @mayank12559 and @simtully.

Consider the subarray that contains A[i],
we can take 0,1,2..,i elements on the left,
from A[0] to A[i],
we have i + 1 choices.

we can take 0,1,2..,n-1-i elements on the right,
from A[i] to A[n-1],
we have n - i choices.

In total, there are k = (i + 1) * (n - i) subarrays, that contains A[i].
And there are (k + 1) / 2 subarrays with odd length, that contains A[i].
And there are k / 2 subarrays with even length, that contains A[i].

A[i] will be counted ((i + 1) * (n - i) + 1) / 2 times for our question.


Example of array [1,2,3,4,5]
1 2 3 4 5 subarray length 1
1 2 X X X subarray length 2
X 2 3 X X subarray length 2
X X 3 4 X subarray length 2
X X X 4 5 subarray length 2
1 2 3 X X subarray length 3
X 2 3 4 X subarray length 3
X X 3 4 5 subarray length 3
1 2 3 4 X subarray length 4
X 2 3 4 5 subarray length 4
1 2 3 4 5 subarray length 5

5 8 9 8 5 total times each index was added, k = (i + 1) * (n - i)
3 4 5 4 3 total times in odd length array with (k + 1) / 2
2 4 4 4 2 total times in even length array with k / 2s


Complexity
Time O(N)
Space O(1)


Java

    public int sumOddLengthSubarrays(int[] A) {
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            res += ((i + 1) * (n - i) + 1) / 2 * A[i];
        }
        return res;
    }

python

    def sumOddLengthSubarrays(self, A):
        n = len(A)
        res = 0
        for l in xrange(1, n + 1, 2):
            for i in xrange(n - l + 1):
                res += sum(A[i:i + l])
        return res

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
