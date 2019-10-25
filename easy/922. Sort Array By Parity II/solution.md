
#Problem 922. Sort Array By Parity II 

link: https://leetcode.com/problems/sort-array-by-parity-ii/

##Solution 1: Trivial approach: 

1. Create two array: **odd** and **even**. each array stores all odd/even entries of the original array, respectively.
2. Fill all entries of the **odd** array in the odd indexes of the original array. Do the same for **even** array.
3. All done!

*Complexity: O(N) time, O(N) space*
 
##Solution 2: A little improvement

1. Create a **temp** array, same size with the original array.
2. Loop i through the original array, if A[i] is odd, put it to an odd index of **temp**, otherwise, put it to an even index of **temp** 
3. Copy **temp** to the original array.

*Complexity: O(N) time, O(N) space*

##Solution 3: in-place algorithm:

Create two variable: 

1. **endOdd** indicate the first odd index whose entry is not odd
2. **endEven** indicate the first even index whose entry is not even

*Invarient:*

1. All entries to the left of endOdd, whose index is odd, must be odd.
2. All entries to the left of endEven, whose index is even, must be even.

*To maintain the invarient:*

1. find the endOdd and endEven
2. swap the values at endOdd and endEven
3. repeat (1) & (2) until you cannot find the endOdd and endEven.

*Complexity: O(N) time, O(1) space*
