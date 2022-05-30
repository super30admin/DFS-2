# Time Complexity : O(OUTPUT)
# Space Complexity : O(NESTING in the INPUT)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.i = 0
    def decodeString(self, s: str) -> str:
        if len(s) == 0: return ""
        num = 0
        currStr = []
        
        while self.i < len(s):
            if s[self.i].isdigit():
                num = num * 10 + int(s[self.i])
                self.i += 1
            elif s[self.i] == "[":
                self.i += 1
                decoded = self.decodeString(s)
                tempStr = decoded *  num
                currStr.extend(tempStr)
                num = 0
            elif s[self.i] == "]":
                self.i += 1
                return currStr

            elif s[self.i].isalpha():
                currStr.append(s[self.i])
                self.i += 1
                
        return "".join(currStr)