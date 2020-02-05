"""
Time Complexity : decodeString() - O(n)
Space Complexity : decodeString() - O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : I had a hard time figuring out when to push the values/strings onto the stack
"""

class Solution:
    def decodeString(self, s: str) -> str:
        if not s or len(s) == 0:
            return ""
        
        numStack = []
        strStack = []
        currNum = ""
        currStr = ""
        
        for i in range(len(s)):
            if s[i].isdigit():
                currNum += s[i]
                
            elif s[i] == "[":
                numStack.append(int(currNum))
                strStack.append(currStr)
                currStr = ""
                currNum = ""
                
            elif s[i] == "]":
                newStr = numStack.pop() * currStr
                currStr = strStack.pop() + newStr
            
            else:
                currStr += s[i]
            
        return currStr
    
s = Solution()
print(s.decodeString("3[a]2[bc]"))