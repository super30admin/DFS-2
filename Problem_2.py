"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
I have done the iterative solution as of now. Here, we need to iterate over the string and we can have 4 cases,
ie, we can get a number, or a char, or a [ or a ]. If we get a char, just append the current string. If get a 
number, just calculate the number. If get a [, then we need to abandon the parent, ie, put number in stack, 
string in stack and reinitialise them. when we find a ], we start unwrapping. Then we pop out number
from stack, multiply currstr that many times, pop out parent str from stack, append with currstr and repeat
the process. 
"""


class Solution:
    def decodeString(self, s: str) -> str:
        currstr = ""
        num = 0
        numstack = []
        strstack = []
        for c in s:
            if c.isdigit():
                num = num*10 + ord(c) - ord('0')
            elif c == '[':
                numstack.append(num)
                strstack.append(currstr)
                num = 0
                currstr = ""
            elif c == ']':
                times = numstack.pop()
                new = times*currstr
                currstr = strstack.pop()+new
            else:
                currstr += c
        return currstr
