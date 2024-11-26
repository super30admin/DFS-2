# TC: O(n*k), k is the largest digit in s
# SC: O(n*k)

class Solution:
    def decodeString(self, s: str) -> str:
        currStr = ""
        currNum = 0
        numStack = []
        strStack = []
        digit = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}
        for char in s:
            if char in digit:
                currNum = 10 * currNum + int(char)
            elif char == '[':
                numStack.append(currNum)
                strStack.append(currStr)
                currNum = 0
                currStr = ""

            elif char == ']':
                num = numStack.pop()
                currStr = num * currStr
                currStr = strStack.pop() + currStr

            else:
                currStr += char

        return currStr
        
