# CrackingInterview

Solutions of tasks from "Cracking the coding interview" book and some basic algorithms

# Build and run:

All examples are ran in unit tests.
```yaml
 mvn clean install
```

# Tasks

## Arrays and Strings

- isUnique - Determine if all the characters in string are unique
- checkPermutation - Check if str2 is permutation of str1
- urlify - Replace spaces with %20 except spaces at the end replace within char array
- palindromePermutation - Check if any of words permutations can be a palindrome
- oneAway - Check of oneString can be got from another by just one edit
- stringCompressor - Compress repeated chars in string(e.g: aabcccccaaa -> a2b1c5a3)
- rotateMatrix - Rotate matrix by 90 degrees clockwise
- zeroMatrix - If element [i][j] of matrix is zero - entire row and column must be zero
If element [i][j] of matrix is zero - entire row and column must be zero

##  List

- removeDups - Remove duplicates from list without using any tmp buffer
- kToLast - Return  k elements from last element in list
- deleteMiddleNode - Delete any node but not first or last (we don't have access to the first so we don't check for first)
- sumListsReverse - Each param is a number in reverse : list 7-1-6 is number 617.
We need to return a list which represents sum of values
- sumListsStraight - Each param is a number  : list 7-1-6 is number 716.
 We need to return a list which represents sum of values
- checkPalindrome - Check if list is a palindrome
- hasIntersection - Check if two list have an intersection.Intersection is by ref, not by val which means one node in two lists 
- detectLoop - Check if list has loops and return it.

## StacksQueues

Check comments in classes

## Trees Graphs

- hasRouteBFS,hasRouteDFS - Check if a graph has route between two nodes.
- minTree - Build a tree with min height from sorted array
- listOfDepth - Get list of lists of nodes on every depth of the tree
- isBalanced - Check if bin tree is balanced(e.g heights of subtrees of any node don't differ more than by one)
- isBST - Check if binary tree is BST
- buildOrder - By given list of dependencies build a list of build order
- findCommonAncestor - Find first common ancestor of two given nodes without storing additional nodes in ds.
- bstSequences - Find all possible arrays of nodes in BST with distinct elems

## Bit opertations

- insert - Insert 32-bit number m into number n from position j to position i. M fully fits between positions 

# Algorithms

## Sorting

- Insertion sort. Best,Avg: O(n), Worst: O(n^2) 
- Heap sort. Best,Avg,Worst: O(nlog n) 
- Quick sort. Best,Avg: O(n log n), Worst: O(n^2) 
- Merge sort. Best,Avg,Worst: O(n log n) 

## Search
- Sequential search. Best: O(1), Avg,Worst: O(n)
- Binary search. Best: O(1), Avg,Worst: O(log n)
- Hash search. Best,Avg: O(1), Worst: O(n)

## Graph Algorithms
- Dijkstra algorithm for shortest path. Best,Avg,Worst: O((V+E)*log V)