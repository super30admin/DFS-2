'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 394. Decode String

# Given an encoded string, return its decoded string.

# The encoding rule is: k[encoded_string], where the encoded_string inside 
# the square brackets is being repeated exactly k times. Note that k is guaranteed 
# to be a positive integer.

# You may assume that the input string is always valid; No extra white spaces, 
# square brackets are well-formed, etc.

# Furthermore, you may assume that the original data does not contain any digits 
# and that digits are only for those repeat numbers, k. For example, there won't be 
# input like 3a or 2[4].



#-----------------
# Time Complexity: 
#-----------------
# O(maxK, n) - Max iterations per string = maxK
#------------------
# Space Complexity: 
#------------------
# O(m + n): m is number of letters (a-z) and n is number of digits (0-9) in string
#           s

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def decodeString(self, s: str) -> str:
        if len(s) == 0:
            return s
        num = 0
        curr_str = ""
        num_stack = []
        str_stack = []
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num * 10 + ord(c) - ord('0')
            elif c == "[":
                num_stack.append(num)
                str_stack.append(curr_str)
                num = 0 
                curr_str = ""
            elif c == "]":
                times = num_stack.pop()
                new_str = ""
                for k in range(times):
                    new_str += curr_str
                parent = str_stack.pop()
                curr_str = parent + new_str
            else:
                curr_str += c
            
        return curr_str