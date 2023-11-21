# Time Complexity: O(function of Multiplier and characters of S)
# Space Complexity: O(1) ~ amortized


from collections import deque
class Solution:
    def decodeString(self, s: str) -> str:
        currNum = 0
        currStr = ''
        numStack = deque()
        charStack = deque()
        for c in s:
            if c == '[':
                charStack.append(currStr)
                numStack.append(currNum)
                currStr = ''
                currNum = 0

            elif c == ']':
                multiplier = numStack.pop()
                temp = ''
                for i in range(multiplier):
                    temp += currStr
                
                currStr = charStack.pop()
                currStr += temp
                temp = ''
            
            elif c.isdigit():
                currNum = currNum * 10 + int(c)
            
            else:
                currStr += c

        return currStr

