Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]


Approach 1: Brute Force
Intuition
As we need the most frequent k words, to find which words are of higher frequencies, we just need to sort all words by their frequencies and return the first k words. Notice that the sorting order is first by frequencies then lexicographically.

Algorithm
According to the requirement in the problem, we

Count the frequency of each word and store the records by a HashMap cnt.
Define the sorting order as what the problem indicates (by frequencies from high to low, and then from lexicographically smaller ones to larger ones when we meet a tie in frequency) and sort the entire list of all words.
Only return the first k words as the returned result.
Implementation

Complexity Analysis
let NN be the length of words.

Time Complexity: O(N \log{N})O(NlogN). We count the frequency of each word in O(N)O(N) time, and then we sort the given words in O(N \log{N})O(NlogN) time.

Space Complexity: O(N)O(N), the space used to store frequencies in a HashMap and return a slice from a sorted list of length O(N)O(N).

Approach 2: Max Heap
Intuition
If we put all numbers into a max-heap, the top element of the heap must be the max value of all numbers in the heap. So instead of sorting all unique words, we only need to pop the word with the max frequency from a max heap k times.

Algorithm
Count the frequency of each word like Approach 1.
Heapify: make the list of words as a max heap h by their frequencies, in which the top element has the max frequency and lexicographically in all words with the same frequency.
Pop the top element from the max heap h totally k times, and then the words you get are already in the correct order.
Implementation

Complexity Analysis
Let NN be the length of words.

Time Complexity: O(N + k\log{N})O(N+klogN). We count the frequency of each word in O(N)O(N) time and then heapify the list of unique words in O(N)O(N) time. Each time we pop the top from the heap, it costs \log{N}logN time as the size of the heap is O(N)O(N).

Space Complexity: O(N)O(N), the space used to store our counter cnt and heap h.

Approach 3: Min Heap
Intuition
Approach 2 looks perfect when the given input is off-line, i.e., no new unique words will be added later. For those top-k elements problems that may have dynamically added elements, we often solve them by maintaining a min heap of size k to store the largest k elements so far. Every time we enumerate a new element, just compare it with the top of the min heap and check if it is one of the largest k elements.

Algorithm
It's almost the same idea with Approach 1 in solution to 347, except that:

We need to be careful with the order, considering not only the frequency but the word lexicographically.
The min heap doesn't guarantee the order. We need to sort the elements in the heap before returning them or just pop them one by one from the min-heap to our result in order.
Implementation

Complexity Analysis
Time Complexity: O(N\log{k})O(Nlogk), where NN is the length of words. We count the frequency of each word in O(N)O(N) time, then we add NN words to the heap, each in O(\log {k})O(logk) time. Finally, we pop from the heap up to kk times or just sort all elements in the heap as the returned result, which takes O(k\log{k})O(klogk). As k \le Nk≤N, O(N) + O(N\log{k}) + O(k\log{k}) = O(N\log{k})O(N)+O(Nlogk)+O(klogk)=O(Nlogk)

Space Complexity: O(N)O(N), O(N)O(N) space is used to store our counter cnt while O(k)O(k) space is for the heap.


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
