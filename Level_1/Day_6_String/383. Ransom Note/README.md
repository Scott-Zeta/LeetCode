Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.

Solution
Something you might notice when you run code for this problem here on Leetcode is that Approach 1 passes, and is the fastest. This is because all the testcases are very small. For huge test cases though, the other approaches would beat it, and Approach 1 would be far too slow.

In an interview, it's unlikely that Approach 1 would be sufficient to get you the job. Interviewers will expect to see an optimized approach such as Approach 2 or 3.


Approach 1: Simulation
Intuition

To create our ransom note, for every character we have in the note, we need to take a copy of that character out of the magazine so that it can go into the note.

If a character we need isn't in the magazine, then we should stop and return False. Otherwise, if we manage to get all the characters we need to complete the note, then we should return True.

For each char in ransomNote:
    Find that letter in magazine.
    If it is in magazine:
        Remove it from magazine.
    Else:
        Return False
Return True
Note that there's no need to explicitly build up the ransom note; we only need to return whether or not it's possible. This can be determined simply by removing the characters we need from the magazine.

This is the most straightforward approach, but as we'll see soon, although it does pass here on Leetcode, it's not very efficient and is not likely to get you a job at a top company.

Algorithm

Strings are an immutable type. This means that they can't be modified, and so don't have "insert" and "delete" operations. For this reason, we instead need to repeatedly replace the magazine with a new String, that doesn't have the character we wanted to remove.


Complexity Analysis

We'll say mm is the length of the magazine, and nn is the length of the ransom note.

Time Complexity : O(m \cdot n)O(m⋅n).

Finding the letter we need in the magazine has a cost of O(m)O(m). This is because we need to perform a linear search of the magazine. Removing the letter we need from the magazine is also O(m)O(m). This is because we need to make a new string to represent it. O(m) + O(m) = O(2 \cdot m) = O(m)O(m)+O(m)=O(2⋅m)=O(m) because we drop constants in big-o analysis.

So, how many times are we performing this O(m)O(m) operation? Well, we are looping through each of the nn characters in the ransom note and performing it once for each letter. This is a total of nn times, and so we get n \cdot O(m) = O(m \cdot n)n⋅O(m)=O(m⋅n).

Space Complexity : O(m)O(m).

Creating a new magazine with one letter less requires auxillary space the length of the magazine; O(m)O(m).


Approach 2: Two HashMaps
Intuition

Remember that we decided the length of the ransom note is nn, and the length of the magazine is mm.

In an interview, you might start by describing the previous approach and determining its time complexity, but not actually implementing it. Your next goal would be to reason carefully about the implementation and its time complexity, to identify parts that could be made more efficient.

Removing the nn factor from the time complexity is going to be impossible, because we need to at least look at each character in the ransom note. Otherwise, how could we possibly know whether or not we have the characters we need to make it? We might be able to avoid the need for an O(m)O(m) operation for every one of the nn characters in the ransom note though.

As an example, notice that if there's three 'a''s in the ransom note, then there needs to be at least three 'a's in the magazine. This should be fairly intuitive, as you'd encounter it if trying to make a note out of a magazine for real. The same idea applies for all the other unique characters too.

Therefore, a better way of solving the problem would be to count up how many of each letter are in both the magazine and the ransom note. We can represent the counts with a HashMap that has characters as keys, and counts as values. For example, the string "leetcode is cool" is represented as follows.

The counts

We can make two HashMaps; one for the magazine, and the other for the ransom note. Here is the pseudocode for making one of these "counts" HashMaps.

define function makeCountsMap(string):
    counts = a new HashMap
    for each char in string:
        if char not in counts:
            counts.put(char, 1)
        else:
            old_count = counts.get(char)
            counts.put(char, old_count + 1)
    return counts
Then, to actually check whether or not the ransom note can be made using the magazine, we should loop over each character of the ransom note, checking how many of it we need, and checking that at least that many exist in the magazine, by looking it up in the magazine HashMap. We need to be careful of the case where the character we need isn't in the magazine at all; in this case we should return False as the number of them in the magazine is definitely smaller than the number we need. If we manage to check all the characters without False being returned, then we know that we must have had enough characters to complete the note, and can therefore return True. Here is some pseudocode for that algorithm.

noteCounts = makeCountsMap(ransomNote)
magazineCounts = makeCountsMap(magazine)
for each (char, count) in noteCounts:
    if char is not in magazineCounts:
        return False
    countInMagazine = magazineCounts.get(char)
    if countInMagazine < count:
        return False
return True
Here is an animation showing the above algorithm in action with the ransom note "leetcode is cool" and the magazine "close call as fools take sides".

Current
1 / 9
And here is another example, with the same ransom note, but the magazine "cats close in on the fish".

Current
1 / 6
There's one more optimization we can make. Notice that if the length of the ransom note is longer than the length of the magazine, then its impossible for there to be enough characters in the magazine.

Algorithm


Complexity Analysis

We'll say mm is the length of the magazine, and nn is the length of the ransom note.

Also, let kk be the number of unique characters across both the ransom note and magazine. While this is never more than 2626, we'll treat it as a variable for a more accurate complexity analysis.

The basic HashMap operations, get(...) and put(...), are O(1)O(1) time complexity.

Time Complexity : O(m)O(m).

When m < nm<n, we immediately return false. Therefore, the worst case occurs when m ≥ nm≥n.

Creating a HashMap of counts for the magazine is O(m)O(m), as each insertion/ count update is is O(1)O(1), and is done for each of the mm characters.

