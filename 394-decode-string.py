
"""
394. Decode String
Medium
"""
from collections import deque
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.
 
Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

 
Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].


"""

class Solution:
    """
    Accepted
    Time Complexity: O(n) - We iterate the string once
    Space Complexity: O(n) - We use a stack to store the strings and numbers
    
    Approach:
    - Use a stack to store the strings and numbers
    - Iterate the string and put everything in the stack untill a closing bracket is found
    - When a closing bracket is found, take out the string and the number and generate the string
    - Put the string back in the stack
    - in the end Iterate the stack and combine the strings and return
    
    TODO: Can be done using recursion as well
    
    """
    def decodeString(self, s: str) -> str:
        stk = deque()
        for ch in s:
            if not ch == ']': # put everythiog in stack untill a closing bracket is found
                stk.append(ch)
            else:
                st = ""
                while stk[-1] is not '[': # take out the string
                    st = stk.pop() + (st)
                stk.pop() # remove the opening bracket
                number_str = ''
                while len(stk) >0  and stk[-1].isdigit(): # take out the number
                    number_str = stk.pop() + number_str
                num = int(number_str)
                st = num * st # generate the string
                stk.append(st) # put back the string in the stack
        res = ''
        while len(stk) > 0: # iterate the stack and combine
            res = stk.pop() + res
        return res

LeetCode(PROBLEM, Solution).check()
