# Using Stacks
# Time complexity - O(n * k) where k is the maximum occurence of a subtring
# Space complexity - O(n)
# Did this solution run on leetcode? - yes
class Solution:
    def decodeString(self, s: str) -> str:
        currStr, currNo = "", 0
        numStack = []
        charStack = []
        
        for ch in s:
            if ch.isnumeric():  # if the current character is numeric.
                currNo = currNo * 10 + int(ch)
            elif ch == "[":     # if the current character is an opening bracket.
                numStack.append(currNo)
                charStack.append(currStr)
                currStr, currNo = "", 0
            elif ch == "]":     # if the current character is a closing bracket.
                prevStr, times = charStack.pop(), numStack.pop()
                currStr = prevStr + times * currStr
            else:
                currStr += ch
        
        return currStr
                
        
# Recursive Stacks
# Time complexity - O(n * k) where k is the maximum occurence of a subtring
# Space complexity - O(n)
# Did this solution run on leetcode? - yes
class Solution:
    def decodeString(self, s: str) -> str:
        self.idx = 0
        return self.recursive(s)
        
        
    def recursive(self, s):
        result = ""
        currNo = 0
        while self.idx < len(s):
            # if the current character is numeric
            if s[self.idx].isnumeric():
                currNo = currNo * 10 + int(s[self.idx])
                self.idx += 1
            elif s[self.idx] == "[":
                self.idx += 1
                inner = self.recursive(s)
                result += currNo * inner
                currNo = 0
            elif s[self.idx] == "]":
                self.idx += 1
                # inner decoding has completed.
                return result 
            else:
                result += s[self.idx]
                self.idx += 1
        return result
            