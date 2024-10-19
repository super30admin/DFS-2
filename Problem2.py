# 394. Decode String
class Solution:
    def decodeString(self, s: str) -> str:
        currNum = 0
        currStr = ''
        stack = []
        i = 0

        while i < len(s):
            c = s[i]
            i += 1
            if c.isdigit():
                currNum = currNum * 10 + int(c)
            elif c == '[':
                # Push the current string and number onto the stack
                stack.append((currNum,currStr))
                # Reset current string and number
                currNum = 0
                currStr = ''
            elif c == ']':
                # Pop the last string and number from the stack
                lastNum,lastStr = stack.pop()
                # Repeat the current string num times and append to the last string
                currStr = lastStr + (currStr*lastNum)
            else:
                currStr += c
        return currStr



        