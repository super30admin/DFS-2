# DFS-2

## Problem1 (https://leetcode.com/problems/number-of-islands/)

In this solution we will count the number of islands in the grid. We will use BFS approach where when 1 is encountered we will mark it 0 as visited and all neighbouring cells we will explore using BFS. Whenever we will encounter 1s again we will increment count and then BFS ensures that all land in the same island is visited. We can use DFS for the same as well.



## Problem2 (https://leetcode.com/problems/decode-string/)

In this solution we will decode a string that contains pattern. We will use two stack - one to store the string that we are building and another to store the current repeat count. As we will be traversing the string we will accumulate digits into currNum. When we will encounter '[' both current string and number we will push then to their respective stacks. When we will encounter ']' then we will pop stored number to repeat the string and append it back to the previous string. We will continue this process until entire string is traversed. We can perform same operations using recursive stack DFS algorithm as well.


