# Time complexity: O(n)
# Space complexity: O(n)

def decodeString(self, s: str) -> str:
    stack = []
    curNum = 0
    curString = ''
    for c in s:
        if c == '[':
            stack.append(curNum)
            stack.append(curString)
            curString = ''
            curNum = 0
        elif c == ']':
            prevString = stack.pop()
            prevNum = stack.pop()
            curString = prevString + prevNum*curString
        elif c.isdigit():
            curNum = curNum*10 + int(c)
        else:
            curString += c
    return curString
