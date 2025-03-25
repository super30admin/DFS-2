'''
    Time Complexity: O(n)
    Space Complexity: O(n)
'''
class Solution:
    def decodeString(self, s: str) -> str:
        currNum = 0
        currStr = ""
        numStack = []
        strStack = []

        for char in s:
            if char.isdigit():
                currNum = currNum*10 + int(char)
            elif char.isalpha():
                currStr += char
            elif char == "[":
                numStack.append(currNum)
                strStack.append(currStr)
                currNum = 0
                currStr = ""
            elif char == "]":
                poppedNum = numStack.pop()
                poppedStr = strStack.pop()
                currStr = poppedStr + poppedNum*currStr

        return currStr