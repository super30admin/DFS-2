# Decode String
 
# Time Complexity : O(maxK⋅n)
# Space Complexity :  
# Did this code successfully run on Leetcode : Yes with Runtime: 32 ms and Memory Usage: 14.3 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using Recursive approach in which Stack is maintained and numbers are stored in 
stack and characters too  . While checking for all the characters in string
If '[' is encountered than a number is pushed in stack and And if ']' is 
encountered than we pop elements out of stack. and the current String is appended.

"""
class Solution:
    def decodeString(self, s: str) -> str:
        """
        :type s: str
        :rtype: str
        """
        curStr='' # Initializing Empty Current String 
        num = 0 # Initializing Number to 0
        stack =[] # Empty Stack
        for c in s:
            if c.isdigit():
                num=num*10+int(c)
            elif c=='[':
                stack.append(num) # Pushing num to stack
                stack.append(curStr) # Pushing character to Stack
                num, curStr=0,''
            elif c==']':
                preStr = stack.pop() 
                preNum = stack.pop()
                curStr=preStr+preNum*curStr
            else:
                curStr+=c
        return curStr 