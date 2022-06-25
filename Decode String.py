""""// Time Complexity : 0(n) -- total length of output
// Space Complexity : 0(n) -- max depth of nestings
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

#Iterative
class Solution:
    def decodeString(self, s: str) -> str:
        strSt = []
        numSt = []
        currStr = ''
        num = 0
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            elif s[i] == '[':
                strSt.append(currStr)
                numSt.append(num)
                currStr = ''
                num = 0
            elif s[i] == ']':
                temp_num = numSt.pop()
                if temp_num > 0:
                    currStr = currStr * temp_num
                temp_str = strSt.pop()
                currStr = temp_str + currStr
            elif type(s[i]) == str:
                currStr = currStr + s[i]

        return currStr


#Recursion
""""// Time Complexity : 0(n)
// Space Complexity : 0(h)-Recursive Stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def __init__(self):
        self.i = 0

    def decodeString(self, s: str) -> str:
        currStr = ''
        num = 0
        while self.i < len(s):
            if s[self.i].isdigit():
                num = num * 10 + int(s[self.i])
                self.i += 1
            elif s[self.i] == '[':
                self.i += 1
                decoded = self.decodeString(s)
                currStr = currStr + (decoded * num)
                num = 0
            elif s[self.i] == ']':
                self.i += 1
                return currStr
            elif type(s[self.i]) == str:
                currStr = currStr + s[self.i]
                self.i += 1

        return currStr