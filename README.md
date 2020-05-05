# CrackingInterview

Solutions of tasks from "Cracking the coding interview" book and some basic algorithms

# Build and run:

All examples are ran in unit tests.
```yaml
 mvn clean install
```

# Tasks

## Strings

- isUnique - Determine if all the characters in string are unique
- checkPermutation - Check if str2 is permutation of str1
- urlify - Replace spaces with %20 except spaces at the end replace within char array
- palindromePermutation - Check if any of words permutations can be a palindrome
- oneAway - Check of oneString can be got from another by just one edit
- stringCompressor - Compress repeated chars in string(e.g: aabcccccaaa -> a2b1c5a3)
- reverseString - In place string reverse
- isStringPalindrome - Is string a palindrome
- longestCommonPrefix - Find the longest common prefix string amongst an array of strings.
All given inputs are in lowercase letters a-z.

## Ints

- reverse integer - Given a 32-bit signed integer, reverse digits of an integer.
- isIntegerPalindrome - Is integer a palindrome
- romanToInt - Transform roman number to decimal integer
## Arrays

- twoSum - Given an array of integers, return indices of the two numbers such that they add up to a specific target.
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
- bin to str - Given real number between 0 and 1 convert it to bin and save as str.Max 32 chars.
- conversion - Given two numbers determine how many bits are needed to convert one to another
- pairwise swap - Swap odd and even bits in 32-bit int
- flip bit to win - Find the longest sequence of 1 ny flipping only one 0  to 1
- next number - Find the next biggest and smallest numbers with the same number of 1 bits
- draw line - Draw a line on the screen of width divisible by 8

## Dynamic programming

- count ways - child runs staircase with n steps with hops of 1 ,2 or 3 steps. How many possible ways can he run?
- magic index - find an element in a sorted int array A where A[i] = i
- power set - return all subsets of a set
- recursive mult - write a func to mult two ints without *
- hanoi towers - popular hanoi towers task (one disk moved at a time,disk slid from top of one tower to another,disk 
can"t be on top of a smaller one,disks sorted in ascending order)
- paint fill - fill the area arount selected point on the screen with color(contains bug)
- max permutations(no dups) - find max number of char permutaions in a string of unique chars
- max permutations(dups) - find max number of unique char permutaions in a string with dup chars
- parentheses - print all valid combinations of n pairs of parentheses
- coins - given coins of 25,10,5 and 1 cents calc a number of ways to represent n cents
- stack of boxes - given stack of n boxes with dimenstions w1,h1,d1. The boxes can't be rotated. 
the largest boxes are at the bottom of the stack. find the height of max possible stack as sum of heights of all boxes in it.
- boolean equation - given bool expression with 0,1,or,xor,and + desired result , 
find number of ways to parentesizing expression that it will evaluate result 

## Sorting tasks

These tasks use algorithms from Sorting section below

- sortedMerge - given two sorted arrays A and B merge them in sorted order.
- groupAnagrams - sort an array of strings so that all annagrams are next to each other
- rotated search - find an element in sorted in inc order array which has been rotated
- sorted search - given a ds called listy(list without size method) with positive sorted ints 
find and index where element occurs
- sparse search - given a sorted array of strings interpressed with empty strs write a method to find a location of string
- find dups - in array with numbers from 1 to N (N <=32000) find duplicate entries having 4kb of memory
- sortedMatrixSearch - given matrix m x n with sorted in asc order rows and cols find an element
- rank from stream - reading stream of ints it's needed to check a rank of number x(the number of vals <= x)
- peaks and valleys - sort an array in alternating seq of peaks(elem>=adjacent elems) and valleys(elem<=adjacent)


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
