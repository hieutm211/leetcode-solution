
# Problem 1160. Find Words That Can Be Formed by Characters

link: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

# Solution 1 - Trivial Solution

To check whether a word is *good*:

For each character of word, find the index of it in **char** (which was not marked) then mark it. 
If there is a character which cannot be marked (the index cannot be found in **chars**), then this word is not *good*.
otherwise, this word can be formed by characters from the given **char**.

Let T = number of words, N = word.length, M = chars.length

Complexity for a check: O(N*M) time, O(M) space.
Total: **O(T*N*M) time, O(M) space**

# Solution 2 - Distributed count

Let count[c] = amount of char 'c' in the given **chars** string.
Let count2[c] = amount of char 'c' in a **word**.

Firstly, calculate the *count* array.

For each word, calculate *count2* array for it, then compare *count2* array to *count* array. If all chars have *count2 < count* then this word is good. Otherwise, cannot form the word by the given **chars**

Let S = number of all possible characters.

Complexity for a check: O(N) time, O(S) space.
Total: **O(T*N) time, O(S) space**.

