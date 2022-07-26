## Problem2 (https://leetcode.com/problems/decode-string/)

# Time Complexity: O(n)
# Space Complexity: Number of nested opening brackets
# Solved on Leetcode?:Yes
# Code:

class Solution:
    def decodeString(self, s: str) -> str:
        
        nums_stack = []
        char_stack = []
        num = 0
        initial_str = ""
        for value in s:
            if value.isdigit() == True:
                num = num * 10 + (ord(value) - ord('0'))         
            elif (value == '['):
                nums_stack.append(num)
                char_stack.append(initial_str)
                num = 0
                initial_str = ""
            elif value == ']':
                number = nums_stack.pop()
                cumulative_str = ""
                for i in range(number):
                    cumulative_str = cumulative_str + initial_str
                initial_str = char_stack.pop() + cumulative_str
            else:
                initial_str = initial_str + value
                
        return initial_str

# Approach: In this problem, we create 2 stack spaces, one for storing numbers and other for storing characters. Whenever we encounter a opening bracket ('['), 
#           we push the number and the string into the stack and then again initialize the number and string to null. 
#           When we encounter a closing bracket (']'), we first pop number from the stack and append n times to the current string. 
#           Once done, we pop the string from character array and append it to the cumulative string.