Likewise, creating the HashMap of counts for the ransom note is O(n)O(n).

We then iterate over the ransom note HashMap, which contains at most nn unique values, looking up their counterparts in the magazine `HashMap. This is, therefore, at worst O(n)O(n).

This gives us O(n) + O(n) + O(m)O(n)+O(n)+O(m). Now, remember how we said m ≥ nm≥n? This means that we can simplify it to O(m) + O(m) + O(m) = 3 \cdot O(m) = O(m)O(m)+O(m)+O(m)=3⋅O(m)=O(m), dropping the constant of 33.

Space Complexity : O(k)O(k) / O(1)O(1).

We build two HashMaps of counts; each with up to kk characters in them. This means that they take up O(k)O(k) space.

For this problem, because kk is never more than 2626, which is a constant, it'd be reasonable to say that this algorithm requires O(1)O(1) space.


Approach 3: One HashMap
Intuition

In the previous approach, we used two HashMaps. You might have noticed a slightly better way though; we can simply put the magazine into a HashMap, and then subtract characters from the ransom note from it. Here is the pseudocode, using our makeCountsMap(...) function from above.

magazineCounts = makeCountsMap(magazine)
for each char in ransomNote:
    countInMagazine = magazineCounts.get(char)
    if countInMagazine == 0:
        return False
    magazineCounts.put(char, countInMagazine - 1)
return True
Here is an animation of the algorithm on our "true" case from before.

Current
1 / 29
And here's one on the "false" case.

Current
1 / 15
Algorithm


Complexity Analysis

We'll say mm is the length of the magazine, and nn is the length of the ransom note.

Also, let kk be the number of unique characters across both the ransom note and magazine. While this is never more than 2626, we'll treat it as a variable for a more accurate complexity analysis.

The basic HashMap operations, get(...) and put(...), are O(1)O(1) time complexity.

Time Complexity : O(m)O(m).

When m < nm<n, we immediately return false. Therefore, the worst case occurs when m ≥ nm≥n.

Creating a HashMap of counts for the magazine is O(m)O(m), as each insertion/ count update is is O(1)O(1), and is done for each of the mm characters.

We then iterate over the ransom note, performing an O(1)O(1) operation for each character in it. This has a cost of O(n)O(n).

Becuase we know that m ≥ nm≥n, again this simplifies to O(m)O(m).

Space Complexity : O(k)O(k) / O(1)O(1).

Same as above.

For this problem, because kk is never more than 2626, which is a constant, it'd be reasonable to say that this algorithm requires O(1)O(1) space.


Approach 4: Sorting and Stacks
Intuition

This approach isn't needed for an interview, and is better than Approach 1, but worse than Approach 2 and 3. I've included it because it's still very cool and might give you additional creative ideas for when tackling related problems! :)

Another, completely different, way of solving the problem is to start by converting each string into an Array of characters, and then reverse sorting them by alphabetical order. It's not actually necessary to reverse sort, but it will make things easier for the rest of the algorithm. For example, here's the sorted characters for the ransom note leetcode is cool and the magazine close call as fools take sides.

Strings reverse sorted as lists

Now, convert each array into a stack.

Compare the tops of the stacks. There are three possibilities.

The characters are the same.
The ransom note character is earlier in the alphabet than the magazine character.
The ransom note character is later in the alphabet than the magazine character.
For the first possibility, we've found a copy of the letter we need in the magazine, for a letter in our ransom note. So pop the top off each stack.

For the second possibility, we know that the letter we need can't be on the magazine stack. This is because all the other characters on the magazine must be even later than the top, and we needed an earlier letter. Therefore, we can return false now.

For the third possibility, we know that the letter on the top of the magazine stack will never be needed, as all the characters on the ransom note stack must be later than it, so we pop the top off just the magazine stack.

Here is an animation of the algorithm on our "true" case from before.

Current
1 / 51
And here's one on the "false" case.

Current
1 / 13
Algorithm


Complexity Analysis

We'll say mm is the length of the magazine, and nn is the length of the ransom note.

Time Complexity : O(m \, \log \, m)O(mlogm).

When m < nm<n, we immediately return false. Therefore, the worst case occurs when m ≥ nm≥n.

Sorting the magazine is O(m \, \log \, m)O(mlogm). Inserting the contents into the stack is O(m)O(m), which is insignificant. This, therefore, gives us O(m \, \log \, m)O(mlogm) for creating the magazine stack.

Likewise, creating the ransom note stack is O(n \, \log \, n)O(nlogn).

In total, the stacks contain n + mn+m characters. For each iteration of the loop, we are either immediately returning false, or removing at least one character from the stacks. This means that the stack processing loop has to use at most O(n + m)O(n+m) time.

This gives us O(m \, \log \, m) + O(n \, \log \, n) + O(n + m)O(mlogm)+O(nlogn)+O(n+m). Now, remembering that m ≥ nm≥n it simplifies down to O(m \, \log \, m) + O(m \, \log \, m) + O(m + m) = 2 \cdot O(m \, \log \, m) + O(2 \cdot m) = O(m \, \log \, m)O(mlogm)+O(mlogm)+O(m+m)=2⋅O(mlogm)+O(2⋅m)=O(mlogm).

Space Complexity : O(m)O(m).

The magazine stack requires O(m)O(m) space, and the ransom note stack requires O(n)O(n) space. Because m ≥ nm≥n, this simplifies down to O(m)O(m).



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
