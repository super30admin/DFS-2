class Solution:
    def decodeString(self, s: str) -> str:
        stack, curNum, curString = [], '0', ''
        for c in s:
            if c == '[':
                stack.append(curString)
                stack.append(int(curNum))
                curString = ''
                curNum = '0'
            elif c == ']':
                num = stack.pop()
                prevString = stack.pop()
                curString = prevString + num * curString
            elif c.isdigit():
                curNum += c
            else:
                curString += c
        return curString
