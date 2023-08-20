# Time Complexity : O(n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def decodeString(self, s: str) -> str:
        def helper(s):
            currStr = ''
            currNum = 0
            while self.i < len(s):
                if s[self.i].isdigit():
                    currNum = currNum * 10 + int(s[self.i])
                    self.i += 1
                
                elif s[self.i] == '[':
                    self.i += 1
                    decodedStr = helper(s)
                    currStr += decodedStr * currNum
                    currNum = 0
                
                elif s[self.i] == ']':
                    self.i += 1
                    return currStr

                else:
                    currStr += s[self.i]
                    self.i += 1
            
            return currStr
        
        self.i = 0
        return helper(s)
