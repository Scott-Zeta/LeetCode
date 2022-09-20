Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.

Approach 2: Two-Pointers
Intuition

Following the same intuition above, we could further optimize the space complexity of the previous solutions, by replacing the recursion with the iteration.

More specifically, we iterate through the source and target strings, respectively with a pointer.

Each pointer marks a position that we progress on the matching of the characters.

Algorithm

We designate two pointers for iteration, with the left pointer referring to the source string and the right pointer to the target string.

two-pointers

We move the pointers accordingly on the following two cases:

If source[left] == target[right]: we found a match. Hence, we move both pointers one step forward.

If source[left] != target[right]: no match is found. We then move only the right pointer on the target string.

The iteration would terminate, when either of the pointers exceeds its boundary.

At the end of the iteration, the result solely depends on the fact that whether we have consumed all the characters in the source string. If so, we have found a suitable match for each character in the source string. Therefore, the source string is a subsequence of the target string.

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
