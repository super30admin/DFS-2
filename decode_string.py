# Time Complexity: O(nk) where n is the len of string and k is the largest number in the string
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:
    def __init__(self):
        self.i = 0
    def decodeString(self, s: str) -> str:
        if not len(s):
            return ""
        cur = []
        num = 0
        while(self.i < len(s)):
            c = s[self.i]
            if c.isdigit():
                num = num * 10 + int(c)
                self.i += 1
            elif c == '[':
                self.i += 1
                inner = self.decodeString(s)
                b = []
                for i in range(0, num):
                    b.append(inner)
                cur.append("".join(b))
                num = 0
                
            elif c == ']':
                self.i += 1
                return "".join(cur)
            else:
                cur.append(c)
                self.i += 1
        return "".join(cur)