# Time Complexity: O(n*k) #length of string times the total count
# Space Complexity: O(n*k)
class Solution:
    def __init__(self):
        self.i = 0

    def decodeString(self, s: str) -> str:
        currNum = 0
        currStr = []

        while self.i < len(s):
            ch = s[self.i]
            self.i += 1
            if ch.isdigit():
                currNum = currNum * 10 + int(ch)
            elif ch == '[':
                substr = self.decodeString(s)
                for j in range(currNum):
                    currStr.extend(substr)
                currNum = 0
            elif ch == ']':
                return ''.join(currStr)
            else:
                currStr.append(ch)
        return ''.join(currStr)