# // Time Complexity :  O(kn)
# // Space Complexity :  O(kn)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class Solution:
    def decodeString(self, s: str) -> str:
        if s == None or len(s) == 0: return s
        currNum, currStr = 0, ""
        numStack, strStack = [], []
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                currNum = currNum *10 + int(c)
            elif c == '[':
                numStack.append(currNum)
                strStack.append(currStr)
                currNum, currStr = 0, ""
            elif c == ']':
                times = numStack.pop()
                newStr = times*currStr
                currStr = strStack.pop() + newStr
            else:
                currStr += c
        return currStr