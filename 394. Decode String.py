class Solution:
    '''
    - use two stack: one to store digit
    - another to store strings
    - push and pop based on [ or ] and accordinly build new string
    '''
    def decodeString(self, s: str) -> str:
        numStack = []
        strStack = []
        currStr = ""
        currNum = '0'
        for val in s:
            if val.isdigit():
                currNum = currNum + val
            if val.isalpha():
                currStr = currStr + val
            if val == '[':
                numStack.append(currNum)
                strStack.append(currStr)
                currStr = ""
                currNum = '0'
            if val == ']':
                times = int(numStack.pop())
                prevStr = strStack.pop()
                currStr = prevStr + (times * currStr)
        return currStr