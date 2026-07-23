class Solution:
    def __init__(self):
        self.i = 0

    def decodeString(self, s: str) -> str:
        currNum = 0
        currStr = []

        while self.i < len(s):
            c = s[self.i]
            self.i += 1

            if c.isdigit():
                currNum = currNum * 10 + int(c)
            elif c == '[':
                baby = self.decodeString(s)
                for k in range(currNum):
                    currStr.extend(baby)
                currNum = 0
            elif c == ']':
                return ''.join(currStr)
            else:
                currStr.append(c)

        return ''.join(currStr)

# TC - O(n × k) where n = length of the string, k = maximum repeat count
# SC - O(n × k)