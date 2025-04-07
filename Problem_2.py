"""
Problem2 (https://leetcode.com/problems/decode-string/)
"""

class Solution:
    """
    TC: O(m*n)  where m is the digits multiplied by the char n
    SC: O(n)
    """
    def decode(self, num, currStr, parentChar):
        if num ==0 or currStr == " ": return " "
        
        s = parentChar + (num * currStr)
        return s
    
    def decodeString(self, s: str) -> str:
        if s == " ": return " "
        currNum = 0
        currStr = ""
        charStack = collections.deque() # use append and pop() method
        numsStack = collections.deque()
        for char in s:
            if char.isdigit():
                currNum = 10 * currNum + int(char)
                
            else:
                if char == "[":
                    numsStack.append(currNum)
                    charStack.append(currStr)
                    currNum = 0
                    currStr = ""
                
                elif char =="]":
                    num = numsStack.pop()
                    parentChar = charStack.pop()
                    currStr = self.decode(num, currStr, parentChar)
                
                else:
                    currStr += "".join(char)
                    
                    
        return currStr
                
                
        