# Time Complexity : O(kn) for n characters repeated k times on average
# Space Complexity : O(n) for stack space
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Yes, took a lot of time to get it right
# Your code here along with comments explaining your approach

# use a physical stack for string and number
# if char is number, multiply current num by 10 and add current char's int or ascii value, 
# if char is '[', then push the current number and string to stack and reset num and string
# if char is ']', then pop from stack and append to parent
# else add char to string stack
# in the end, return top of stack


from collections import deque
class Solution:
    def decodeString(self, s: str) -> str:
        
        strSt = ['']
        numSt = []
        num = 0
        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)
            elif c == '[':
                numSt.append(num)
                num = 0
                strSt.append('')
            elif c == ']':
                curr_str = strSt.pop()
                curr_num = numSt.pop()
                strSt[-1] += curr_str * curr_num
            else:
                strSt[-1] += c
        
        return strSt.pop()